package com.kooing.service.order;

import com.kooing.api.order.OrderApi;
import com.kooing.common.PageUtil;
import com.kooing.common.Pagination;
import com.kooing.dao.goods.TbGoodsMapper;
import com.kooing.dao.order.TbOdmOrderGoodsMapper;
import com.kooing.dao.order.TbOdmOrderMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.order.TbOdmOrderRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.order.OrderItemResponse;
import com.kooing.param.response.order.TbOdmOrderResponse;
import com.kooing.pojo.goods.TbGoods;
import com.kooing.pojo.order.TbOdmOrder;
import com.kooing.pojo.order.TbOdmOrderGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author : kooing
 * @date : 2018/3/25 - 13:37
 * @desription :
 * @update by :
 */
@Service
public class OrderService implements OrderApi {

    @Autowired
    TbOdmOrderMapper tbOdmOrderMapper;
    @Autowired
    TbOdmOrderGoodsMapper tbOdmOrderGoodsMapper;
    @Autowired
    TbGoodsMapper tbGoodsMapper;

    @Override
    public SuccessResponse<List<TbOdmOrderResponse>> findOrder(DataRequest<TbOdmOrderRequest> data)  {
        PageUtil.startPage(data);
        List<TbOdmOrderResponse> list = tbOdmOrderMapper.findOrder(data.getBody());
        for(TbOdmOrderResponse tbOdmOrderResp : list){
            //这里long转int了，可能以后会有bug
            List<OrderItemResponse> orderItemResponse = tbOdmOrderGoodsMapper.findGoodsItem
                    (tbOdmOrderResp.getOrderSn());
            tbOdmOrderResp.setGoodsList(orderItemResponse);
        }
        Pagination pagination = new Pagination(list);
        return new SuccessResponse<List<TbOdmOrderResponse>>(pagination, list);
    }

    @Override
    public SuccessResponse<Object> addOrder(DataRequest<TbOdmOrderRequest> data)  {
        TbOdmOrderRequest tbOdmOrderReq = data.getBody();
        tbOdmOrderReq.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        tbOdmOrderReq.setAddTime(new Date(System.currentTimeMillis()));
        tbOdmOrderReq.setOrderState(1);
        //订单生成算法（时间戳+3位随机uuid）
        tbOdmOrderReq.setOrderSn(System.currentTimeMillis() + UUID.randomUUID().toString().substring(0,3));
        //添加商品到订单
        List<TbOdmOrderGoods> goodsList = tbOdmOrderReq.getGoodsList();
        for(TbOdmOrderGoods tbOdmOrderGoods : goodsList){
            //添加订单项
            tbOdmOrderGoods.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
            tbOdmOrderGoods.setOrderId(tbOdmOrderReq.getOrderSn());
            tbOdmOrderGoodsMapper.insertSelective(tbOdmOrderGoods);
            //复制当前单价
            tbOdmOrderGoodsMapper.copyPrice(tbOdmOrderGoods.getGoodsId());
            //减少库存，增加销量
            tbGoodsMapper.decrease(tbOdmOrderGoods);
            //若数量为0，改已售完状态
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(tbOdmOrderGoods.getGoodsId());
            if(tbGoods.getGoodsStorage() == 0){
                tbGoods.setGoodsState(1);
                tbGoodsMapper.updateByPrimaryKeySelective(tbGoods);
            }
        }
        tbOdmOrderReq.setOrderAmount(tbOdmOrderMapper.getAmout(tbOdmOrderReq));
        //添加订单
        tbOdmOrderMapper.insertSelective(tbOdmOrderReq);
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> updateOrder(DataRequest<TbOdmOrderRequest> data)  {
        tbOdmOrderMapper.updateByPrimaryKeySelective(data.getBody());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> deleteOrder(DataRequest<TbOdmOrderRequest> data)  {
        TbOdmOrderRequest tbOdmOrderReq = data.getBody();
        tbOdmOrderMapper.deleteByPrimaryKey(tbOdmOrderReq.getOrderId());
        tbOdmOrderGoodsMapper.deleteByOrderSn(tbOdmOrderReq.getOrderSn());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<TbOdmOrderResponse> getOrder(DataRequest<TbOdmOrderRequest> data) {
        //这里long转int了，可能以后会有bug
        TbOdmOrderResponse tbOdmOrderResp = tbOdmOrderMapper.getOrder(data.getBody());
        List<OrderItemResponse> orderItemResponse = tbOdmOrderGoodsMapper.findGoodsItem
                (tbOdmOrderResp.getOrderSn());
        tbOdmOrderResp.setGoodsList(orderItemResponse);
        return new SuccessResponse<TbOdmOrderResponse>(tbOdmOrderResp);
    }

    @Override
    public SuccessResponse<List<TbOdmOrderResponse>> findOrderByPhone(DataRequest<TbOdmOrderRequest> data) {
        List<TbOdmOrderResponse> list = tbOdmOrderMapper.findOrder(data.getBody());
        return new SuccessResponse<List<TbOdmOrderResponse>>(list);
    }


}

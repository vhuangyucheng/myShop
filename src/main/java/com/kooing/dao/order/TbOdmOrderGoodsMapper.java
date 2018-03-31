package com.kooing.dao.order;

import com.kooing.param.response.order.OrderItemResponse;
import com.kooing.pojo.order.TbOdmOrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbOdmOrderGoodsMapper {
    int deleteByPrimaryKey(Long recId);

    int insert(TbOdmOrderGoods record);

    int insertSelective(TbOdmOrderGoods record);

    TbOdmOrderGoods selectByPrimaryKey(Long recId);

    int updateByPrimaryKeySelective(TbOdmOrderGoods record);

    int updateByPrimaryKey(TbOdmOrderGoods record);

    List<OrderItemResponse> findGoodsItem(String orderId);

    int deleteByOrderSn(String orderSn);

    /**
     * @author      : kooing
     * @Date        : 2018/3/27 11:14
     * @Desription  : 复制单价，记住当前单价
     * @return      :
     */
    int copyPrice(Integer goodsId);
}
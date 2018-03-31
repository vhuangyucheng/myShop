package com.kooing.api.order;

import com.kooing.param.request.DataRequest;
import com.kooing.param.request.order.TbOdmOrderRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.order.TbOdmOrderResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 13:33
 * @desription :
 * @update by :
 */
public interface OrderApi {
    /**
     * @author      : kooing
     * @Date        : 2017/11/14 22:18
     * @Desription  : 返回订单列表
     * @return      : code,message,pagination,list
     */
    public SuccessResponse<List<TbOdmOrderResponse>> findOrder(DataRequest<TbOdmOrderRequest> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/20 23:12
     * @Desription  : 添加订单接口
     * @return      : code,message
     */
    public SuccessResponse<Object> addOrder(DataRequest<TbOdmOrderRequest> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/21 16:42
     * @Desription  : 修改订单接口,暂时用来修改订单状态，若后面业务有修改商品，再作维护
     * @return      : code,message
     */
    public SuccessResponse<Object> updateOrder(DataRequest<TbOdmOrderRequest> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/21 16:47
     * @Desription  : 删除订单
     * @return      : code,message
     */
    public SuccessResponse<Object> deleteOrder(DataRequest<TbOdmOrderRequest> data) ;

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 14:41
     * @Desription  : 根据id获取一条订单
     * @return      :
     */
    public SuccessResponse<TbOdmOrderResponse> getOrder(DataRequest<TbOdmOrderRequest> data) ;
    /**
     * @author      : kooing
     * @Date        : 2017/11/14 22:18
     * @Desription  : 手机返回订单列表
     * @return      : code,message,pagination,list
     */
    public SuccessResponse<List<TbOdmOrderResponse>> findOrderByPhone(DataRequest<TbOdmOrderRequest> data) ;

}

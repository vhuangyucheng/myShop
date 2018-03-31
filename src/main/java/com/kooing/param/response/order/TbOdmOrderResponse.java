package com.kooing.param.response.order;


import com.kooing.pojo.order.TbOdmOrder;
import com.kooing.pojo.order.TbOdmOrderGoods;
import lombok.Data;

import java.util.List;

/**
 * @author : kooing
 * @date : 2017/11/20 - 19:32
 * @desription : 订单类包装的响应类
 * @update by :
 */
@Data
public class TbOdmOrderResponse extends TbOdmOrder {
    /** 订单货物列表*/
    private List<OrderItemResponse> goodsList;
}

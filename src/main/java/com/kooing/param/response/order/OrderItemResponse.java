package com.kooing.param.response.order;

import com.kooing.pojo.order.TbOdmOrderGoods;
import lombok.Data;

/**
 * @author : kooing
 * @date : 2018/3/26 - 22:46
 * @desription :
 * @update by :
 */
@Data
public class OrderItemResponse extends TbOdmOrderGoods{
    double ItemAmout;
}

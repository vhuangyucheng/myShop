package com.kooing.param.request.order;

import com.kooing.pojo.order.TbOdmOrder;
import com.kooing.pojo.order.TbOdmOrderGoods;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : kooing
 * @date : 2017/11/14 - 21:51
 * @desription :tbOdmOrder包装类
 * @update by :
 */
@Data
public class TbOdmOrderRequest extends TbOdmOrder{
    /** 订单查询的时间区间*/
    private Date beginTime;
    private Date endTime;
    /** 订单货物列表*/
    private List<TbOdmOrderGoods> goodsList;
}

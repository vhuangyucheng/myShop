package com.kooing.dao.order;

import com.kooing.param.request.order.TbOdmOrderRequest;
import com.kooing.param.response.order.TbOdmOrderResponse;
import com.kooing.pojo.order.TbOdmOrder;
import com.kooing.pojo.order.TbOdmOrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbOdmOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(TbOdmOrder record);

    int insertSelective(TbOdmOrder record);

    TbOdmOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(TbOdmOrder record);

    int updateByPrimaryKey(TbOdmOrder record);

    List<TbOdmOrderResponse> findOrder(TbOdmOrderRequest tbOdmOrderReq);

    TbOdmOrderResponse getOrder(TbOdmOrderRequest tbOdmOrderRequest);

    /**
     * @author      : kooing
     * @Date        : 2018/3/27 9:33
     * @Desription  : 获得总价
     * @return      :
     */
    Double getAmout(TbOdmOrderRequest tbOdmOrderRequest);
}
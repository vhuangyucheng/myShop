package com.kooing.controller.order;

import com.kooing.api.order.OrderApi;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.order.TbOdmOrderRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.order.TbOdmOrderResponse;
import com.kooing.pojo.member.TbUrsMember;
import com.kooing.pojo.order.TbOdmOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 14:29
 * @desription :
 * @update by :
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderApi orderApi;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> addMember(@RequestBody DataRequest<TbOdmOrderRequest> dataRequest) {
        return orderApi.addOrder(dataRequest);
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> deleteOrder(@RequestBody DataRequest<TbOdmOrderRequest> dataRequest) {
        return orderApi.deleteOrder(dataRequest);
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> updateMember(@RequestBody DataRequest<TbOdmOrderRequest> dataRequest) {
        return orderApi.updateOrder(dataRequest);
    }

    @RequestMapping(value = "/findOrder", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<TbOdmOrderResponse>> findMember(@RequestBody DataRequest<TbOdmOrderRequest> dataRequest) {
        return orderApi.findOrder(dataRequest);
    }

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<TbOdmOrderResponse> getMember(@RequestBody DataRequest<TbOdmOrderRequest> dataRequest) {
        return orderApi.getOrder(dataRequest);
    }

    @RequestMapping(value = "/findOrderByPhone", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<TbOdmOrderResponse>> findOrderByPhone(@RequestBody DataRequest<TbOdmOrderRequest> dataRequest) {
        return orderApi.findOrderByPhone(dataRequest);
    }
}
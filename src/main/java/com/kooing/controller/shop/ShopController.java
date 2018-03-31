package com.kooing.controller.shop;

import com.kooing.api.order.OrderApi;
import com.kooing.api.shop.ShopApi;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.order.TbOdmOrderRequest;
import com.kooing.param.request.shop.UpdatePasswordRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.shop.ShopResponse;
import com.kooing.pojo.shop.TbShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/26 - 16:57
 * @desription :
 * @update by :
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopApi shopApi;

    @RequestMapping(value = "/addShop", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> addMember(@RequestBody DataRequest<TbShop> dataRequest) {
        return shopApi.addShop(dataRequest);
    }

    @RequestMapping(value = "/findShop", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<TbShop>> findShop(@RequestBody DataRequest<TbShop> dataRequest) {
        return shopApi.findShop(dataRequest);
    }

    @RequestMapping(value = "/getShop", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<ShopResponse>> getShop(@RequestBody DataRequest<TbShop> dataRequest) {
        return shopApi.getShop(dataRequest);
    }

    @RequestMapping(value = "/checkShop", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<TbShop> checkShop(@RequestBody DataRequest<TbShop> dataRequest) {
        return shopApi.checkShop(dataRequest);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> updatePassword(@RequestBody DataRequest<UpdatePasswordRequest> dataRequest) {
        return shopApi.updataPassword(dataRequest);
    }

    @RequestMapping(value = "/getShopByMac", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<TbShop> getShopBuMac(@RequestBody DataRequest<TbShop> dataRequest) {
        return shopApi.getShopByMac(dataRequest);
    }

    @RequestMapping(value = "/openShop", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> openShop(@RequestBody DataRequest<TbShop> dataRequest) {
        return shopApi.openShop(dataRequest);
    }
}

package com.kooing.controller.goods;

import com.kooing.api.goods.GoodsApi;
import com.kooing.api.goods.GoodsClassApi;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.goods.TbGoodsRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.pojo.goods.TbGoods;
import com.kooing.pojo.goods.TbGoodsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 10:01
 * @desription :
 * @update by :
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsApi goodsApi;

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> addGoods(@RequestBody DataRequest<TbGoods> dataRequest) {
        return goodsApi.addGoods(dataRequest);
    }

    @RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> deleteGoods(@RequestBody DataRequest<TbGoods> dataRequest) {
        return goodsApi.deleteGoods(dataRequest);
    }

    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> updateGoods(@RequestBody DataRequest<TbGoods> dataRequest) {
        return goodsApi.updateGoods(dataRequest);
    }

    @RequestMapping(value = "/findGoods", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<TbGoods>> findGoods(@RequestBody DataRequest<TbGoodsRequest> dataRequest) {
        return goodsApi.findGoods(dataRequest);
    }

    @RequestMapping(value = "/getGoods", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<TbGoods> getGoods(@RequestBody DataRequest<TbGoodsRequest> dataRequest) {
        return goodsApi.getGoods(dataRequest);
    }
}

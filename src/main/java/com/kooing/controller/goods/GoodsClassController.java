package com.kooing.controller.goods;

import com.kooing.api.goods.GoodsApi;
import com.kooing.api.goods.GoodsClassApi;
import com.kooing.dao.goods.TbGoodsClassMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.pojo.goods.TbGoodsClass;
import com.kooing.pojo.member.TbUrsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 10:02
 * @desription :
 * @update by :
 */
@Controller
@RequestMapping("/goodsClass")
public class GoodsClassController {
    @Autowired
    GoodsClassApi goodsClassApi;

    @RequestMapping(value = "/addGoodsClass", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> addGoodsClass(@RequestBody DataRequest<TbGoodsClass> dataRequest) {
        return goodsClassApi.addGoodsClass(dataRequest);
    }

    @RequestMapping(value = "/deleteGoodsClass", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> deleteGoodsClass(@RequestBody DataRequest<TbGoodsClass> dataRequest) {
        return goodsClassApi.deleteGoodsClass(dataRequest);
    }

    @RequestMapping(value = "/updateGoodsClass", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> updateGoodsClass(@RequestBody DataRequest<TbGoodsClass> dataRequest) {
        return goodsClassApi.updateGoodsClass(dataRequest);
    }

    @RequestMapping(value = "/findGoodsClass", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<TbGoodsClassResponse>> findGoodsClass(@RequestBody DataRequest<TbGoodsClass> dataRequest) {
        return goodsClassApi.findGoodsClass(dataRequest);
    }

}

package com.kooing.controller.cat;

import com.kooing.api.cat.CatApi;
import com.kooing.dao.cat.TbCatItemMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.cat.CatItemResponse;
import com.kooing.pojo.cat.TbCatItem;
import com.kooing.pojo.goods.TbGoodsClass;
import com.kooing.service.cat.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : kooing
 * @date : 2018/3/26 - 12:00
 * @desription :
 * @update by :
 */
@Controller
@RequestMapping("/cat")
public class CatController {

    @Autowired
    CatApi catApi;

    @RequestMapping(value = "/findCat", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<CatItemResponse> findCat(@RequestBody DataRequest<TbCatItem> dataRequest) {
        return catApi.findCatItem(dataRequest);
    }

    @RequestMapping(value = "/addCat", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<CatItemResponse> addCat(@RequestBody DataRequest<TbCatItem> dataRequest) {
        return catApi.addCatItem(dataRequest);
    }

    @RequestMapping(value = "/deleteCat", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<CatItemResponse> deleteCat(@RequestBody DataRequest<TbCatItem> dataRequest) {
        return catApi.deleteCatItem(dataRequest);
    }

    @RequestMapping(value = "/emptyCat", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> emptyCat(@RequestBody DataRequest<TbCatItem> dataRequest) {
        return catApi.emptyCatItem(dataRequest);
    }
}

package com.kooing.service.cat;

import com.kooing.api.cat.CatApi;
import com.kooing.dao.cat.TbCatItemMapper;
import com.kooing.dao.cat.TbCatMapper;
import com.kooing.dao.goods.TbGoodsMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.cat.CatItemResponse;
import com.kooing.pojo.cat.TbCat;
import com.kooing.pojo.cat.TbCatItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author : kooing
 * @date : 2018/3/25 - 17:42
 * @desription :
 * @update by :
 */
@Service
public class CatService implements CatApi {

    @Autowired
    TbCatItemMapper tbCatItemMapper;
    @Autowired
    TbCatMapper tbCatMapper;
    @Autowired
    TbGoodsMapper tbGoodsMapper;

    @Override
    public SuccessResponse<CatItemResponse> addCatItem(DataRequest<TbCatItem> data) {
        TbCat tbCat = tbCatMapper.getCat(data.getBody());
        //如果没有用过购物车，就先new一个
        if(tbCat == null) {
            tbCat = new TbCat();
            tbCat.setStoreId(data.getBody().getStoreId());
            tbCat.setMemberId(data.getBody().getMemberId());
            tbCat.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
            //订单生成算法（时间戳+3位随机uuid）
            String catSn = System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 3);
            tbCat.setCatSn(catSn);
            //生成购物车
            tbCatMapper.insertSelective(tbCat);
        }
        //查找是否已经有这个订单项
        TbCatItem tbCatItem = tbCatItemMapper.getCatItem(tbCat.getCatSn(), data.getBody().getGoodsId());
        if(tbCatItem == null){
            tbCatItem = new TbCatItem();
            //生成一个购物车项
            tbCatItem.setGoodsNum(data.getBody().getGoodsNum());
            tbCatItem.setGoodsId(data.getBody().getGoodsId());
            tbCatItem.setCatSn(tbCat.getCatSn());
            tbCatItem.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
            tbCatItemMapper.insertSelective(tbCatItem);
        } else {
            //有此项就+数量
            tbCatItem.setGoodsNum(tbCatItem.getGoodsNum() + data.getBody().getGoodsNum());
            tbCatItemMapper.updateByPrimaryKeySelective(tbCatItem);
        }
        return findCatItem(data);
    }

    @Override
    public SuccessResponse<CatItemResponse> deleteCatItem(DataRequest<TbCatItem> data) {
        TbCat tbCat = tbCatMapper.getCat(data.getBody());
        //查找是否已经有这个订单项
        TbCatItem tbCatItem = tbCatItemMapper.getCatItem(tbCat.getCatSn(), data.getBody().getGoodsId());
        tbCatItem.setGoodsNum(tbCatItem.getGoodsNum() - 1);
        tbCatItemMapper.updateByPrimaryKeySelective(tbCatItem);
        return findCatItem(data);
    }

    @Override
    public SuccessResponse<CatItemResponse> findCatItem(DataRequest<TbCatItem> data) {
        List<TbCatItem> catItem = tbCatItemMapper.findCatItem(data.getBody());
        if(catItem.isEmpty()){
            return new SuccessResponse<CatItemResponse>("1", "没有选购任何商品", null);
        }
        double amout = tbCatItemMapper.getAmout(data.getBody());
        CatItemResponse catItemResponse = new CatItemResponse();
        catItemResponse.setTiemList(catItem);
        catItemResponse.setCatAmout(amout);
        return new SuccessResponse<CatItemResponse>(catItemResponse);
    }

    @Override
    public SuccessResponse<Object> emptyCatItem(DataRequest<TbCatItem> data) {
        tbCatItemMapper.emptyCatItem(data.getBody());
        return new SuccessResponse<Object>(null);
    }
}

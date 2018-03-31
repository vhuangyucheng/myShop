package com.kooing.service.shop;

import com.kooing.api.shop.ShopApi;
import com.kooing.dao.goods.TbGoodsClassMapper;
import com.kooing.dao.goods.TbGoodsMapper;
import com.kooing.dao.shop.TbShopMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.goods.TbGoodsRequest;
import com.kooing.param.request.shop.UpdatePasswordRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.param.response.shop.ShopResponse;
import com.kooing.pojo.goods.TbGoods;
import com.kooing.pojo.goods.TbGoodsClass;
import com.kooing.pojo.shop.TbShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author : kooing
 * @date : 2018/3/26 - 16:55
 * @desription :
 * @update by :
 */
@Service
public class ShopService implements ShopApi {

    @Autowired
    TbShopMapper tbShopMapper;
    @Autowired
    TbGoodsClassMapper tbGoodsClassMapper;
    @Autowired
    TbGoodsMapper tbGoodsMapper;

    @Override
    public SuccessResponse<Object> addShop(DataRequest<TbShop> data) {
        TbShop tbShop = data.getBody();
        tbShop.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        tbShopMapper.insertSelective(tbShop);
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<List<TbShop>> findShop(DataRequest<TbShop> data) {
        List<TbShop> tbShopList = tbShopMapper.findShop(data.getBody());
        return new SuccessResponse<List<TbShop>>(tbShopList);
    }

    @Override
    public SuccessResponse<List<ShopResponse>> getShop(DataRequest<TbShop> data) {
        List<ShopResponse> shopResponseList = tbGoodsClassMapper.getTbGoodsClassParentList2(data.getBody().getStoreId().intValue());
        for(ShopResponse shopResponse : shopResponseList){
            TbGoodsRequest tbGoods = new TbGoodsRequest();
            tbGoods.setGcId(shopResponse.getGcId());
            List<TbGoods> goodsList = tbGoodsMapper.findGoods(tbGoods);
            shopResponse.setGoodsList(goodsList);
        }
        return new SuccessResponse<List<ShopResponse>>(shopResponseList);
    }

    @Override
    public SuccessResponse<TbShop> checkShop(DataRequest<TbShop> data) {
        TbShop tbShop = tbShopMapper.checkShop(data.getBody());
        if(tbShop == null){
            return new SuccessResponse<TbShop>("1", "账号密码错误", null);
        }
        return new SuccessResponse<TbShop>(tbShop);
    }

    @Override
    public SuccessResponse<Object> updataPassword(DataRequest<UpdatePasswordRequest> data) {
        TbShop tbShop = tbShopMapper.checkShop(data.getBody());
        if(tbShop == null){
            return new SuccessResponse<Object>("1", "账号密码错误", null);
        }
        tbShop.setStorePassword(data.getBody().getNewPassword());
        tbShopMapper.updateByPrimaryKeySelective(tbShop);
        return new SuccessResponse<Object>("0", "成功", null);
    }

    @Override
    public SuccessResponse<TbShop> getShopByMac(DataRequest<TbShop> data) {
        TbShop shop = tbShopMapper.getShop(data.getBody());
        return new SuccessResponse<TbShop>(shop);
    }

    @Override
    public SuccessResponse<Object> openShop(DataRequest<TbShop> data) {
        tbShopMapper.updateByPrimaryKeySelective(data.getBody());
        return new SuccessResponse<Object>("0", "成功", null);
    }
}

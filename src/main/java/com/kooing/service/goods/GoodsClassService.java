package com.kooing.service.goods;

import com.kooing.api.goods.GoodsApi;
import com.kooing.api.goods.GoodsClassApi;
import com.kooing.dao.goods.TbGoodsClassMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.pojo.goods.TbGoodsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author : kooing
 * @date : 2018/3/25 - 10:18
 * @desription :
 * @update by :
 */
@Service
public class GoodsClassService implements GoodsClassApi{
    @Autowired
    TbGoodsClassMapper tbGoodsClassMapper;

    @Override
    public SuccessResponse<List<TbGoodsClassResponse>> findGoodsClass(DataRequest<TbGoodsClass> data)  {
        List<TbGoodsClassResponse> list = tbGoodsClassMapper.getTbGoodsClassParentList(data.getBody().getStoreId());
        for(TbGoodsClassResponse tbGoodsClassResp : list){
            tbGoodsClassResp.setChildList(tbGoodsClassMapper.getTbGoodsClassChildList(tbGoodsClassResp.getGcId(), data.getBody().getStoreId()));
        }
        return new SuccessResponse<List<TbGoodsClassResponse>>(list);
    }

    @Override
    public SuccessResponse<Object> addGoodsClass(DataRequest<TbGoodsClass> data) {
        TbGoodsClass tbGoodsClass = data.getBody();
        tbGoodsClass.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        tbGoodsClassMapper.insertSelective(tbGoodsClass);
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> updateGoodsClass(DataRequest<TbGoodsClass> data) {
        tbGoodsClassMapper.updateByPrimaryKeySelective(data.getBody());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> deleteGoodsClass(DataRequest<TbGoodsClass> data) {
        tbGoodsClassMapper.deleteByPrimaryKey(data.getBody().getGcId());
        return new SuccessResponse<Object>(null);
    }
}

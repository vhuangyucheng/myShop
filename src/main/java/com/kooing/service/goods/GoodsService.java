package com.kooing.service.goods;

import com.kooing.api.goods.GoodsApi;
import com.kooing.common.PageUtil;
import com.kooing.common.Pagination;
import com.kooing.dao.goods.TbGoodsMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.goods.TbGoodsRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.pojo.goods.TbGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author : kooing
 * @date : 2018/3/25 - 12:20
 * @desription :
 * @update by :
 */
@Service
public class GoodsService implements GoodsApi {
    @Autowired
    TbGoodsMapper tbGoodsMapper;

    @Override
    public SuccessResponse<Object> addGoods(DataRequest<TbGoods> data) {
        TbGoods tbGoods = data.getBody();
        tbGoods.setGoodsSale(0);
        tbGoods.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        tbGoods.setGoodsTime(new Date(System.currentTimeMillis()));
        tbGoodsMapper.insertSelective(tbGoods);
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<List<TbGoods>> findGoods(DataRequest<TbGoodsRequest> data) {
        PageUtil.startPage(data);
        List<TbGoods> list = tbGoodsMapper.findGoods(data.getBody());
        Pagination pagination = new Pagination(list);
        return new SuccessResponse<List<TbGoods>>("0", "ok", pagination, list);
    }

    @Override
    public SuccessResponse<Object> deleteGoods(DataRequest<TbGoods> data) {
        tbGoodsMapper.deleteByPrimaryKey(data.getBody().getGoodsId());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> updateGoods(DataRequest<TbGoods> data) {
        tbGoodsMapper.updateByPrimaryKeySelective(data.getBody());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<TbGoods> getGoods(DataRequest<TbGoodsRequest> data) {
        TbGoods tbGoods = tbGoodsMapper.getGoods(data.getBody());
        return new SuccessResponse<TbGoods>(tbGoods);
    }
}

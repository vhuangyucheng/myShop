package com.kooing.dao.goods;

import com.kooing.param.request.goods.TbGoodsRequest;
import com.kooing.pojo.goods.TbGoods;
import com.kooing.pojo.order.TbOdmOrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbGoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(TbGoods record);

    int insertSelective(TbGoods record);

    TbGoods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(TbGoods record);

    int updateByPrimaryKey(TbGoods record);

    List<TbGoods> findGoods(TbGoodsRequest tbGoodsReq);

    void decrease(TbOdmOrderGoods tbOdmOrderGoods);

    /**
     * @author      : kooing
     * @Date        : 2018/3/28 11:27
     * @Desription  : 获得一个商品
     * @return      :
     */
    TbGoods getGoods(TbGoods record);


}
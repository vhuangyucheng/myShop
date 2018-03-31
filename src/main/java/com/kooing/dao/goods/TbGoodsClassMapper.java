package com.kooing.dao.goods;

import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.param.response.shop.ShopResponse;
import com.kooing.pojo.goods.TbGoodsClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbGoodsClassMapper {
    int deleteByPrimaryKey(Integer gcId);

    int insert(TbGoodsClass record);

    int insertSelective(TbGoodsClass record);

    TbGoodsClass selectByPrimaryKey(Integer gcId);

    int updateByPrimaryKeySelective(TbGoodsClass record);

    int updateByPrimaryKey(TbGoodsClass record);


    /**
     * @author      : kooing
     * @Date        : 2018/3/28 9:32
     * @Desription  : 获得一级分类
     * @return      :
     */
    List<TbGoodsClassResponse> getTbGoodsClassParentList(@Param("storeId")Integer storeId);

    /**
     * @author      : kooing
     * @Date        : 2018/3/28 9:32
     * @Desription  : 获得一级分类，手机端
     * @return      :
     */

    List<ShopResponse> getTbGoodsClassParentList2(@Param("storeId")Integer storeId);

    List<TbGoodsClassResponse> getTbGoodsClassChildList(@Param("gcId") Integer gcId, @Param("storeId") Integer storeId);

}
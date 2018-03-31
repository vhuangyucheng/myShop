package com.kooing.dao.cat;

import com.kooing.pojo.cat.TbCatItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbCatItemMapper {
    int deleteByPrimaryKey(Long catRecId);

    int insert(TbCatItem record);

    int insertSelective(TbCatItem record);

    TbCatItem selectByPrimaryKey(Long catRecId);

    int updateByPrimaryKeySelective(TbCatItem record);

    int updateByPrimaryKey(TbCatItem record);

    TbCatItem getCatItem(@Param("catSn")String cat_sn, @Param("goodsId")int goodsId);

    List<TbCatItem>  findCatItem(TbCatItem tbCatItem);

    Double getAmout(TbCatItem tbCatItem);

    void emptyCatItem(TbCatItem tbCatItem);
}
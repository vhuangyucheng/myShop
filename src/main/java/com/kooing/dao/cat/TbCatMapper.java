package com.kooing.dao.cat;

import com.kooing.pojo.cat.TbCat;
import com.kooing.pojo.cat.TbCatItem;
import org.springframework.stereotype.Repository;

@Repository
public interface TbCatMapper {
    int deleteByPrimaryKey(Long catId);

    int insert(TbCat record);

    int insertSelective(TbCat record);

    TbCat selectByPrimaryKey(Long catId);

    int updateByPrimaryKeySelective(TbCat record);

    int updateByPrimaryKey(TbCat record);

    TbCat getCat(TbCatItem tbCatItem);

}
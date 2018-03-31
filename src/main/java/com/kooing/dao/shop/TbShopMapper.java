package com.kooing.dao.shop;

import com.kooing.pojo.shop.TbShop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbShopMapper {
    int deleteByPrimaryKey(Long storeId);

    int insert(TbShop record);

    int insertSelective(TbShop record);

    TbShop selectByPrimaryKey(Long storeId);

    int updateByPrimaryKeySelective(TbShop record);

    int updateByPrimaryKeyWithBLOBs(TbShop record);

    int updateByPrimaryKey(TbShop record);


    /**
     * @author      : kooing
     * @Date        : 2018/3/27 20:55
     * @Desription  : 商家列表(手机
     * @return      :
     */
    List<TbShop> findShop(TbShop tbShop);

    /**
     * @author      : kooing
     * @Date        : 2018/3/27 20:54
     * @Desription  : 检查商家登陆
     * @return      :
     */
    TbShop checkShop(TbShop tbShop);

    /**
     * @author      : kooing
     * @Date        : 2018/3/29 21:24
     * @Desription  : 获得单个商家（手机端
     * @return      :
     */
    TbShop getShop(TbShop tbShop);
}
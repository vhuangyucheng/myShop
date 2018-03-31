package com.kooing.param.response.goods;

import com.kooing.pojo.goods.TbGoodsClass;
import lombok.Data;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 10:06
 * @desription :
 * @update by :
 */
@Data
public class TbGoodsClassResponse extends TbGoodsClass{
    /** 子类标签list*/
    private List<TbGoodsClassResponse> childList;
    /** 标签下商品数量*/
    private Integer goodsNum;

}

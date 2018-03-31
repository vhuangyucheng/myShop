package com.kooing.param.response.shop;

import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.pojo.goods.TbGoods;
import lombok.Data;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/26 - 17:57
 * @desription :
 * @update by :
 */
@Data
public class ShopResponse extends TbGoodsClassResponse {
    List<TbGoods> goodsList;
}

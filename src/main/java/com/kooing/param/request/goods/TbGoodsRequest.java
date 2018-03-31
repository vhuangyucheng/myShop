package com.kooing.param.request.goods;

import com.kooing.pojo.goods.TbGoods;
import lombok.Data;

/**
 * @author : kooing
 * @date : 2018/3/25 - 11:07
 * @desription :
 * @update by :
 */
@Data
public class TbGoodsRequest extends TbGoods {
    private String orderBy;
    private String desc;
}


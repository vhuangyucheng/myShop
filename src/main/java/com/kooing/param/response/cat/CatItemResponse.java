package com.kooing.param.response.cat;

import com.kooing.pojo.cat.TbCatItem;
import lombok.Data;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/26 - 11:06
 * @desription :
 * @update by :
 */
@Data
public class CatItemResponse {
    Double CatAmout;
    List<TbCatItem> tiemList;
}

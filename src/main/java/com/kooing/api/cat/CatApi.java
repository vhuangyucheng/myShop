package com.kooing.api.cat;

import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.cat.CatItemResponse;
import com.kooing.pojo.cat.TbCatItem;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 16:47
 * @desription :
 * @update by :
 */
public interface CatApi {

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 16:47
     * @Desription  : 添加一个购物车项
     * @return      :
     */
    SuccessResponse<CatItemResponse> addCatItem(DataRequest<TbCatItem> data);

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 16:49
     * @Desription  : 删除一个购物车项
     * @return      :
     */
    SuccessResponse<CatItemResponse> deleteCatItem(DataRequest<TbCatItem> data);

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 16:50
     * @Desription  : 展示购物车
     * @return      :
     */
    SuccessResponse<CatItemResponse> findCatItem(DataRequest<TbCatItem> data);

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 16:54
     * @Desription  : 提交订单或情况购物车
     * @return      :
     */
    SuccessResponse<Object> emptyCatItem(DataRequest<TbCatItem> data);
}

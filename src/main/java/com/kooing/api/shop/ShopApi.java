package com.kooing.api.shop;

import com.kooing.param.request.DataRequest;
import com.kooing.param.request.order.TbOdmOrderRequest;
import com.kooing.param.request.shop.UpdatePasswordRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.shop.ShopResponse;
import com.kooing.pojo.shop.TbShop;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/26 - 16:52
 * @desription :
 * @update by :
 */
public interface ShopApi {
    /**
     * @author      : kooing
     * @Date        : 2017/11/20 23:12
     * @Desription  : 添加店铺
     * @return      : code,message
     */
    public SuccessResponse<Object> addShop(DataRequest<TbShop> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/20 23:12
     * @Desription  : 添加店铺
     * @return      : code,message
     */
    public SuccessResponse<List<TbShop>> findShop(DataRequest<TbShop> data) ;


    /**
     * @author      : kooing
     * @Date        : 2018/3/26 18:03
     * @Desription  : 单个商家的货品（手机端
     * @return      :
     */
    public SuccessResponse<List<ShopResponse>> getShop(DataRequest<TbShop> data) ;

    /**
     * @author      : kooing
     * @Date        : 2018/3/27 20:53
     * @Desription  : 检查单个商家(电脑
     * @return      :
     */
    public SuccessResponse<TbShop> checkShop(DataRequest<TbShop> data) ;

    /**
     * @author      : kooing
     * @Date        : 2018/3/29 20:30
     * @Desription  : 修改密码
     * @return      :
     */
    public SuccessResponse<Object> updataPassword(DataRequest<UpdatePasswordRequest> data);

    /**
     * @author      : kooing
     * @Date        : 2018/3/29 21:18
     * @Desription  : 获得单个商家（电脑端，不算商品
     * @return      :
     */
    public SuccessResponse<TbShop> getShopByMac(DataRequest<TbShop> data);

    /**
     * @author      : kooing
     * @Date        : 2018/3/29 21:53
     * @Desription  : 打烊或者开店
     * @return      :
     */
    public SuccessResponse<Object> openShop(DataRequest<TbShop> data);

}

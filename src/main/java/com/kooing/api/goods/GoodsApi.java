package com.kooing.api.goods;

import com.kooing.param.request.DataRequest;
import com.kooing.param.request.goods.TbGoodsRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.pojo.goods.TbGoods;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 10:14
 * @desription :
 * @update by :
 */
public interface GoodsApi {

    /**
     * @author      : kooing
     * @Date        : 2017/11/9 20:58
     * @Desription  : 添加商品
     * @return      : code,message,null
     */
    public SuccessResponse<Object> addGoods(DataRequest<TbGoods> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/9 21:00
     * @Desription  : 返回商品列表
     * @return      : code,message,pagination,list
     */
    public SuccessResponse<List<TbGoods>> findGoods(DataRequest<TbGoodsRequest> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/12 19:50
     * @Desription  : 根据主键删除
     * @return      : code,message,null
     */
    public SuccessResponse<Object> deleteGoods(DataRequest<TbGoods> data);

    /**
     * @author      : kooing
     * @Date        : 2017/11/12 20:14
     * @Desription  : 根据主键修改商品
     * @return      : code，message，null
     */
    public SuccessResponse<Object> updateGoods(DataRequest<TbGoods> data) ;

    /**
     * @author      : kooing
     * @Date        : 2018/3/28 11:25
     * @Desription  : 获得一个商品
     * @return      :
     */
    public SuccessResponse<TbGoods> getGoods(DataRequest<TbGoodsRequest> data) ;
}

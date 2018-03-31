package com.kooing.api.goods;

import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.param.response.goods.TbGoodsClassResponse;
import com.kooing.pojo.goods.TbGoodsClass;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 10:15
 * @desription :
 * @update by :
 */
public interface GoodsClassApi {

    /**
     * @author      : kooing
     * @Date        : 2017/11/13 12:38
     * @Desription  : 返回分类列表电脑板
     * @return      : code,message,List
     */
    public SuccessResponse<List<TbGoodsClassResponse>> findGoodsClass(DataRequest<TbGoodsClass> data) ;


    /**
     * @author      : kooing
     * @Date        : 2017/11/13 16:28
     * @Desription  : 增加一个分类
     * @return      : code,message,null
     */

    public SuccessResponse<Object> addGoodsClass(DataRequest<TbGoodsClass> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/13 19:35
     * @Desription  : 分类内容修改
     * @return      : code,message,null
     */
    public SuccessResponse<Object> updateGoodsClass(DataRequest<TbGoodsClass> data) ;

    /**
     * @author      : kooing
     * @Date        : 2017/11/13 19:42
     * @Desription  : 根据gcId删除
     * @return      : code,message,null
     */
    public SuccessResponse<Object> deleteGoodsClass(DataRequest<TbGoodsClass> data) ;
}

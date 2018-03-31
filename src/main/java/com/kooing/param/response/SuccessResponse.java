package com.kooing.param.response;

import com.kooing.common.Pagination;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : kooing
 * @date : 2018/3/23 - 23:43
 * @desription :
 * @update by :
 */
@Data
public class SuccessResponse<T> implements Serializable {
    private static final long serialVersionUID = 4610233762558322155L;

    protected String code;//是否成功

    protected String message;//消息

    protected Pagination pagination;//分页

    protected T data;


    /**
     * @author      : kooing
     * @Date        : 2017/11/7 23:29
     * @Desription  : 不配置分页的情况
     * @return      :
     */
    public SuccessResponse(T data){
        code = "0";
        message = "成功";
        pagination = null;
        this.data = data;
    }

    /**
     * @author      : kooing
     * @Date        : 2017/11/7 23:35
     * @Desription  : 配置分页的情况
     * @return      :
     */
    public SuccessResponse(Pagination pagination, T data){
        code = "0";
        message = "成功";
        this.pagination = pagination;
        this.data = data;
    }

    /**
     * @author      : kooing
     * @Date        : 2017/11/7 23:37
     * @Desription  : 自定义code和message，带pagination情况
     * @return      :
     */
    public SuccessResponse(String code, String message, Pagination pagination, T data){
        this.code = code;
        this.message = message;
        this.pagination = pagination;
        this.data = data;
    }

    /**
     * @author      : kooing
     * @Date        : 2017/11/7 23:39
     * @Desription  : 自定义code和message，不带pagination情况
     * @return      :
     */
    public SuccessResponse(String code, String message, T data){
        this.code = code;
        this.message = message;
        this.pagination = null;
        this.data = data;
    }
}

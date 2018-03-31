package com.kooing.param.request;

import lombok.Data;

/**
 * @author : kooing
 * @date : 2018/3/23 - 23:09
 * @desription :
 * @update by :
 */
@Data
public class HeaderRequest {
    /** token*/
    private String token;
    /** 请求来源("mobile","pcShop","pcSys")*/
    private String reqOrg;
    /** 当前页 */
    private String pageNum;
    /** 页行数*/
    private String pageSize;
}

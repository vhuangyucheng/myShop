package com.kooing.common;

import com.github.pagehelper.PageHelper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.request.HeaderRequest;

/**
 * @author : kooing
 * @date : 2017/11/9 - 11:48
 * @desription : page工具
 * @update by :
 */
public class PageUtil {
    public static void startPage(DataRequest<?> data){
        HeaderRequest header = data.getHeader();
        int pageNum = Integer.parseInt(header.getPageNum());
        int pageSize = Integer.parseInt(header.getPageSize());
        PageHelper.startPage(pageNum, pageSize);
    }
}

package com.kooing.param.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : kooing
 * @date : 2018/3/23 - 23:07
 * @desription :
 * @update by :
 */
@Data
public class DataRequest<T> implements Serializable {
    private HeaderRequest header;//公共参数

    private T body;//应用参数
}

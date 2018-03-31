package com.kooing.param.request.shop;

import com.kooing.pojo.shop.TbShop;
import lombok.Data;

/**
 * @author : kooing
 * @date : 2018/3/29 - 20:32
 * @desription :
 * @update by :
 */
@Data
public class UpdatePasswordRequest extends TbShop{
    private String newPassword;
}

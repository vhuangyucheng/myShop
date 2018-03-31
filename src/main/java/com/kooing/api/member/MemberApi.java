package com.kooing.api.member;

import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.pojo.member.TbUrsMember;
import org.springframework.stereotype.Service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 8:43
 * @desription :
 * @update by :
 */
public interface MemberApi {

    /**
     * @author      : kooing
     * @Date        : 2017/11/9 11:13
     * @Desription  : 获得会员列表
     * @return      : 会员列表
     */
    public SuccessResponse<List<TbUrsMember>> findMember(DataRequest<TbUrsMember> data);

    /**
     * @author      : kooing
     * @Date        : 2017/11/9 15:04
     * @Desription  : 增加会员
     * @return      : null列表
     */
    public SuccessResponse<Object> addMember(DataRequest<TbUrsMember> data);

    /**
     * @author      : kooing
     * @Date        : 2017/11/9 15:29
     * @Desription  : 根据主键删除
     * @return      : code,message,null
     */
    public SuccessResponse<Object> deleteMember(DataRequest<TbUrsMember> data);

    /**
     * @author      : kooing
     * @Date        : 2017/11/9 15:40
     * @Desription  : 修改会员信息
     * @return      : code,message,null
     */
    public SuccessResponse<Object> updataMember(DataRequest<TbUrsMember> data) ;


    /**
     * @author      : kooing
     * @Date        : 2018/3/25 8:48
     * @Desription  : 获得一个member
     * @return      :
     */
    public SuccessResponse<TbUrsMember> getMember(DataRequest<TbUrsMember> data) ;
}

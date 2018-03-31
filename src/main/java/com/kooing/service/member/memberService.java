package com.kooing.service.member;

import com.kooing.api.member.MemberApi;
import com.kooing.common.PageUtil;
import com.kooing.common.Pagination;
import com.kooing.dao.member.TbUrsMemberMapper;
import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.pojo.member.TbUrsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author : kooing
 * @date : 2018/3/25 - 8:49
 * @desription :
 * @update by :
 */
@Service
public class memberService implements MemberApi {
    @Autowired
    TbUrsMemberMapper tbUrsMemberMapper;

    @Override
    public SuccessResponse<List<TbUrsMember>> findMember(DataRequest<TbUrsMember> data) {
        PageUtil.startPage(data);
        List<TbUrsMember> list = tbUrsMemberMapper.findMember(data.getBody());
        Pagination pagination = new Pagination(list);
        return new SuccessResponse<List<TbUrsMember>>("0", "ok", pagination, list);
    }

    @Override
    public SuccessResponse<Object> addMember(DataRequest<TbUrsMember> data) {
        TbUrsMember tbUrsMember = data.getBody();
        tbUrsMember.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        tbUrsMember.setMemberRegisterTime(new Date(System.currentTimeMillis()));
        tbUrsMemberMapper.insertSelective(tbUrsMember);
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> deleteMember(DataRequest<TbUrsMember> data) {
        tbUrsMemberMapper.deleteByPrimaryKey(data.getBody().getMemberId());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<Object> updataMember(DataRequest<TbUrsMember> data) {
        tbUrsMemberMapper.updateByPrimaryKeySelective(data.getBody());
        return new SuccessResponse<Object>(null);
    }

    @Override
    public SuccessResponse<TbUrsMember> getMember(DataRequest<TbUrsMember> data) {
        TbUrsMember tbUrsMember = tbUrsMemberMapper.getMember(data.getBody());
        if(tbUrsMember == null){
            return new SuccessResponse<TbUrsMember>("1", "账号密码错误", null);
        }
        return new SuccessResponse<TbUrsMember>(tbUrsMember);
    }
}

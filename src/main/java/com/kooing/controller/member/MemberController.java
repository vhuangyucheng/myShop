package com.kooing.controller.member;

import com.kooing.api.member.MemberApi;
import com.kooing.param.request.DataRequest;
import com.kooing.param.response.SuccessResponse;
import com.kooing.pojo.member.TbUrsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : kooing
 * @date : 2018/3/25 - 8:16
 * @desription :
 * @update by :
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberApi memberApi;

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> addMember(@RequestBody DataRequest<TbUrsMember> dataRequest) {
        return memberApi.addMember(dataRequest);
    }

    @RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> deleteMember(@RequestBody DataRequest<TbUrsMember> dataRequest) {
        return memberApi.deleteMember(dataRequest);
    }

    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<Object> updateMember(@RequestBody DataRequest<TbUrsMember> dataRequest) {
        return memberApi.updataMember(dataRequest);
    }

    @RequestMapping(value = "/findMember", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<List<TbUrsMember>> findMember(@RequestBody DataRequest<TbUrsMember> dataRequest) {
        return memberApi.findMember(dataRequest);
    }

    @RequestMapping(value = "/getMember", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse<TbUrsMember> getMember(@RequestBody DataRequest<TbUrsMember> dataRequest) {
        return memberApi.getMember(dataRequest);
    }
}

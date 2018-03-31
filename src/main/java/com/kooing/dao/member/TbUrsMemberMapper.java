package com.kooing.dao.member;

import com.kooing.pojo.member.TbUrsMember;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbUrsMemberMapper {
    int deleteByPrimaryKey(Long memberId);

    int insert(TbUrsMember record);

    int insertSelective(TbUrsMember record);

    TbUrsMember selectByPrimaryKey(Long memberId);

    int updateByPrimaryKeySelective(TbUrsMember record);

    int updateByPrimaryKeyWithBLOBs(TbUrsMember record);

    int updateByPrimaryKey(TbUrsMember record);

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 8:37
     * @Desription  : 寻找单个会员
     * @return      :
     */
    List<TbUrsMember> findMember(TbUrsMember member);

    /**
     * @author      : kooing
     * @Date        : 2018/3/25 8:37
     * @Desription  : 会员列表
     * @return      :
     */
    TbUrsMember getMember(TbUrsMember member);
}
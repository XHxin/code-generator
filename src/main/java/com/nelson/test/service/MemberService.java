package com.nelson.test.service;

import com.nelson.test.base.BaseService;
import com.nelson.test.core.result.Result;
import com.nelson.test.dto.member.MemberListDTO;
import com.nelson.test.dto.member.MemberSaveDTO;
import com.nelson.test.dao.model.Member;
import com.nelson.test.dao.model.MemberExample;

/**
* MemberService接口
* Created by Nelson on 2020/1/8.
*/
public interface MemberService extends BaseService<Member, MemberExample> {

    Result saveMember(MemberSaveDTO dto);

    Result deleteMember(Integer id);

    Result getMember(Integer id);

    Result listMember(MemberListDTO dto, int pageNo, int pageSize);

    Result updateMember(Integer id, MemberUpdateDTO dto);
}
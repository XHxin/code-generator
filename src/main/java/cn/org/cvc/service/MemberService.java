package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.member.MemberListDTO;
import cn.org.cvc.dto.member.MemberSaveDTO;
import cn.org.cvc.dto.member.MemberUpdateDTO;

/**
* MemberService接口
* Created by Nelson on 2020/4/7.
*/
public interface MemberService {

    Result saveMember(MemberSaveDTO dto);

    Result deleteMember(Integer id);

    Result getMember(Integer id);

    Result listMember(MemberListDTO dto, int pageNo, int pageSize);

    Result updateMember(Integer id, MemberUpdateDTO dto);
}
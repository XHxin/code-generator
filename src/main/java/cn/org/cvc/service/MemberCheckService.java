package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.memberCheck.MemberCheckListDTO;
import cn.org.cvc.dto.memberCheck.MemberCheckSaveDTO;
import cn.org.cvc.dto.memberCheck.MemberCheckUpdateDTO;

/**
* MemberCheckService接口
* Created by Nelson on 2020/4/7.
*/
public interface MemberCheckService {

    Result saveMemberCheck(MemberCheckSaveDTO dto);

    Result deleteMemberCheck(Integer id);

    Result getMemberCheck(Integer id);

    Result listMemberCheck(MemberCheckListDTO dto, int pageNo, int pageSize);

    Result updateMemberCheck(Integer id, MemberCheckUpdateDTO dto);
}
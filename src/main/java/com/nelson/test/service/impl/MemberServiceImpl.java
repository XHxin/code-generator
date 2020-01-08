package com.nelson.test.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nelson.test.dto.member.MemberListDTO;
import com.nelson.test.dto.member.MemberSaveDTO;
import com.nelson.test.annotation.BaseService;
import com.nelson.test.base.BaseServiceImpl;
import com.nelson.test.dao.mapper.MemberMapper;
import com.nelson.test.dao.model.Member;
import com.nelson.test.dao.model.MemberExample;
import com.nelson.test.service.MemberService;
import com.nelson.test.core.enums.ResultEnum;
import com.nelson.test.core.result.Result;
import com.nelson.test.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* MemberService实现
* Created by Nelson on 2020/1/8.
*/
@Service
@Transactional
@BaseService
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, Member, MemberExample> implements MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    MemberMapper memberMapper;

    @Override
    public Result saveMember(MemberSaveDTO dto) {
        //TODO 封装Member

        Member member = new Member();
        BenUtils.copyProperties(dto, member);
        if(memberMapper.insert(member) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteMember(Integer id) {
        if(memberMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getMember(Integer id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        if(member != null) {
            //TODO 封装返回的内容
            MemberVO result = new MemberVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listMember(MemberListDTO dto, int pageNo, int pageSize) {
        Page<Member> page = PageHelper.startPage(pageNo, pageSize);
        List<Member> members = memberMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateMember(Integer id, MemberUpdateDTO dto) {
        Member member = memberMapper.selectByPrimaryKey(id);
        if(member != null) {
            //TODO 设值

            if(memberMapper.updateByPrimaryKeySelective(member) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
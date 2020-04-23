package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.member.MemberListDTO;
import cn.org.cvc.dto.member.MemberSaveDTO;
import cn.org.cvc.dto.member.MemberUpdateDTO;
import cn.org.cvc.vo.member.MemberVO;
import cn.org.cvc.mapper.MemberMapper;
import cn.org.cvc.model.Member;
import cn.org.cvc.model.MemberExample;
import cn.org.cvc.service.MemberService;
import cn.org.cvc.core.enums.ResultEnum;
import cn.org.cvc.core.resp.Result;
import cn.org.cvc.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* MemberService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    MemberMapper memberMapper;

    @Override
    public Result saveMember(MemberSaveDTO dto) {
        //TODO 封装Member

        Member member = new Member();
        BeanUtils.copyProperties(dto, member);
        if(memberMapper.insert(member) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteMember(Integer id) {
        if(memberMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getMember(Integer id) {
        Member member = memberMapper.selectById(id);
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
        //List<Member> members = memberMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateMember(Integer id, MemberUpdateDTO dto) {
        Member member = memberMapper.selectById(id);
        if(member != null) {
            //TODO 设值

            if(memberMapper.updateById(member) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
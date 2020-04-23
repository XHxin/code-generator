package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.memberCheck.MemberCheckListDTO;
import cn.org.cvc.dto.memberCheck.MemberCheckSaveDTO;
import cn.org.cvc.dto.memberCheck.MemberCheckUpdateDTO;
import cn.org.cvc.vo.memberCheck.MemberCheckVO;
import cn.org.cvc.mapper.MemberCheckMapper;
import cn.org.cvc.model.MemberCheck;
import cn.org.cvc.model.MemberCheckExample;
import cn.org.cvc.service.MemberCheckService;
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
* MemberCheckService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class MemberCheckServiceImpl implements MemberCheckService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberCheckServiceImpl.class);

    @Autowired
    MemberCheckMapper memberCheckMapper;

    @Override
    public Result saveMemberCheck(MemberCheckSaveDTO dto) {
        //TODO 封装MemberCheck

        MemberCheck memberCheck = new MemberCheck();
        BeanUtils.copyProperties(dto, memberCheck);
        if(memberCheckMapper.insert(memberCheck) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteMemberCheck(Integer id) {
        if(memberCheckMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getMemberCheck(Integer id) {
        MemberCheck memberCheck = memberCheckMapper.selectById(id);
        if(memberCheck != null) {
            //TODO 封装返回的内容
            MemberCheckVO result = new MemberCheckVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listMemberCheck(MemberCheckListDTO dto, int pageNo, int pageSize) {
        Page<MemberCheck> page = PageHelper.startPage(pageNo, pageSize);
        //List<MemberCheck> memberChecks = memberCheckMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateMemberCheck(Integer id, MemberCheckUpdateDTO dto) {
        MemberCheck memberCheck = memberCheckMapper.selectById(id);
        if(memberCheck != null) {
            //TODO 设值

            if(memberCheckMapper.updateById(memberCheck) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
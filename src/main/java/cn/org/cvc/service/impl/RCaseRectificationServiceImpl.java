package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationListDTO;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationSaveDTO;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationUpdateDTO;
import cn.org.cvc.vo.rCaseRectification.RCaseRectificationVO;
import cn.org.cvc.mapper.RCaseRectificationMapper;
import cn.org.cvc.model.RCaseRectification;
import cn.org.cvc.model.RCaseRectificationExample;
import cn.org.cvc.service.RCaseRectificationService;
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
* RCaseRectificationService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class RCaseRectificationServiceImpl implements RCaseRectificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RCaseRectificationServiceImpl.class);

    @Autowired
    RCaseRectificationMapper rCaseRectificationMapper;

    @Override
    public Result saveRCaseRectification(RCaseRectificationSaveDTO dto) {
        //TODO 封装RCaseRectification

        RCaseRectification rCaseRectification = new RCaseRectification();
        BeanUtils.copyProperties(dto, rCaseRectification);
        if(rCaseRectificationMapper.insert(rCaseRectification) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteRCaseRectification(Integer id) {
        if(rCaseRectificationMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getRCaseRectification(Integer id) {
        RCaseRectification rCaseRectification = rCaseRectificationMapper.selectById(id);
        if(rCaseRectification != null) {
            //TODO 封装返回的内容
            RCaseRectificationVO result = new RCaseRectificationVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listRCaseRectification(RCaseRectificationListDTO dto, int pageNo, int pageSize) {
        Page<RCaseRectification> page = PageHelper.startPage(pageNo, pageSize);
        //List<RCaseRectification> rCaseRectifications = rCaseRectificationMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateRCaseRectification(Integer id, RCaseRectificationUpdateDTO dto) {
        RCaseRectification rCaseRectification = rCaseRectificationMapper.selectById(id);
        if(rCaseRectification != null) {
            //TODO 设值

            if(rCaseRectificationMapper.updateById(rCaseRectification) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
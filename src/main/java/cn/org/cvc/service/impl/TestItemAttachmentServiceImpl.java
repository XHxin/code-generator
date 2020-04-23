package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentListDTO;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentSaveDTO;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentUpdateDTO;
import cn.org.cvc.vo.testItemAttachment.TestItemAttachmentVO;
import cn.org.cvc.mapper.TestItemAttachmentMapper;
import cn.org.cvc.model.TestItemAttachment;
import cn.org.cvc.model.TestItemAttachmentExample;
import cn.org.cvc.service.TestItemAttachmentService;
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
* TestItemAttachmentService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class TestItemAttachmentServiceImpl implements TestItemAttachmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestItemAttachmentServiceImpl.class);

    @Autowired
    TestItemAttachmentMapper testItemAttachmentMapper;

    @Override
    public Result saveTestItemAttachment(TestItemAttachmentSaveDTO dto) {
        //TODO 封装TestItemAttachment

        TestItemAttachment testItemAttachment = new TestItemAttachment();
        BeanUtils.copyProperties(dto, testItemAttachment);
        if(testItemAttachmentMapper.insert(testItemAttachment) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteTestItemAttachment(Integer id) {
        if(testItemAttachmentMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getTestItemAttachment(Integer id) {
        TestItemAttachment testItemAttachment = testItemAttachmentMapper.selectById(id);
        if(testItemAttachment != null) {
            //TODO 封装返回的内容
            TestItemAttachmentVO result = new TestItemAttachmentVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listTestItemAttachment(TestItemAttachmentListDTO dto, int pageNo, int pageSize) {
        Page<TestItemAttachment> page = PageHelper.startPage(pageNo, pageSize);
        //List<TestItemAttachment> testItemAttachments = testItemAttachmentMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateTestItemAttachment(Integer id, TestItemAttachmentUpdateDTO dto) {
        TestItemAttachment testItemAttachment = testItemAttachmentMapper.selectById(id);
        if(testItemAttachment != null) {
            //TODO 设值

            if(testItemAttachmentMapper.updateById(testItemAttachment) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
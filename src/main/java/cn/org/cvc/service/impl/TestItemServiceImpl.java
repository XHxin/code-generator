package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.testItem.TestItemListDTO;
import cn.org.cvc.dto.testItem.TestItemSaveDTO;
import cn.org.cvc.dto.testItem.TestItemUpdateDTO;
import cn.org.cvc.vo.testItem.TestItemVO;
import cn.org.cvc.mapper.TestItemMapper;
import cn.org.cvc.model.TestItem;
import cn.org.cvc.model.TestItemExample;
import cn.org.cvc.service.TestItemService;
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
* TestItemService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class TestItemServiceImpl implements TestItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestItemServiceImpl.class);

    @Autowired
    TestItemMapper testItemMapper;

    @Override
    public Result saveTestItem(TestItemSaveDTO dto) {
        //TODO 封装TestItem

        TestItem testItem = new TestItem();
        BeanUtils.copyProperties(dto, testItem);
        if(testItemMapper.insert(testItem) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteTestItem(Integer id) {
        if(testItemMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getTestItem(Integer id) {
        TestItem testItem = testItemMapper.selectById(id);
        if(testItem != null) {
            //TODO 封装返回的内容
            TestItemVO result = new TestItemVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listTestItem(TestItemListDTO dto, int pageNo, int pageSize) {
        Page<TestItem> page = PageHelper.startPage(pageNo, pageSize);
        //List<TestItem> testItems = testItemMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateTestItem(Integer id, TestItemUpdateDTO dto) {
        TestItem testItem = testItemMapper.selectById(id);
        if(testItem != null) {
            //TODO 设值

            if(testItemMapper.updateById(testItem) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
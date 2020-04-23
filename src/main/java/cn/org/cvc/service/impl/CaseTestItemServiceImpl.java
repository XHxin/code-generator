package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.caseTestItem.CaseTestItemListDTO;
import cn.org.cvc.dto.caseTestItem.CaseTestItemSaveDTO;
import cn.org.cvc.dto.caseTestItem.CaseTestItemUpdateDTO;
import cn.org.cvc.vo.caseTestItem.CaseTestItemVO;
import cn.org.cvc.mapper.CaseTestItemMapper;
import cn.org.cvc.model.CaseTestItem;
import cn.org.cvc.model.CaseTestItemExample;
import cn.org.cvc.service.CaseTestItemService;
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
* CaseTestItemService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class CaseTestItemServiceImpl implements CaseTestItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaseTestItemServiceImpl.class);

    @Autowired
    CaseTestItemMapper caseTestItemMapper;

    @Override
    public Result saveCaseTestItem(CaseTestItemSaveDTO dto) {
        //TODO 封装CaseTestItem

        CaseTestItem caseTestItem = new CaseTestItem();
        BeanUtils.copyProperties(dto, caseTestItem);
        if(caseTestItemMapper.insert(caseTestItem) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteCaseTestItem(Integer id) {
        if(caseTestItemMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getCaseTestItem(Integer id) {
        CaseTestItem caseTestItem = caseTestItemMapper.selectById(id);
        if(caseTestItem != null) {
            //TODO 封装返回的内容
            CaseTestItemVO result = new CaseTestItemVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listCaseTestItem(CaseTestItemListDTO dto, int pageNo, int pageSize) {
        Page<CaseTestItem> page = PageHelper.startPage(pageNo, pageSize);
        //List<CaseTestItem> caseTestItems = caseTestItemMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateCaseTestItem(Integer id, CaseTestItemUpdateDTO dto) {
        CaseTestItem caseTestItem = caseTestItemMapper.selectById(id);
        if(caseTestItem != null) {
            //TODO 设值

            if(caseTestItemMapper.updateById(caseTestItem) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
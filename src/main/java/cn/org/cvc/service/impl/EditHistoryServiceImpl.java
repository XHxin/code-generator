package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.editHistory.EditHistoryListDTO;
import cn.org.cvc.dto.editHistory.EditHistorySaveDTO;
import cn.org.cvc.dto.editHistory.EditHistoryUpdateDTO;
import cn.org.cvc.vo.editHistory.EditHistoryVO;
import cn.org.cvc.mapper.EditHistoryMapper;
import cn.org.cvc.model.EditHistory;
import cn.org.cvc.model.EditHistoryExample;
import cn.org.cvc.service.EditHistoryService;
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
* EditHistoryService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class EditHistoryServiceImpl implements EditHistoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditHistoryServiceImpl.class);

    @Autowired
    EditHistoryMapper editHistoryMapper;

    @Override
    public Result saveEditHistory(EditHistorySaveDTO dto) {
        //TODO 封装EditHistory

        EditHistory editHistory = new EditHistory();
        BeanUtils.copyProperties(dto, editHistory);
        if(editHistoryMapper.insert(editHistory) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteEditHistory(Integer id) {
        if(editHistoryMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getEditHistory(Integer id) {
        EditHistory editHistory = editHistoryMapper.selectById(id);
        if(editHistory != null) {
            //TODO 封装返回的内容
            EditHistoryVO result = new EditHistoryVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listEditHistory(EditHistoryListDTO dto, int pageNo, int pageSize) {
        Page<EditHistory> page = PageHelper.startPage(pageNo, pageSize);
        //List<EditHistory> editHistorys = editHistoryMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateEditHistory(Integer id, EditHistoryUpdateDTO dto) {
        EditHistory editHistory = editHistoryMapper.selectById(id);
        if(editHistory != null) {
            //TODO 设值

            if(editHistoryMapper.updateById(editHistory) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
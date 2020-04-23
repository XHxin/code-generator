package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.manager.ManagerListDTO;
import cn.org.cvc.dto.manager.ManagerSaveDTO;
import cn.org.cvc.dto.manager.ManagerUpdateDTO;
import cn.org.cvc.vo.manager.ManagerVO;
import cn.org.cvc.mapper.ManagerMapper;
import cn.org.cvc.model.Manager;
import cn.org.cvc.model.ManagerExample;
import cn.org.cvc.service.ManagerService;
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
* ManagerService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerServiceImpl.class);

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Result saveManager(ManagerSaveDTO dto) {
        //TODO 封装Manager

        Manager manager = new Manager();
        BeanUtils.copyProperties(dto, manager);
        if(managerMapper.insert(manager) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteManager(Integer id) {
        if(managerMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getManager(Integer id) {
        Manager manager = managerMapper.selectById(id);
        if(manager != null) {
            //TODO 封装返回的内容
            ManagerVO result = new ManagerVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listManager(ManagerListDTO dto, int pageNo, int pageSize) {
        Page<Manager> page = PageHelper.startPage(pageNo, pageSize);
        //List<Manager> managers = managerMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateManager(Integer id, ManagerUpdateDTO dto) {
        Manager manager = managerMapper.selectById(id);
        if(manager != null) {
            //TODO 设值

            if(managerMapper.updateById(manager) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
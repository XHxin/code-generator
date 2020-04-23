package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.department.DepartmentListDTO;
import cn.org.cvc.dto.department.DepartmentSaveDTO;
import cn.org.cvc.dto.department.DepartmentUpdateDTO;
import cn.org.cvc.vo.department.DepartmentVO;
import cn.org.cvc.mapper.DepartmentMapper;
import cn.org.cvc.model.Department;
import cn.org.cvc.model.DepartmentExample;
import cn.org.cvc.service.DepartmentService;
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
* DepartmentService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Result saveDepartment(DepartmentSaveDTO dto) {
        //TODO 封装Department

        Department department = new Department();
        BeanUtils.copyProperties(dto, department);
        if(departmentMapper.insert(department) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteDepartment(Integer id) {
        if(departmentMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getDepartment(Integer id) {
        Department department = departmentMapper.selectById(id);
        if(department != null) {
            //TODO 封装返回的内容
            DepartmentVO result = new DepartmentVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listDepartment(DepartmentListDTO dto, int pageNo, int pageSize) {
        Page<Department> page = PageHelper.startPage(pageNo, pageSize);
        //List<Department> departments = departmentMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateDepartment(Integer id, DepartmentUpdateDTO dto) {
        Department department = departmentMapper.selectById(id);
        if(department != null) {
            //TODO 设值

            if(departmentMapper.updateById(department) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
package com.nelson.test.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nelson.test.dto.department.DepartmentListDTO;
import com.nelson.test.dto.department.DepartmentSaveDTO;
import com.nelson.test.annotation.BaseService;
import com.nelson.test.base.BaseServiceImpl;
import com.nelson.test.dao.mapper.DepartmentMapper;
import com.nelson.test.dao.model.Department;
import com.nelson.test.dao.model.DepartmentExample;
import com.nelson.test.service.DepartmentService;
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
* DepartmentService实现
* Created by Nelson on 2020/1/8.
*/
@Service
@Transactional
@BaseService
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentMapper, Department, DepartmentExample> implements DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Result saveDepartment(DepartmentSaveDTO dto) {
        //TODO 封装Department

        Department department = new Department();
        BenUtils.copyProperties(dto, department);
        if(departmentMapper.insert(department) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteDepartment(Integer id) {
        if(departmentMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getDepartment(Integer id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
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
        List<Department> departments = departmentMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateDepartment(Integer id, DepartmentUpdateDTO dto) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        if(department != null) {
            //TODO 设值

            if(departmentMapper.updateByPrimaryKeySelective(department) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
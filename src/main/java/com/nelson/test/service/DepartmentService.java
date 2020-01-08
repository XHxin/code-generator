package com.nelson.test.service;

import com.nelson.test.base.BaseService;
import com.nelson.test.core.result.Result;
import com.nelson.test.dto.department.DepartmentListDTO;
import com.nelson.test.dto.department.DepartmentSaveDTO;
import com.nelson.test.dao.model.Department;
import com.nelson.test.dao.model.DepartmentExample;

/**
* DepartmentService接口
* Created by Nelson on 2020/1/8.
*/
public interface DepartmentService extends BaseService<Department, DepartmentExample> {

    Result saveDepartment(DepartmentSaveDTO dto);

    Result deleteDepartment(Integer id);

    Result getDepartment(Integer id);

    Result listDepartment(DepartmentListDTO dto, int pageNo, int pageSize);

    Result updateDepartment(Integer id, DepartmentUpdateDTO dto);
}
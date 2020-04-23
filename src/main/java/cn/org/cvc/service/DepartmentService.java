package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.department.DepartmentListDTO;
import cn.org.cvc.dto.department.DepartmentSaveDTO;
import cn.org.cvc.dto.department.DepartmentUpdateDTO;

/**
* DepartmentService接口
* Created by Nelson on 2020/4/7.
*/
public interface DepartmentService {

    Result saveDepartment(DepartmentSaveDTO dto);

    Result deleteDepartment(Integer id);

    Result getDepartment(Integer id);

    Result listDepartment(DepartmentListDTO dto, int pageNo, int pageSize);

    Result updateDepartment(Integer id, DepartmentUpdateDTO dto);
}
package com.nelson.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nelson.test.dto.department.DepartmentListDTO;
import com.nelson.test.dto.department.DepartmentSaveDTO;
import com.nelson.test.base.BaseController;
import com.nelson.test.service.MemberService;
import com.nelson.test.core.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * DepartmentController
 * Created by Nelson on 2020/1/8.
 */
@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public Result save(@RequestBody DepartmentSaveDTO dto) {
        return departmentService.saveDepartment(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody DepartmentListDTO dto, int pageNo, int pageSize){
        return departmentService.listDepartment(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody DepartmentUpdateDTO dto){
        return departmentService.updateDepartment(id, dto);
    }
}
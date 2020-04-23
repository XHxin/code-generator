package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.department.DepartmentListDTO;
import cn.org.cvc.dto.department.DepartmentSaveDTO;
import cn.org.cvc.dto.department.DepartmentUpdateDTO;
import cn.org.cvc.service.DepartmentService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * DepartmentController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

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
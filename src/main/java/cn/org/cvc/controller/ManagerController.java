package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.manager.ManagerListDTO;
import cn.org.cvc.dto.manager.ManagerSaveDTO;
import cn.org.cvc.dto.manager.ManagerUpdateDTO;
import cn.org.cvc.service.ManagerService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * ManagerController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    @PostMapping("")
    public Result save(@RequestBody ManagerSaveDTO dto) {
        return managerService.saveManager(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return managerService.deleteManager(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return managerService.getManager(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody ManagerListDTO dto, int pageNo, int pageSize){
        return managerService.listManager(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ManagerUpdateDTO dto){
        return managerService.updateManager(id, dto);
    }
}
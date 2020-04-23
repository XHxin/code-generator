package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationListDTO;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationSaveDTO;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationUpdateDTO;
import cn.org.cvc.service.RCaseRectificationService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * RCaseRectificationController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/r_case_rectification")
public class RCaseRectificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RCaseRectificationController.class);

    @Autowired
    private RCaseRectificationService rCaseRectificationService;

    @PostMapping("")
    public Result save(@RequestBody RCaseRectificationSaveDTO dto) {
        return rCaseRectificationService.saveRCaseRectification(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return rCaseRectificationService.deleteRCaseRectification(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return rCaseRectificationService.getRCaseRectification(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody RCaseRectificationListDTO dto, int pageNo, int pageSize){
        return rCaseRectificationService.listRCaseRectification(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody RCaseRectificationUpdateDTO dto){
        return rCaseRectificationService.updateRCaseRectification(id, dto);
    }
}
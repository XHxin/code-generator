package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.rectificationDb.RectificationDbListDTO;
import cn.org.cvc.dto.rectificationDb.RectificationDbSaveDTO;
import cn.org.cvc.dto.rectificationDb.RectificationDbUpdateDTO;
import cn.org.cvc.service.RectificationDbService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * RectificationDbController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/rectification_db")
public class RectificationDbController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RectificationDbController.class);

    @Autowired
    private RectificationDbService rectificationDbService;

    @PostMapping("")
    public Result save(@RequestBody RectificationDbSaveDTO dto) {
        return rectificationDbService.saveRectificationDb(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return rectificationDbService.deleteRectificationDb(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return rectificationDbService.getRectificationDb(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody RectificationDbListDTO dto, int pageNo, int pageSize){
        return rectificationDbService.listRectificationDb(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody RectificationDbUpdateDTO dto){
        return rectificationDbService.updateRectificationDb(id, dto);
    }
}
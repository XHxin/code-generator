package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.caseDb.CaseDbListDTO;
import cn.org.cvc.dto.caseDb.CaseDbSaveDTO;
import cn.org.cvc.dto.caseDb.CaseDbUpdateDTO;
import cn.org.cvc.service.CaseDbService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * CaseDbController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/case_db")
public class CaseDbController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaseDbController.class);

    @Autowired
    private CaseDbService caseDbService;

    @PostMapping("")
    public Result save(@RequestBody CaseDbSaveDTO dto) {
        return caseDbService.saveCaseDb(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return caseDbService.deleteCaseDb(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return caseDbService.getCaseDb(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody CaseDbListDTO dto, int pageNo, int pageSize){
        return caseDbService.listCaseDb(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CaseDbUpdateDTO dto){
        return caseDbService.updateCaseDb(id, dto);
    }
}
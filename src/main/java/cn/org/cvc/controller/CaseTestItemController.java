package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.caseTestItem.CaseTestItemListDTO;
import cn.org.cvc.dto.caseTestItem.CaseTestItemSaveDTO;
import cn.org.cvc.dto.caseTestItem.CaseTestItemUpdateDTO;
import cn.org.cvc.service.CaseTestItemService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * CaseTestItemController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/case_test_item")
public class CaseTestItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaseTestItemController.class);

    @Autowired
    private CaseTestItemService caseTestItemService;

    @PostMapping("")
    public Result save(@RequestBody CaseTestItemSaveDTO dto) {
        return caseTestItemService.saveCaseTestItem(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return caseTestItemService.deleteCaseTestItem(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return caseTestItemService.getCaseTestItem(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody CaseTestItemListDTO dto, int pageNo, int pageSize){
        return caseTestItemService.listCaseTestItem(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CaseTestItemUpdateDTO dto){
        return caseTestItemService.updateCaseTestItem(id, dto);
    }
}
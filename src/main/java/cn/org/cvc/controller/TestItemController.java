package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.testItem.TestItemListDTO;
import cn.org.cvc.dto.testItem.TestItemSaveDTO;
import cn.org.cvc.dto.testItem.TestItemUpdateDTO;
import cn.org.cvc.service.TestItemService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * TestItemController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/test_item")
public class TestItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestItemController.class);

    @Autowired
    private TestItemService testItemService;

    @PostMapping("")
    public Result save(@RequestBody TestItemSaveDTO dto) {
        return testItemService.saveTestItem(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return testItemService.deleteTestItem(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return testItemService.getTestItem(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody TestItemListDTO dto, int pageNo, int pageSize){
        return testItemService.listTestItem(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TestItemUpdateDTO dto){
        return testItemService.updateTestItem(id, dto);
    }
}
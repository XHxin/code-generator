package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.editHistory.EditHistoryListDTO;
import cn.org.cvc.dto.editHistory.EditHistorySaveDTO;
import cn.org.cvc.dto.editHistory.EditHistoryUpdateDTO;
import cn.org.cvc.service.EditHistoryService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * EditHistoryController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/edit_history")
public class EditHistoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditHistoryController.class);

    @Autowired
    private EditHistoryService editHistoryService;

    @PostMapping("")
    public Result save(@RequestBody EditHistorySaveDTO dto) {
        return editHistoryService.saveEditHistory(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return editHistoryService.deleteEditHistory(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return editHistoryService.getEditHistory(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody EditHistoryListDTO dto, int pageNo, int pageSize){
        return editHistoryService.listEditHistory(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody EditHistoryUpdateDTO dto){
        return editHistoryService.updateEditHistory(id, dto);
    }
}
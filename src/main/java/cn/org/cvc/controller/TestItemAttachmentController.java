package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentListDTO;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentSaveDTO;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentUpdateDTO;
import cn.org.cvc.service.TestItemAttachmentService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * TestItemAttachmentController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/test_item_attachment")
public class TestItemAttachmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestItemAttachmentController.class);

    @Autowired
    private TestItemAttachmentService testItemAttachmentService;

    @PostMapping("")
    public Result save(@RequestBody TestItemAttachmentSaveDTO dto) {
        return testItemAttachmentService.saveTestItemAttachment(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return testItemAttachmentService.deleteTestItemAttachment(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return testItemAttachmentService.getTestItemAttachment(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody TestItemAttachmentListDTO dto, int pageNo, int pageSize){
        return testItemAttachmentService.listTestItemAttachment(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TestItemAttachmentUpdateDTO dto){
        return testItemAttachmentService.updateTestItemAttachment(id, dto);
    }
}
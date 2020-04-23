package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.memberCheck.MemberCheckListDTO;
import cn.org.cvc.dto.memberCheck.MemberCheckSaveDTO;
import cn.org.cvc.dto.memberCheck.MemberCheckUpdateDTO;
import cn.org.cvc.service.MemberCheckService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * MemberCheckController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/member_check")
public class MemberCheckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberCheckController.class);

    @Autowired
    private MemberCheckService memberCheckService;

    @PostMapping("")
    public Result save(@RequestBody MemberCheckSaveDTO dto) {
        return memberCheckService.saveMemberCheck(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return memberCheckService.deleteMemberCheck(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return memberCheckService.getMemberCheck(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody MemberCheckListDTO dto, int pageNo, int pageSize){
        return memberCheckService.listMemberCheck(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody MemberCheckUpdateDTO dto){
        return memberCheckService.updateMemberCheck(id, dto);
    }
}
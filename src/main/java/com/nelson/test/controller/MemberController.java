package com.nelson.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nelson.test.dto.member.MemberListDTO;
import com.nelson.test.dto.member.MemberSaveDTO;
import com.nelson.test.base.BaseController;
import com.nelson.test.service.MemberService;
import com.nelson.test.core.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * MemberController
 * Created by Nelson on 2020/1/8.
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @PostMapping("")
    public Result save(@RequestBody MemberSaveDTO dto) {
        return memberService.saveMember(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return memberService.deleteMember(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return memberService.getMember(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody MemberListDTO dto, int pageNo, int pageSize){
        return memberService.listMember(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody MemberUpdateDTO dto){
        return memberService.updateMember(id, dto);
    }
}
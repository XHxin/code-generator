package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.member.MemberListDTO;
import cn.org.cvc.dto.member.MemberSaveDTO;
import cn.org.cvc.dto.member.MemberUpdateDTO;
import cn.org.cvc.service.MemberService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * MemberController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/member")
public class MemberController {

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
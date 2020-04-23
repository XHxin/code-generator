package cn.org.cvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.org.cvc.dto.company.CompanyListDTO;
import cn.org.cvc.dto.company.CompanySaveDTO;
import cn.org.cvc.dto.company.CompanyUpdateDTO;
import cn.org.cvc.service.CompanyService;
import cn.org.cvc.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * CompanyController
 * Created by Nelson on 2020/4/7.
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public Result save(@RequestBody CompanySaveDTO dto) {
        return companyService.saveCompany(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return companyService.deleteCompany(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return companyService.getCompany(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody CompanyListDTO dto, int pageNo, int pageSize){
        return companyService.listCompany(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CompanyUpdateDTO dto){
        return companyService.updateCompany(id, dto);
    }
}
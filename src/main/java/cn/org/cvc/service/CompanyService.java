package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.company.CompanyListDTO;
import cn.org.cvc.dto.company.CompanySaveDTO;
import cn.org.cvc.dto.company.CompanyUpdateDTO;

/**
* CompanyService接口
* Created by Nelson on 2020/4/7.
*/
public interface CompanyService {

    Result saveCompany(CompanySaveDTO dto);

    Result deleteCompany(Integer id);

    Result getCompany(Integer id);

    Result listCompany(CompanyListDTO dto, int pageNo, int pageSize);

    Result updateCompany(Integer id, CompanyUpdateDTO dto);
}
package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.company.CompanyListDTO;
import cn.org.cvc.dto.company.CompanySaveDTO;
import cn.org.cvc.dto.company.CompanyUpdateDTO;
import cn.org.cvc.vo.company.CompanyVO;
import cn.org.cvc.mapper.CompanyMapper;
import cn.org.cvc.model.Company;
import cn.org.cvc.model.CompanyExample;
import cn.org.cvc.service.CompanyService;
import cn.org.cvc.core.enums.ResultEnum;
import cn.org.cvc.core.resp.Result;
import cn.org.cvc.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* CompanyService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public Result saveCompany(CompanySaveDTO dto) {
        //TODO 封装Company

        Company company = new Company();
        BeanUtils.copyProperties(dto, company);
        if(companyMapper.insert(company) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteCompany(Integer id) {
        if(companyMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getCompany(Integer id) {
        Company company = companyMapper.selectById(id);
        if(company != null) {
            //TODO 封装返回的内容
            CompanyVO result = new CompanyVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listCompany(CompanyListDTO dto, int pageNo, int pageSize) {
        Page<Company> page = PageHelper.startPage(pageNo, pageSize);
        //List<Company> companys = companyMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateCompany(Integer id, CompanyUpdateDTO dto) {
        Company company = companyMapper.selectById(id);
        if(company != null) {
            //TODO 设值

            if(companyMapper.updateById(company) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
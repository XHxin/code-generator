package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.caseDb.CaseDbListDTO;
import cn.org.cvc.dto.caseDb.CaseDbSaveDTO;
import cn.org.cvc.dto.caseDb.CaseDbUpdateDTO;
import cn.org.cvc.vo.caseDb.CaseDbVO;
import cn.org.cvc.mapper.CaseDbMapper;
import cn.org.cvc.model.CaseDb;
import cn.org.cvc.model.CaseDbExample;
import cn.org.cvc.service.CaseDbService;
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
* CaseDbService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class CaseDbServiceImpl implements CaseDbService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaseDbServiceImpl.class);

    @Autowired
    CaseDbMapper caseDbMapper;

    @Override
    public Result saveCaseDb(CaseDbSaveDTO dto) {
        //TODO 封装CaseDb

        CaseDb caseDb = new CaseDb();
        BeanUtils.copyProperties(dto, caseDb);
        if(caseDbMapper.insert(caseDb) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteCaseDb(Integer id) {
        if(caseDbMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getCaseDb(Integer id) {
        CaseDb caseDb = caseDbMapper.selectById(id);
        if(caseDb != null) {
            //TODO 封装返回的内容
            CaseDbVO result = new CaseDbVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listCaseDb(CaseDbListDTO dto, int pageNo, int pageSize) {
        Page<CaseDb> page = PageHelper.startPage(pageNo, pageSize);
        //List<CaseDb> caseDbs = caseDbMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateCaseDb(Integer id, CaseDbUpdateDTO dto) {
        CaseDb caseDb = caseDbMapper.selectById(id);
        if(caseDb != null) {
            //TODO 设值

            if(caseDbMapper.updateById(caseDb) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
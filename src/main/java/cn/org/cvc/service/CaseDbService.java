package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.caseDb.CaseDbListDTO;
import cn.org.cvc.dto.caseDb.CaseDbSaveDTO;
import cn.org.cvc.dto.caseDb.CaseDbUpdateDTO;

/**
* CaseDbService接口
* Created by Nelson on 2020/4/7.
*/
public interface CaseDbService {

    Result saveCaseDb(CaseDbSaveDTO dto);

    Result deleteCaseDb(Integer id);

    Result getCaseDb(Integer id);

    Result listCaseDb(CaseDbListDTO dto, int pageNo, int pageSize);

    Result updateCaseDb(Integer id, CaseDbUpdateDTO dto);
}
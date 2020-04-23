package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.caseTestItem.CaseTestItemListDTO;
import cn.org.cvc.dto.caseTestItem.CaseTestItemSaveDTO;
import cn.org.cvc.dto.caseTestItem.CaseTestItemUpdateDTO;

/**
* CaseTestItemService接口
* Created by Nelson on 2020/4/7.
*/
public interface CaseTestItemService {

    Result saveCaseTestItem(CaseTestItemSaveDTO dto);

    Result deleteCaseTestItem(Integer id);

    Result getCaseTestItem(Integer id);

    Result listCaseTestItem(CaseTestItemListDTO dto, int pageNo, int pageSize);

    Result updateCaseTestItem(Integer id, CaseTestItemUpdateDTO dto);
}
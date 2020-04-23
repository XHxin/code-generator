package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationListDTO;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationSaveDTO;
import cn.org.cvc.dto.rCaseRectification.RCaseRectificationUpdateDTO;

/**
* RCaseRectificationService接口
* Created by Nelson on 2020/4/7.
*/
public interface RCaseRectificationService {

    Result saveRCaseRectification(RCaseRectificationSaveDTO dto);

    Result deleteRCaseRectification(Integer id);

    Result getRCaseRectification(Integer id);

    Result listRCaseRectification(RCaseRectificationListDTO dto, int pageNo, int pageSize);

    Result updateRCaseRectification(Integer id, RCaseRectificationUpdateDTO dto);
}
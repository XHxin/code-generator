package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.editHistory.EditHistoryListDTO;
import cn.org.cvc.dto.editHistory.EditHistorySaveDTO;
import cn.org.cvc.dto.editHistory.EditHistoryUpdateDTO;

/**
* EditHistoryService接口
* Created by Nelson on 2020/4/7.
*/
public interface EditHistoryService {

    Result saveEditHistory(EditHistorySaveDTO dto);

    Result deleteEditHistory(Integer id);

    Result getEditHistory(Integer id);

    Result listEditHistory(EditHistoryListDTO dto, int pageNo, int pageSize);

    Result updateEditHistory(Integer id, EditHistoryUpdateDTO dto);
}
package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.rectificationDb.RectificationDbListDTO;
import cn.org.cvc.dto.rectificationDb.RectificationDbSaveDTO;
import cn.org.cvc.dto.rectificationDb.RectificationDbUpdateDTO;

/**
* RectificationDbService接口
* Created by Nelson on 2020/4/7.
*/
public interface RectificationDbService {

    Result saveRectificationDb(RectificationDbSaveDTO dto);

    Result deleteRectificationDb(Integer id);

    Result getRectificationDb(Integer id);

    Result listRectificationDb(RectificationDbListDTO dto, int pageNo, int pageSize);

    Result updateRectificationDb(Integer id, RectificationDbUpdateDTO dto);
}
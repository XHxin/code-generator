package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.manager.ManagerListDTO;
import cn.org.cvc.dto.manager.ManagerSaveDTO;
import cn.org.cvc.dto.manager.ManagerUpdateDTO;

/**
* ManagerService接口
* Created by Nelson on 2020/4/7.
*/
public interface ManagerService {

    Result saveManager(ManagerSaveDTO dto);

    Result deleteManager(Integer id);

    Result getManager(Integer id);

    Result listManager(ManagerListDTO dto, int pageNo, int pageSize);

    Result updateManager(Integer id, ManagerUpdateDTO dto);
}
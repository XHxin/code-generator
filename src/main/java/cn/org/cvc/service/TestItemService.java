package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.testItem.TestItemListDTO;
import cn.org.cvc.dto.testItem.TestItemSaveDTO;
import cn.org.cvc.dto.testItem.TestItemUpdateDTO;

/**
* TestItemService接口
* Created by Nelson on 2020/4/7.
*/
public interface TestItemService {

    Result saveTestItem(TestItemSaveDTO dto);

    Result deleteTestItem(Integer id);

    Result getTestItem(Integer id);

    Result listTestItem(TestItemListDTO dto, int pageNo, int pageSize);

    Result updateTestItem(Integer id, TestItemUpdateDTO dto);
}
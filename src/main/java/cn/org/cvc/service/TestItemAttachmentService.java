package cn.org.cvc.service;

import cn.org.cvc.core.resp.Result;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentListDTO;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentSaveDTO;
import cn.org.cvc.dto.testItemAttachment.TestItemAttachmentUpdateDTO;

/**
* TestItemAttachmentService接口
* Created by Nelson on 2020/4/7.
*/
public interface TestItemAttachmentService {

    Result saveTestItemAttachment(TestItemAttachmentSaveDTO dto);

    Result deleteTestItemAttachment(Integer id);

    Result getTestItemAttachment(Integer id);

    Result listTestItemAttachment(TestItemAttachmentListDTO dto, int pageNo, int pageSize);

    Result updateTestItemAttachment(Integer id, TestItemAttachmentUpdateDTO dto);
}
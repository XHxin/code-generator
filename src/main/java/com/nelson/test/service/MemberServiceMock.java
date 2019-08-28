package com.nelson.test.service;

import com.nelson.test.base.BaseServiceMock;
import com.nelson.test.dao.mapper.MemberMapper;
import com.nelson.test.dao.model.Member;
import com.nelson.test.dao.model.MemberExample;

/**
* 降级实现MemberService接口
* Created by shuzheng on 2019/8/27.
*/
public class MemberServiceMock extends BaseServiceMock<MemberMapper, Member, MemberExample> implements MemberService {

}

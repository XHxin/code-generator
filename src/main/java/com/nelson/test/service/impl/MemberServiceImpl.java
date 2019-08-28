package com.nelson.test.service.impl;

import com.nelson.test.annotation.BaseService;
import com.nelson.test.base.BaseServiceImpl;
import com.nelson.test.dao.mapper.MemberMapper;
import com.nelson.test.dao.model.Member;
import com.nelson.test.dao.model.MemberExample;
import com.nelson.test.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MemberService实现
* Created by shuzheng on 2019/8/27.
*/
@Service
@Transactional
@BaseService
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, Member, MemberExample> implements MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    MemberMapper memberMapper;

}
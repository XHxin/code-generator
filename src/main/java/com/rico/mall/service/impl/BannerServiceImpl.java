package com.rico.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rico.mall.dto.banner.BannerListDTO;
import com.rico.mall.dto.banner.BannerSaveDTO;
import com.rico.mall.annotation.BaseService;
import com.rico.mall.base.BaseServiceImpl;
import com.rico.mall.dao.mapper.BannerMapper;
import com.rico.mall.dao.model.Banner;
import com.rico.mall.dao.model.BannerExample;
import com.rico.mall.service.BannerService;
import com.rico.mall.core.enums.ResultEnum;
import com.rico.mall.core.result.Result;
import com.rico.mall.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* BannerService实现
* Created by Nelson on 2020/1/8.
*/
@Service
@Transactional
@BaseService
public class BannerServiceImpl extends BaseServiceImpl<BannerMapper, Banner, BannerExample> implements BannerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public Result saveBanner(BannerSaveDTO dto) {
        //TODO 封装Banner

        Banner banner = new Banner();
        BenUtils.copyProperties(dto, banner);
        if(bannerMapper.insert(banner) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteBanner(Integer id) {
        if(bannerMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getBanner(Integer id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        if(banner != null) {
            //TODO 封装返回的内容
            BannerVO result = new BannerVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listBanner(BannerListDTO dto, int pageNo, int pageSize) {
        Page<Banner> page = PageHelper.startPage(pageNo, pageSize);
        List<Banner> banners = bannerMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateBanner(Integer id, BannerUpdateDTO dto) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        if(banner != null) {
            //TODO 设值

            if(bannerMapper.updateByPrimaryKeySelective(banner) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
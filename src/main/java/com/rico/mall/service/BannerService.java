package com.rico.mall.service;

import com.rico.mall.base.BaseService;
import com.rico.mall.core.result.Result;
import com.rico.mall.dto.banner.BannerListDTO;
import com.rico.mall.dto.banner.BannerSaveDTO;
import com.rico.mall.dao.model.Banner;
import com.rico.mall.dao.model.BannerExample;

/**
* BannerService接口
* Created by Nelson on 2020/1/8.
*/
public interface BannerService extends BaseService<Banner, BannerExample> {

    Result saveBanner(BannerSaveDTO dto);

    Result deleteBanner(Integer id);

    Result getBanner(Integer id);

    Result listBanner(BannerListDTO dto, int pageNo, int pageSize);

    Result updateBanner(Integer id, BannerUpdateDTO dto);
}
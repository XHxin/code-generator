package com.rico.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rico.mall.dto.banner.BannerListDTO;
import com.rico.mall.dto.banner.BannerSaveDTO;
import com.rico.mall.base.BaseController;
import com.rico.mall.service.BannerService};
import com.rico.mall.core.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * BannerController
 * Created by Nelson on 2020/1/8.
 */
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    @PostMapping("")
    public Result save(@RequestBody BannerSaveDTO dto) {
        return bannerService.saveBanner(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return bannerService.deleteBanner(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return bannerService.getBanner(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody BannerListDTO dto, int pageNo, int pageSize){
        return bannerService.listBanner(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody BannerUpdateDTO dto){
        return bannerService.updateBanner(id, dto);
    }
}
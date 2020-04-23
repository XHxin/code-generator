package cn.org.cvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.org.cvc.dto.rectificationDb.RectificationDbListDTO;
import cn.org.cvc.dto.rectificationDb.RectificationDbSaveDTO;
import cn.org.cvc.dto.rectificationDb.RectificationDbUpdateDTO;
import cn.org.cvc.vo.rectificationDb.RectificationDbVO;
import cn.org.cvc.mapper.RectificationDbMapper;
import cn.org.cvc.model.RectificationDb;
import cn.org.cvc.model.RectificationDbExample;
import cn.org.cvc.service.RectificationDbService;
import cn.org.cvc.core.enums.ResultEnum;
import cn.org.cvc.core.resp.Result;
import cn.org.cvc.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* RectificationDbService实现
* Created by Nelson on 2020/4/7.
*/
@Service
@Transactional
public class RectificationDbServiceImpl implements RectificationDbService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RectificationDbServiceImpl.class);

    @Autowired
    RectificationDbMapper rectificationDbMapper;

    @Override
    public Result saveRectificationDb(RectificationDbSaveDTO dto) {
        //TODO 封装RectificationDb

        RectificationDb rectificationDb = new RectificationDb();
        BeanUtils.copyProperties(dto, rectificationDb);
        if(rectificationDbMapper.insert(rectificationDb) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteRectificationDb(Integer id) {
        if(rectificationDbMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getRectificationDb(Integer id) {
        RectificationDb rectificationDb = rectificationDbMapper.selectById(id);
        if(rectificationDb != null) {
            //TODO 封装返回的内容
            RectificationDbVO result = new RectificationDbVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listRectificationDb(RectificationDbListDTO dto, int pageNo, int pageSize) {
        Page<RectificationDb> page = PageHelper.startPage(pageNo, pageSize);
        //List<RectificationDb> rectificationDbs = rectificationDbMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateRectificationDb(Integer id, RectificationDbUpdateDTO dto) {
        RectificationDb rectificationDb = rectificationDbMapper.selectById(id);
        if(rectificationDb != null) {
            //TODO 设值

            if(rectificationDbMapper.updateById(rectificationDb) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}
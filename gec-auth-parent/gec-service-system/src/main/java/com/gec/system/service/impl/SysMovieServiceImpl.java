package com.gec.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.model.system.SysMovie;
import com.gec.model.vo.SysMovieQueryVo;
import com.gec.system.mapper.SysMovieMapper;
import com.gec.system.service.SysMovieService;
import org.springframework.stereotype.Service;

@Service
public class SysMovieServiceImpl extends ServiceImpl<SysMovieMapper, SysMovie> implements SysMovieService {

    @Override
    public IPage<SysMovie> selectPage(IPage<SysMovie> p1, SysMovieQueryVo sysMovieQueryVo) {
        IPage<SysMovie> iPage = this.baseMapper.selectPage(p1,sysMovieQueryVo);
        return iPage;
    }
}

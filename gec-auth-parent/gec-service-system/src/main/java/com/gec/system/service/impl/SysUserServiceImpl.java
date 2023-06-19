package com.gec.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.vo.SysUserQueryVo;
import com.gec.system.entity.SysUser;
import com.gec.system.mapper.SysUserMapper;
import com.gec.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dafei
 * @since 2023-06-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectPage(IPage<SysUser> iPage, SysUserQueryVo sysUserQueryVo) {
        return this.baseMapper.selectPage(iPage,sysUserQueryVo);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        //1.查询出当前用户
        SysUser sysUser = this.baseMapper.selectById(id);
        //2.设置状态
        sysUser.setStatus(status);
        //3.更新
        this.baseMapper.updateById(sysUser);
    }
}

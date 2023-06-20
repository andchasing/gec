package com.gec.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.model.system.SysMenu;
import com.gec.model.vo.AssginMenuVo;

import java.util.List;

/**
 *  @author dafei
 *
 */
public interface SysMenuService extends IService<SysMenu> {

    // 加载菜单列表
    List<SysMenu> findNodes();

    // 根据id去删除菜单
    void removeMenuById(Long id);

    List<SysMenu> findSysMenuByRoleId(Long roleId);

    void doAssign(AssginMenuVo assginMenuVo);
}

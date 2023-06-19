package com.gec.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.model.system.SysRole;
import com.gec.model.vo.AssginRoleVo;
import com.gec.model.vo.SysRoleQueryVo;
import com.gec.system.service.SysRoleService;
import com.gec.system.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping(value = "/admin/system/role")
@CrossOrigin
public class RoleController {
    @Autowired
    private SysRoleService iRoleService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result findRoleByPageQuery(
            // @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            //  @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            // @ApiParam(name = "roleQueryVo", value = "查询对象", required = false)
            SysRoleQueryVo roleQueryVo) {
        Page<SysRole> pageParam = new Page<SysRole>(page, limit);
        IPage<SysRole> pageModel = iRoleService.selectPage(pageParam, roleQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation("逻辑删除接口")
    @DeleteMapping("/remove/{id}")
    public Result removeRole(@PathVariable Long id)
    {
        boolean isSuccess = this.iRoleService.removeById(id);
        if (isSuccess)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 添加
    @ApiOperation("添加角色")
    @PostMapping("addRole")
    public Result addRole(@RequestBody SysRole sysRole)
    {
        boolean isSuccess = this.iRoleService.save(sysRole);
        if (isSuccess)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 根据id 去获取一个role
    @GetMapping("findRoleById/{id}")
    @ApiOperation("根据id查询")
    public Result findRoleById(@PathVariable Long id)
    {
        SysRole sysRole = this.iRoleService.getById(id);
        return Result.ok(sysRole);
    }

    // 修改
    @ApiOperation("修改角色")
    @PostMapping("updateRole")
    public Result updateRole(@RequestBody SysRole sysRole)
    {
        boolean isSuccess = this.iRoleService.updateById(sysRole);
        if (isSuccess)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids)
    {
        boolean isSuccess = this.iRoleService.removeByIds(ids);
        if (isSuccess)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("toAssign/{userId}")
    public Result toAssign(@PathVariable Long userId) {
        System.out.println(userId);
        Map<String, Object> roleMap = iRoleService.getRolesByUserId(userId);
        return Result.ok(roleMap);
    }

    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        iRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
}

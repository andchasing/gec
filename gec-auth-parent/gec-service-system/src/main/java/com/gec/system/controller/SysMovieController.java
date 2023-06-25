package com.gec.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.model.system.SysMovie;
import com.gec.model.vo.SysMovieQueryVo;
import com.gec.system.common.Result;
import com.gec.system.service.SysMovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "影视管理控制器")
@RequestMapping("/admin/system/sysMovie")
@CrossOrigin
public class SysMovieController {

    @Autowired
    private SysMovieService sysMovieService;

//    @Autowired
//    private VodTemplate vodTemplate;

    @ApiOperation("获取全部影视列表")
    // http://localhost:8085/admin/system/sysRole/findAll
    @GetMapping("/findAll")
    public Result findAll()
    {
        List<SysMovie> list = this.sysMovieService.list();
        return Result.ok(list);
    }
    // http://localhost:8085/admin/system/sysRole/removeRole/14
    @ApiOperation("根据id去移除一个影视")
    // 测试删除
    @DeleteMapping("/removeMovie/{id}")
    public Result removeMovie(@PathVariable Long id)
    {
        boolean b = this.sysMovieService.removeById(id);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 分页和条件查询
    @GetMapping("/{page}/{limit}")
    public Result findMovieByPageQuery(@PathVariable Long page,
                                       @PathVariable Long limit,
                                       SysMovieQueryVo sysMovieQueryVo)
    {
        //1.创建分页对象
        IPage<SysMovie> p1 = new Page<SysMovie>(page,limit);
        //2.调用方法
        p1 =    this.sysMovieService.selectPage(p1,sysMovieQueryVo);
        //3.返回
        return Result.ok(p1);
    }

    // 添加影视
    @PostMapping("/addMovie")
    public Result addRole(@RequestBody SysMovie sysMovie)
    {
        boolean res = this.sysMovieService.save(sysMovie);
        if (res)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 修改
    //1.根据id 去得到当前影视
    @GetMapping("/findMovieById/{id}")
    public Result findMovieById(@PathVariable Long id)
    {
        SysMovie sysMovie = this.sysMovieService.getById(id);
        return Result.ok(sysMovie);
    }

    // 实现修改
    @PostMapping("/updateMovie")
    public Result updateRole(@RequestBody SysMovie sysMovie)
    {
        boolean b = this.sysMovieService.updateById(sysMovie);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 批量删除
    @DeleteMapping("/removeMovieByIds")
    public Result removeMovieByIds(@RequestBody List<Long> ids)
    {
        boolean b = this.sysMovieService.removeByIds(ids);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

}

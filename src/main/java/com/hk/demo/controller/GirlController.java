package com.hk.demo.controller;

import com.hk.demo.bean.Girl;
import com.hk.demo.bean.Result;
import com.hk.demo.repository.GirlRepository;
import com.hk.demo.service.GirlService;
import com.hk.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 何康
 * @date 2018/8/10 9:27
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /***
     * 查询女生列表
     * @return
     */
    @GetMapping(value = "/getAllGirls")
    public Result<List<Girl>> girlList(){
        return ResultUtil.success(girlRepository.findAll());
    }

    /**
     * 添加女生
     * @return
     */
    @GetMapping(value = "/addGirls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.print(bindingResult.getFieldError().getDefaultMessage());
//            return null;
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id查找女生
     * @return
     */
//    @GetMapping(value="findGirls")
//    public Girl findGirl(@RequestParam("id") Integer id){
//       return girlRepository.findById(id).orElse(null);
//    }
    @GetMapping(value="findGirls")
    public Girl findGirl(Girl girl){
        return girlRepository.findById(girl.getId()).orElse(null);
    }


    /**
     * 通过年龄查找女生
     * @param age
     * @return
     */
    @GetMapping(value="findGirlsByAge")
    public List<Girl> findGirlsByAge(@RequestParam("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 更新女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @GetMapping(value="updateGirls")
    public Girl updateGirl(@RequestParam("id")Integer id,
                           @RequestParam("cupSize")String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /***
     * 删除女生
     * @param id
     */
    @GetMapping(value = "deleteGirl")
    public void deleteGirl(@RequestParam("id")Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "insertTwoGirl")
    public void insertTwoGirl(){
        girlService.insertTwo();
    }

}

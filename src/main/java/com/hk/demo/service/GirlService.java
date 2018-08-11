package com.hk.demo.service;

import com.hk.demo.bean.Result;
import com.hk.demo.enums.GirlEnum;
import com.hk.demo.exception.GirlException;
import com.hk.demo.repository.GirlRepository;
import com.hk.demo.bean.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author 何康
 * @date 2018/8/10 10:11
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    //保证事务操作，要么都执行成功，要么都不成功
    //事务如果执行失败需要给数据库添加innodb引擎，否则事务操作无效
    //alter table girl engine=innodb
    @Transactional
    public void insertTwo(){
        Girl girlA =new Girl();
        girlA.setAge(18);
        girlA.setCupSize("g");
        girlRepository.save(girlA);

        Girl girlB =new Girl();
        girlB.setAge(19);
        //此条记录不合法
        girlB.setCupSize("HHHH");
        girlRepository.save(girlB);
    }

    /**
     * 判断女生的年龄，从而打印出不一样的信息
     * @param id
     */
    public Girl getSpecialGirl(int id) throws  GirlException{
        Girl girl = girlRepository.findById(id).orElse(null);
        int age =girl.getAge();
        System.out.print("age:"+age);
        if(age<10){
            //这种方式抛异常可以，但是返回的code无法修改，需要自定义异常对code进行自定义
//            throw new Exception("还在上小学");
            //这种方式可以很灵活的对code进行修改，但是参数一般不允许随意，修改，因此还需要对参数进行封装
//            throw new GirlException(100,"还在上小学");
            //使用枚举封装可能产生的各种情况
            throw new GirlException(GirlEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<18){
//            throw new Exception("还未成年");;
//            throw new GirlException(101,"还未成年");
            throw new GirlException(GirlEnum.NOT_GROW_UP);
        }else return girl;

    }


    /***
     * junit测试的方法
     * 通过id查询一个女生
     * @param id
     * @return
     */
    public Girl findOneGirl(Integer id){
        return girlRepository.findById(id).orElse(null);
    }




}

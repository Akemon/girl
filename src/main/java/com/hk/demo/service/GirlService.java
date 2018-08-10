package com.hk.demo.service;

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
        girlB.setCupSize("HHHH");
        girlRepository.save(girlB);
    }
}

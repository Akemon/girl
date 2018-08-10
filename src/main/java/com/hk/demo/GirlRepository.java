package com.hk.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 何康
 * @date 2018/8/10 9:29
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄查询
    public List<Girl>  findByAge(Integer id);
}

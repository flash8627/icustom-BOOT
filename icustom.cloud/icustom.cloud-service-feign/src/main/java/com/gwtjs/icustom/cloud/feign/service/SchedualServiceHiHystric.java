package com.gwtjs.icustom.cloud.feign.service;

import org.springframework.stereotype.Component;

/**
 * Created by aGuang on 2017/10/08
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

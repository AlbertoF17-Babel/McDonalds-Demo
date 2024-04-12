package com.babel.McDonalds.InitConfig;
import com.babel.McDonalds.service.IAlmacenService;
import org.springframework.boot.ApplicationArguments;

import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

@Component
public class InitConfig {

    IAlmacenService almacenService;

    public InitConfig(IAlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        almacenService.inicializarAlmacen();
    }

}
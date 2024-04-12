package com.babel.McDonalds.InitConfig;
import com.babel.McDonalds.service.IAlmacenService;
import com.babel.McDonalds.service.IEmpleadoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitConfig implements ApplicationRunner{

    IAlmacenService almacenService;
    IEmpleadoService empleadoService;

    public InitConfig(IAlmacenService almacenService, IEmpleadoService empleadoService) {
        this.almacenService = almacenService;
        this.empleadoService = empleadoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        almacenService.inicializarAlmacen();
        empleadoService.inicializarEmpleados();
    }

}
package com.airrowing.system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

/**
 * @author cineazhan
 */
@OpenAPIDefinition(info = @Info(
        title = "AirRowing 赛艇后端系统",
        description = "这里是AirRowing赛艇后端系统",
        version = "v1"
))
@MapperScan("com.airrowing.system.mapper")
@SpringBootApplication
public class AirRowingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirRowingSystemApplication.class, args);
    }

}

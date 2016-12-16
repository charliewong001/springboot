package com.charlie.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
// @EnableAspectJAutoProxy
@Import(value = { MysqlConfig.class })
@ComponentScan(basePackages = "com.charlie", excludeFilters = {
        @Filter(Controller.class), @Filter(Configuration.class) })
public class SprintRootConfig {

}

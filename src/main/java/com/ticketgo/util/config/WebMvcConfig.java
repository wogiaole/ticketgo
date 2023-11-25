package com.ticketgo.util.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



@Slf4j
@Configuration
//需要添加这个注解 @EnableOpenApi

public class WebMvcConfig extends WebMvcConfigurationSupport {


    /**
     * 通过knife4j生成swagger接口文档
     *
     * @return
     */
//     @Bean
//     Docket docket() {
//     log.info("开始生成接口文档...");
//     ApiInfo apiInfo = new ApiInfoBuilder()
//     .title("ticketgo项目接口文档")
//     .version("2.0")
//     .description("ticketgo项目接口文档")
//     .build();
//     Docket docket = new Docket(DocumentationType.SWAGGER_2)
//     .apiInfo(apiInfo)
//     .select()
//     .apis(RequestHandlerSelectors.basePackage("com.ticketgo.controller"))
//     .paths(PathSelectors.any())
//     .build();
//     return docket;
//     }

    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/static/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/static/front/");

   //     registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
//      registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        // 配置 knife4j 文档资源的访问路径
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }



}

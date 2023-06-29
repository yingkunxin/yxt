package com.yk.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Swagger3Config {

    @Bean
    public Docket createWebRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("web")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(getGlobalRequestParameters());
    }

//    @Bean
    //添加app端swagger
    public Docket createAppRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("app")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(getGlobalRequestParameters());
    }


    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(
                new RequestParameterBuilder()
                .name("token")
                .description("用户token")
                .required(false)
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .build()
        );
        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("更多请咨询服务开发者Ray。")
                .contact(new Contact("Ray。", "http://www.ruiyeclub.cn", "ruiyeclub@foxmail.com"))
                .version("1.0")
                .build();
    }
}

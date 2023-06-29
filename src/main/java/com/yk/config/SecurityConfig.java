package com.yk.config;//package com.wayun.epc.business.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/user/login","/user/studentParentsLogin", "/open/**").permitAll()
                .antMatchers(buildNoLoginApi()).permitAll()

                .antMatchers("/swagger-resources/**"
                        , "/webjars/**"
                        , "/v3/api-docs"
                        , "/v2/**"
                        , "/doc.html"
                        , "/test/**"
                        , "/open/**"
                        , "/external/login"
                        , "/websocket/**"
                        , "/swagger-ui/**").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**","/favicon.ico").permitAll()
                .anyRequest()
                .authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(new AuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 处理不需要登录的Api --- @NoLogin
     *
     * @return 接口地址
     */
    private String[] buildNoLoginApi() {
        RequestMappingHandlerMapping bean = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean.getHandlerMethods();
        List<String> list = new ArrayList<>();
        handlerMethods.forEach((k, v) -> {
            NoLogin noLogin = v.getMethod().getAnnotation(NoLogin.class);
            PatternsRequestCondition patternsCondition = k.getPatternsCondition();
            if (noLogin != null) {
                list.addAll(patternsCondition.getPatterns());
            }
        });
        return list.isEmpty() ? new String[]{"/"} : list.toArray(new String[]{});
    }

}

package org.example.manage.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")  // 所有路径
//                .allowedOrigins("*")  // 允许的源
//                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的方法
//                .allowedHeaders("*")  // 允许的请求头
//                .allowCredentials(true)  // 是否允许发送凭证
//                .maxAge(3600);  // 设置缓存预检请求的时间（秒）
        registry.addMapping("/**")  // 所有路径
                .allowedOrigins("*")  // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的方法
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(false)  // 不允许发送凭证
                .maxAge(3600);  // 设置缓存预检请求的时间（秒）
    }

}



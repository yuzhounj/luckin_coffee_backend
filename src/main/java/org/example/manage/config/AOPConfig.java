package org.example.manage.config;


import org.example.manage.aop.ShopCarAspect;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan //  排除不想加载的components
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ContactService.class))// 排斥的处理排除不想加载的components
@EnableAspectJAutoProxy
public class AOPConfig {
    @Bean
    public ShopCarAspect shopCarAspect(){
        return new ShopCarAspect();
    }
}

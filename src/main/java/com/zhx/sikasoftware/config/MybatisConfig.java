package com.zhx.sikasoftware.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description: mybatis-plus 分页插件
 * @param:
 * @return:
 * @throws:
 * @author: HaoXin
 * @date 2021/7/13 9:13
 */
@Configuration
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        //设置请求页面大于最大页后操作，true返回到首页，false继续请求 默认false
        paginationInnerInterceptor.setOverflow(true);
        //设置单页最大限制数量，默认500条，-1 不受限制
        paginationInnerInterceptor.setMaxLimit(500L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }
}

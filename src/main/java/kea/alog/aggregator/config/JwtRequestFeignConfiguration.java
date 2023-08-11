package kea.alog.aggregator.config;

import feign.RequestInterceptor;
import kea.alog.aggregator.common.interceptor.JwtRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtRequestFeignConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new JwtRequestInterceptor();
    }
}

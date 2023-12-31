package kea.alog.aggregator.config;

import kea.alog.aggregator.common.interceptor.JwtInterceptor;
import kea.alog.aggregator.common.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final JwtProvider jwtProvider;

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**").allowedOrigins("*")
            .allowedMethods("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor(jwtProvider))
            .addPathPatterns("/api/aggr/projects/**")
            .excludePathPatterns("/api/aggr/projects/swagger-ui/**");
    }
}
package com.hongin.webservice;

import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.helper.StringHelpers;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@RequiredArgsConstructor
public class HandlebarsConfig {

    private final HandlebarsHelpers handlebarsHelpers;
    private final EqualHelper equalHelper;

    @Bean
    public ViewResolver handlerbarsViewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
        viewResolver.registerHelpers(ConditionalHelpers.class); // 내장 헬퍼 등록
        viewResolver.registerHelpers(StringHelpers.class);      // 내장 헬퍼 등록
        viewResolver.registerHelpers(handlebarsHelpers);       // 커스텀 헬퍼 등록
        viewResolver.registerHelper("equal", equalHelper);      // 커스텀 헬퍼 단건 등록

        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".hbs");
        viewResolver.setCache(false);

        return viewResolver;
    }
}

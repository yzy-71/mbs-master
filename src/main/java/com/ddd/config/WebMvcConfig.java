package com.ddd.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Slf4j
//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        log.info("拓展自己的消息转换器");
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();

        httpMessageConverter.setObjectMapper(new JacksonObjectMapper());

        converters.add(0,httpMessageConverter);
    }
}

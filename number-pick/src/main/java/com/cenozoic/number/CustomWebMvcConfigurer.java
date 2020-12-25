package com.cenozoic.number;

import com.cenozoic.number.interceptor.AuthInterceptor;
import com.cenozoic.number.interceptor.LogInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


/**
 * <p> 
 *    
 * @author  xucaifeng
 * @since   2020-12-19
 **/
@Configuration
public class CustomWebMvcConfigurer extends WebMvcConfigurationSupport {

	@Autowired
	AuthInterceptor authInterceptor;
	@Autowired
	LogInterceptor logInterceptor;

	/**
	 * 添加拦截器
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(authInterceptor).
          			addPathPatterns("/*").
				  	addPathPatterns("/*/*").
          			excludePathPatterns("/user/login");
          registry.addInterceptor(logInterceptor);
    }


	/**
	 * 将long bigInteger bigDecimal等转为string，解决传入前端时精度丢失问题
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		// ObjectMapper 是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构,反之亦然
		ObjectMapper objectMapper = new ObjectMapper();
		
		// 序列化将Long转String类型
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		
		// 序列化将BigInteger转String类型
		SimpleModule bigIntegerModule = new SimpleModule();
		bigIntegerModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
		
		// 序列化将BigDecimal转String类型
		SimpleModule bigDecimalModule = new SimpleModule();
		bigDecimalModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
		
		objectMapper.registerModule(simpleModule);
		objectMapper.registerModule(bigDecimalModule);
		objectMapper.registerModule(bigIntegerModule);
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		converters.add(jackson2HttpMessageConverter);
	}

}

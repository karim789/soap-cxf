package xyz.mirak.soap_cxf;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import xyz.mirak.soap_cxf.service.BasseService;
import xyz.mirak.soap_cxf.service.BasseServiceConfig;
import xyz.mirak.soap_cxf.util.WebServiceUtils;

@Configuration
@Import(value = { BasseServiceConfig.class })
public class AppTestConfig {

	@Bean(name = "baseAdress")
	public String baseAdress() {
		return "http://localhost:9000/";
	}

	@Bean(name = "basseServiceClient")
	public BasseService bassServiceClient() {
		return createProxy(BasseService.class);
	}

	public <T> T createProxy(Class<T> clazz) {
		return createProxy(clazz, WebServiceUtils.createServiceAdress(clazz, baseAdress()));
	}

	public <T> T createProxy(Class<T> clazz, String adress) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(clazz);
		factory.setAddress(adress);
		return clazz.cast(factory.create());
	}

}

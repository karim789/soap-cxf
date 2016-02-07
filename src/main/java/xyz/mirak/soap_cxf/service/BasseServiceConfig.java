package xyz.mirak.soap_cxf.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xyz.mirak.soap_cxf.beans.Basse;
import xyz.mirak.soap_cxf.factory.BasseFactory;
import xyz.mirak.soap_cxf.factory.BasseFactoryImpl;

@Configuration
public class BasseServiceConfig {

	@Bean
	public BasseFactory basseFactory() {
		return new BasseFactoryImpl();
	}

	@Bean(name = "basseService.data.listeBasses")
	public List<Basse> listeBasses() {
		return basseFactory().createListeBasses();
	}

	@Bean
	public BasseService basseService() {
		return new BasseServiceImpl();
	}

}

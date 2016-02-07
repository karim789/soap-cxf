package xyz.mirak.soap_cxf.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.mirak.soap_cxf.beans.Basse;

@Service
public class BasseServiceImpl implements BasseService {

	@Resource(name = "basseService.data.listeBasses")
	private List<Basse> listeBasses;

	@Override
	public List<Basse> getBasses() {
		return listeBasses;
	}

}

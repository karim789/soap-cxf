package xyz.mirak.soap_cxf.service;

import java.util.List;

import javax.jws.WebService;

import xyz.mirak.soap_cxf.beans.Basse;

@WebService
public interface BasseService {

	List<Basse> getBasses();

}

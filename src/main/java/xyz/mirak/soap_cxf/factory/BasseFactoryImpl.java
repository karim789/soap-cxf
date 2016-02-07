package xyz.mirak.soap_cxf.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import xyz.mirak.soap_cxf.beans.Basse;

@Component
public class BasseFactoryImpl implements BasseFactory {

	public static Basse create(String marque, String model) {
		Basse basse = new Basse();
		basse.setMarque(marque);
		basse.setModel(model);
		return basse;
	}

	@Override
	@Bean(name = "basseService.data.listeBasse") //
	public List<Basse> createListeBasses() {
		List<Basse> l = new ArrayList<Basse>();
		l.add(create("Fender", "Jazz Bass"));
		l.add(create("Fender", "Precision Bass"));
		l.add(create("Leduc", "Pad Bass"));
		return l;
	}

}

package xyz.mirak.soap_cxf;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import xyz.mirak.soap_cxf.beans.Basse;
import xyz.mirak.soap_cxf.service.BasseService;
import xyz.mirak.soap_cxf.util.WebServiceUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(classes = AppTestConfig.class) })
@Slf4j
public class AppTest extends TestCase {

	@Autowired
	@Qualifier("basseService")
	private BasseService basseService;

	@Autowired
	@Qualifier("basseServiceClient")
	private BasseService basseServiceClient;

	@Autowired
	@Qualifier("baseAdress")
	private String baseAdress;

	@Test
	public void test1() throws Exception {
		log.info("Starting Server");
		try {
			Endpoint.publish(WebServiceUtils.createServiceAdress(BasseService.class, baseAdress), basseService);

			log.info("wait");
			List<Basse> basses = basseServiceClient.getBasses();
			for (Basse basse : basses) {
				log.info("marque: " + basse.getMarque() + ", " + basse.getModel());
			}
		} catch (Exception e) {
			log.error("erreur", e);
			e.printStackTrace();
			throw e;
		}
	}

}

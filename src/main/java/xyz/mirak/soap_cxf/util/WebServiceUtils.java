package xyz.mirak.soap_cxf.util;

public class WebServiceUtils {
	public static String createServiceAdress(Class<?> clazz, String baseAdress) {
		return baseAdress + clazz.getSimpleName();
	}

}

package de.hsw.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationStarter {
	
	private static Logger LOG = LoggerFactory.getLogger(ApplicationStarter.class);
	
	public static void main(String[] args) {
		
		final Rational a = new Rational(3);
		final Rational b = new Rational(1, 2);
		final Rational result = a.multiply(b);
		
		LOG.info("{} * {} = {}", a, b, result);
		
	}

}

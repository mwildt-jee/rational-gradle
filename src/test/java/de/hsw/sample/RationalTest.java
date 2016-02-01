package de.hsw.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class RationalTest {

	@Test
	public void addTest(){
		 Rational a = new Rational(2,4);
		 Rational b = a.add(new Rational(1,4));
		 
		 assertEquals(3, b.getNumerator());
		 assertEquals(4, b.getDenominator());
		 
		 Rational c = new Rational(5,8);
		 Rational d = c.add(new Rational(1,4));
		 
		 assertEquals(7, d.getNumerator());
		 assertEquals(8, d.getDenominator());
	}
	
	@Test
	public void multiplyTest(){
		 Rational a = new Rational(2,4);
		 Rational b = a.multiply(new Rational(2,1));
		 
		 assertEquals(1, b.getNumerator());
		 assertEquals(1, b.getDenominator());
		 
		 Rational c = new Rational(5,8);
		 Rational d = c.multiply(new Rational(1,4));
		 
		 assertEquals(5, d.getNumerator());
		 assertEquals(32, d.getDenominator());
	}
	
	@Test
	public void euclidTest() {	
		assertEquals(2, Rational.euclid(2, 4));
		assertEquals(1, Rational.euclid(3, 4));
		assertEquals(6, Rational.euclid(12, 30));
		
		assertEquals(2, new Rational(2,4).getDenominator());
		assertEquals(1, new Rational(2,4).getNumerator());
		
		assertEquals(2, new Rational(12, 30).getNumerator());
		assertEquals(5, new Rational(12, 30).getDenominator());
	}

}

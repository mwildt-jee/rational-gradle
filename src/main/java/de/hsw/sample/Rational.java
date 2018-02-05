package de.hsw.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rational {

	private static Logger LOG = LoggerFactory.getLogger(Rational.class);
	
	private int numerator;
	private int denominator;
	
	public Rational(int number){
		LOG.info("Rational created from number");
		this.numerator = number;
		this.denominator = 1;
	}
	
	public Rational(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
		this.reduce();
		LOG.info("{} created from {}/{}", this, numerator, denominator);
	}
	
	public Rational(Rational rational){
		this(rational.numerator, rational.denominator);
	}
	
	public Rational add(Rational summand){
		LOG.info("summand {} to {}", summand, this);
		return new Rational(
			(this.numerator * summand.denominator) + (summand.numerator * this.denominator),
			this.denominator * summand.denominator
		); 	
	}
	
	public Rational multiply(Rational factor){
		LOG.info("multiply {} with {}", this, factor);
		return new Rational(
			this.numerator * factor.numerator,
			this.denominator * factor.denominator
		);
	}
	
	private void reduce(){
		int divisor = this.euclid(this.getDenominator(), this.getNumerator());
		this.numerator = this.getNumerator() / divisor;
		this.denominator = this.getDenominator() / divisor;
	}
	
	public static int euclid(int a, int b){
		if(b == 0){
			return a;
		} else {
			return euclid(b, a % b);
		}
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Rational {")
				.append(this.numerator);
		if(this.denominator != 1) {
			sb.append("/").append(this.denominator);
		}
		sb.append("}");
		return sb.toString();
	}
	
	
	public boolean equals(Object object){
		if(!(object instanceof Rational)){
			return false;
		}
		Rational r = (Rational) object;
		return this.getDenominator() == r.getDenominator() && this.getNumerator() == r.getNumerator(); 
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}
	
}

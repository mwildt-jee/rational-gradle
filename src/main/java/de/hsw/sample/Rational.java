package de.hsw.sample;

import org.apache.log4j.Logger;

public class Rational {

	private static Logger LOG = Logger.getLogger(Rational.class); 
	
	private int numerator;
	private int denominator;
	
	public Rational(int number){
		LOG.info("Rational created from number");
		this.numerator = number;
		this.denominator = 1;
	}
	
	public Rational(int numerator, int denominator){
		LOG.info("Rational created");
		this.numerator = numerator;
		this.denominator = denominator;
		this.reduce();
	}
	
	public Rational(Rational rational){
		this(rational.numerator, rational.denominator);
	}
	
	public Rational add(Rational summand){
		return new Rational(
			(this.numerator * summand.denominator) + (summand.numerator * this.denominator),
			this.denominator * summand.denominator
		); 	
	}
	
	public Rational multiply(Rational factor){
		LOG.info(this.numerator * factor.numerator);
		LOG.info(this.denominator * factor.denominator);
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

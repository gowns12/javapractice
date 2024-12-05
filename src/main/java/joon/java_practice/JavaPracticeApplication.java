package joon.java_practice;

import ClassAndObject.Author;
import ClassAndObject.Money;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPracticeApplication {

	public static void main(String[] args) throws Exception {
		Money money = new Money(1000);
	}

}

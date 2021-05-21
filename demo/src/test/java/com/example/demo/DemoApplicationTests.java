package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
class DemoApplicationTests {

	@Autowired private ApplicationContext ctx;

	// Need to specify Qualifier in order to get the correct number format
	@Qualifier("defaultCurrencyFormat")
	@Autowired
	private NumberFormat nf;

	@Test
	public void getDefaultCurrency() {
		double amount = 123.456;
		System.out.println(nf.format(amount));
		return;
	}

	// get the nf for the german currency from the ctx
	@Test
	public void getGermanCurrency() {
		double amount = 123.456;
		NumberFormat germanCurrencyFormat = ctx.getBean("germanCurrencyFormat", NumberFormat.class);
		System.out.println(germanCurrencyFormat.format(amount));
		return;
	}


	@Test
	public void contextLoads() {
		int count = ctx.getBeanDefinitionCount();
		System.out.println("num of beans: " + count);
		return;
	}

}
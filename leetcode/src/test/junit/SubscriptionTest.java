package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubscriptionTest {

	@Test
	public void test_returnEuro() {
		System.out.println("Test if princePerMonth returns Euro...");
		Subscription S = new Subscription(200, 2);
		assertTrue(S.pricePerMonth() == 100.0);
	}
	
	@Test
	public void test_roundUp() {
		System.out.println("Test if pricePerMonth rounds up correctly...");
		Subscription S = new Subscription(200, 4);
		assertTrue(S.pricePerMonth() == 50);
	}

}

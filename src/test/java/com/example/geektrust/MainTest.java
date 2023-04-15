package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MainTest {
	
	private SubscriptionDetails subDtls;
	
	@Test
	public void testSubscriptionStartDateValid() {
		subDtls = new SubscriptionDetails();
		String date = "20-10-2022";
		boolean validDateFormat = subDtls.validateSubscriptionStartDate(date);
		assertEquals(true, validDateFormat);
	}
	
	@Test
	public void testSubscriptionStartDateInValid() {
		subDtls = new SubscriptionDetails();
		String date = "20-15-2022";
		boolean validDateFormat = subDtls.validateSubscriptionStartDate(date);
		assertNotEquals(true, validDateFormat);
	}
	
	@Test
	public void testMusicPersonalRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("MUSIC");
		sub.setSubscriptionType("PERSONAL");
		assertEquals(100, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testMusicPremiumRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("MUSIC");
		sub.setSubscriptionType("PREMIUM");
		assertEquals(250, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testMusicTrialRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("MUSIC");
		sub.setSubscriptionType("FREE");
		assertEquals(0, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testVideoPersonalRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("VIDEO");
		sub.setSubscriptionType("PERSONAL");
		assertEquals(200, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testVideoPremiumRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("VIDEO");
		sub.setSubscriptionType("PREMIUM");
		assertEquals(500, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testVideoTrialRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("VIDEO");
		sub.setSubscriptionType("FREE");
		assertEquals(0, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testPodcastPersonalRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("PODCAST");
		sub.setSubscriptionType("PERSONAL");
		assertEquals(100, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testPodcastPremiumRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("PODCAST");
		sub.setSubscriptionType("PREMIUM");
		assertEquals(300, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testPodcastTrialRenewalCost() {
		subDtls = new SubscriptionDetails();
		Subscription sub = new Subscription();
		sub.setSubscriptionName("PODCAST");
		sub.setSubscriptionType("FREE");
		assertEquals(0, subDtls.calculateRenewalCost(sub));
	}
	
	@Test
	public void testMusicTrialExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("MUSIC");
		sub.setSubscriptionType("FREE");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testMusicPersonalExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("MUSIC");
		sub.setSubscriptionType("PERSONAL");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testMusicPremiumExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("MUSIC");
		sub.setSubscriptionType("PREMIUM");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 7, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	
	@Test
	public void testVideoTrialExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("VIDEO");
		sub.setSubscriptionType("FREE");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testVideoPersonalExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("VIDEO");
		sub.setSubscriptionType("PERSONAL");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testVideoPremiumExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("VIDEO");
		sub.setSubscriptionType("PREMIUM");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 7, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testPodcastTrialExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("PODCAST");
		sub.setSubscriptionType("FREE");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testPodcastPersonalExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("PODCAST");
		sub.setSubscriptionType("PERSONAL");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testPodcastPremiumExpiryDate() {
		subDtls = new SubscriptionDetails();
		subDtls.setSubscriptionStartTime(LocalDate.of(2023, 4, 2));
		Subscription sub = new Subscription();
		sub.setSubscriptionName("PODCAST");
		sub.setSubscriptionType("PREMIUM");
		Subscription testRenewedSubscription = sub;
		testRenewedSubscription.setExpiryDate(LocalDate.of(2023, 7, 2));
		assertEquals(testRenewedSubscription, subDtls.calculateExpiryDate(sub));
	}
	
	@Test
	public void testAdd2DifferentSubcriptions() throws Exception {
		subDtls = new SubscriptionDetails();
		subDtls.validateSubscriptionStartDate("02-04-2020");
		Subscription sub1 = new Subscription();
		Subscription sub2 = new Subscription();
		List<Subscription> testAddedSubscriptions = new ArrayList<>();
		sub1.setSubscriptionName("MUSIC");
		sub1.setSubscriptionType("PERSONAL");
		sub2.setSubscriptionName("VIDEO");
		sub2.setSubscriptionType("PERSONAL");
		
		Subscription testSubscription = sub1;
		testSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		subDtls.addSubscription("MUSIC", "PERSONAL");
		testAddedSubscriptions.add(testSubscription);
		
		testSubscription = sub2;
		testSubscription.setExpiryDate(LocalDate.of(2023, 5, 2));
		subDtls.addSubscription("VIDEO", "PERSONAL");
		testAddedSubscriptions.add(testSubscription);
		
		assertEquals(testAddedSubscriptions, subDtls.getSubscriptions());
	}
	
	@Test
	public void testAddDuplicateCategorySubcriptionError() throws Exception {
		subDtls = new SubscriptionDetails();
		subDtls.validateSubscriptionStartDate("02-04-2020");
		
		subDtls.addSubscription("MUSIC", "PERSONAL");
		
		assertThrows(SubscriptionException.class, () -> subDtls.addSubscription("MUSIC", "PREMIUM"), "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
	}
	
	@Test
	public void testCalculateTopup4Device() throws Exception {
		subDtls = new SubscriptionDetails();
		String topup = "FOUR_DEVICE", number = "4";
		subDtls.validateSubscriptionStartDate("02-04-2020");
		subDtls.calculateTopupCharge(topup, number);
		assertEquals(200, subDtls.getTopupCharge());
	}
	
	@Test
	public void testCalculateTopup10Device() throws Exception {
		subDtls = new SubscriptionDetails();
		String topup = "TEN_DEVICE", number = "3";
		subDtls.validateSubscriptionStartDate("02-04-2020");
		subDtls.calculateTopupCharge(topup, number);
		assertEquals(300, subDtls.getTopupCharge());
	}
	
	@Test
	public void testMultipleCalculateTopup() throws Exception {
		subDtls = new SubscriptionDetails();
		subDtls.validateSubscriptionStartDate("02-04-2020");
		subDtls.calculateTopupCharge("FOUR_DEVICE", "4");
		String topup = "TEN_DEVICE", num = "3";
		assertThrows(SubscriptionException.class, () -> subDtls.calculateTopupCharge(topup, num), "ADD_TOPUP_FAILED DUPLICATE_TOPUP");
	}
}
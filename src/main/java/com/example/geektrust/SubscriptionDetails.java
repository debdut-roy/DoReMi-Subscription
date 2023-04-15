package com.example.geektrust;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionDetails {

	private List<Subscription> subscriptions;
	private LocalDate subscriptionStartDate;
	private Long renewalCost;
	private Long topupCharge;
	private boolean validSubscriptionStartDate;
	private final Map<String, Map<String, List<Integer>>> subscriptionData;
	
	
	public SubscriptionDetails() {
		Map<String, List<Integer>> musicSubscriptionDetails = new HashMap<>();
		musicSubscriptionDetails.put("FREE", List.of(0,1));
		musicSubscriptionDetails.put("PERSONAL", List.of(100,1));
		musicSubscriptionDetails.put("PREMIUM", List.of(250,3));
		
		Map<String, List<Integer>> videoSubscriptionDetails = new HashMap<>();
		videoSubscriptionDetails.put("FREE", List.of(0,1));
		videoSubscriptionDetails.put("PERSONAL", List.of(200,1));
		videoSubscriptionDetails.put("PREMIUM", List.of(500,3));
		
		Map<String, List<Integer>> podcastSubscriptionDetails = new HashMap<>();
		podcastSubscriptionDetails.put("FREE", List.of(0,1));
		podcastSubscriptionDetails.put("PERSONAL", List.of(100,1));
		podcastSubscriptionDetails.put("PREMIUM", List.of(300,3));
		
		subscriptionData = new HashMap<>();
		this.subscriptionData.put("MUSIC", musicSubscriptionDetails);
		this.subscriptionData.put("VIDEO", videoSubscriptionDetails);
		this.subscriptionData.put("PODCAST", podcastSubscriptionDetails);
		
		this.subscriptions = new ArrayList<>();
		this.renewalCost = 0L;
		this.topupCharge = 0L;
	}
	public LocalDate getSubscriptionStartTime() {
		return subscriptionStartDate;
	}
	public void setSubscriptionStartTime(LocalDate subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	public Long getRenewalCost() {
		return renewalCost;
	}
	public void setRenewalCost(Long renewalCost) {
		this.renewalCost = renewalCost;
	}
	public Long getTopupCharge() {
		return topupCharge;
	}
	public void setTopupCharge(Long topupCharge) {
		this.topupCharge = topupCharge;
	}
	
	public boolean validateSubscriptionStartDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			this.subscriptionStartDate = LocalDate.parse(date, formatter);
			this.validSubscriptionStartDate = true;
			return this.validSubscriptionStartDate;
		}
		catch(DateTimeParseException e) {
			System.out.println("INVALID_DATE");
        	return this.validSubscriptionStartDate;
		}
	}
	
	public void addSubscription(String subscriptionName, String subscriptionType) throws SubscriptionException{
		if(!this.validSubscriptionStartDate) {
			throw new SubscriptionException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
		}
		Subscription subscription = new Subscription();
		subscription.setSubscriptionName(subscriptionName);
		subscription.setSubscriptionType(subscriptionType);
		
		if(this.subscriptions.contains(subscription)) {
			throw new SubscriptionException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
		}
		calculateRenewalCost(subscription);
		Subscription renewedSubscription = calculateExpiryDate(subscription);
		this.subscriptions.add(renewedSubscription);
		
	}
	
	public Long calculateRenewalCost(Subscription sub) {
		this.renewalCost += subscriptionData.get(sub.getSubscriptionName()).get(sub.getSubscriptionType()).get(0);
		return this.renewalCost;
	}
	
	public Subscription calculateExpiryDate(Subscription sub) {
		int renewalTime = subscriptionData.get(sub.getSubscriptionName()).get(sub.getSubscriptionType()).get(1);
		sub.setExpiryDate(this.getSubscriptionStartTime().plusMonths(renewalTime));
		return sub;
	}
	
	public void calculateTopupCharge(String topup, String number) throws SubscriptionException {
		int topupCharge = 0, num=0;
		if(!this.validSubscriptionStartDate) {
			throw new SubscriptionException("ADD_TOPUP_FAILED INVALID_DATE");
		}
		if(this.topupCharge > 0) {
			throw new SubscriptionException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
		}
		num = Integer.parseInt(number);
		if(topup.equals("FOUR_DEVICE")) {
			topupCharge = 50;
		}
		else if(topup.equals("TEN_DEVICE")) {
			topupCharge = 100;
		}
		this.topupCharge = (long) (topupCharge*num);
		
	}
	
	public void printRenewalDetails() throws SubscriptionException {
		if(this.getSubscriptions() == null || this.getSubscriptions().size() == 0) {
			throw new SubscriptionException("SUBSCRIPTIONS_NOT_FOUND");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for(Subscription sub : this.getSubscriptions()) {
    		LocalDate renewalReminder = sub.getExpiryDate().minusDays(10);
			System.out.println("RENEWAL_REMINDER "+sub.getSubscriptionName()+" "+renewalReminder.format(formatter));
    	}
		renewalCost = this.getRenewalCost();
		renewalCost += topupCharge;
    	System.out.println("RENEWAL_AMOUNT "+renewalCost);
		
	}
}

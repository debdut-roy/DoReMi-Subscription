package com.example.geektrust;

import java.time.LocalDate;
import java.util.Objects;

public class Subscription {

	private String subscriptionName;
	private String subscriptionType;
	private LocalDate expiryDate;
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setSubscriptionName(String name) {
		this.subscriptionName = name;
	}
	public void setSubscriptionType(String type) {
		this.subscriptionType = type;
	}
	public String getSubscriptionName() {
		return this.subscriptionName;
	}
	public String getSubscriptionType() {
		return this.subscriptionType;
	}
	@Override
	public String toString() {
		return "Subscription [subscriptionName=" + subscriptionName + ", subscriptionType=" + subscriptionType
				+ ", expiryDate=" + expiryDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(subscriptionName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		return Objects.equals(subscriptionName, other.subscriptionName);
	}
	
}

package com.model;

import java.util.Objects;

public class Carts {
    private int cardId;
    private int customerId;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cardId, customerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carts other = (Carts) obj;
		return cardId == other.cardId && customerId == other.customerId;
	}
	@Override
	public String toString() {
		return "Carts [cardId=" + cardId + ", customerId=" + customerId + "]";
	}
	public Carts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carts(int cardId, int customerId) {
		super();
		this.cardId = cardId;
		this.customerId = customerId;
	}
	
}

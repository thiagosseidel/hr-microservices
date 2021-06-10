package com.thiagosseidel.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.thiagosseidel.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public PaymentService() {
		super();
	}
	
	public Payment getPayment(Long workerId, Integer days ) {
		
		return new Payment("Bob", 200.0, days);
	}

}

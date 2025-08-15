package com.surya.service;

import com.surya.request.Passenger;
import com.surya.response.Ticket;

public interface BookingService {

	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer ticketNumber);
}

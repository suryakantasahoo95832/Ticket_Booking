package com.surya.service;

import com.surya.request.Passenger;
import com.surya.response.Ticket;

public interface MakeMyTrip {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicketByNum(Integer ticketNumber);
}

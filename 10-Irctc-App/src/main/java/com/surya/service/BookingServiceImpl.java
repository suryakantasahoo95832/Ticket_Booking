package com.surya.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.surya.request.Passenger;
import com.surya.response.Ticket;

@Service
public class BookingServiceImpl implements BookingService{

	private Map<Integer,Ticket> map=new HashMap<>();
	private Integer ticketNum=1;
	
	public Ticket bookTicket(Passenger passenger) {
		// TODO Auto-generated method stub
		Ticket t =new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(1700d);
		t.setStatus("Confirmed");
		
		t.setTicketNum(ticketNum);
		
		map.put(ticketNum++, t);
		return t;
	}

	
	public Ticket getTicket(Integer ticketNumber) {
	
		if(map.containsKey(ticketNumber)) {
			return map.get(ticketNumber);
		}
		
		return null;
	}

	
}

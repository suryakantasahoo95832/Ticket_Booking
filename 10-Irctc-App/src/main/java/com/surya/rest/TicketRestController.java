package com.surya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surya.request.Passenger;
import com.surya.response.Ticket;
import com.surya.service.BookingServiceImpl;

@RestController
public class TicketRestController {

	@Autowired
	BookingServiceImpl bpl;
	
	@PostMapping("/bookTct")
	public ResponseEntity<Ticket> bookTheTicket(@RequestBody Passenger p){
		Ticket ticket = bpl.bookTicket(p);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.CREATED);
		}
	
	@GetMapping("/get/{id}")
	public Ticket getTicketByTicketNum(@PathVariable("id") Integer TicketNum) {
	 return	bpl.getTicket(TicketNum);
}
}

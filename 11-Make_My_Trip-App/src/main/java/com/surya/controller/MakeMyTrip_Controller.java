package com.surya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.surya.request.Passenger;
import com.surya.response.Ticket;
import com.surya.service.MakeMyTripImpl;

@Controller
public class MakeMyTrip_Controller {

	@Autowired
	MakeMyTripImpl service;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("passenger", new Passenger());
		model.addAttribute("t",new Ticket());
		return "index";
	}
	
	@PostMapping("/bookTicket")	
	public String bookTrainTicket(@ModelAttribute("passenger") Passenger p, Model model) {
	//	System.out.println(p);   for checking propose...
		Ticket ticket = service.bookTicket(p);
		//System.out.println(ticket);
		model.addAttribute("msg","Ticket Booked Successfully ticketNumber="+ticket.getTicketNum());
		model.addAttribute("t",ticket);
		return "index";
	}
	
	   @GetMapping("/getticket")
	    public String showTicketPage(@RequestParam("ticketNum") Integer ticketNum ,Model model) {
	       Ticket ticketByNum = service.getTicketByNum(ticketNum);
	        model.addAttribute("t", ticketByNum);
		   return "ticket"; 
	    }
	   
	   @GetMapping("/search")
	   public String getTicketByTctNum() {
		   return "getByTnum";
	   }
}













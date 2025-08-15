package com.surya.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.surya.request.Passenger;
import com.surya.response.Ticket;

@Service
public class MakeMyTripImpl implements MakeMyTrip{

	private String bookTctUrl="http://localhost:8080/bookTct";
	private String getTctUrl="http://localhost:8080/get/{id}";
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		/*
		 * In spring boot We can develop consumer application in three ways 
		 * 
		 * 1--RestTemplete (Out Dated)-its a Class ,when we add web stater in Spring boot then this class is automatically added 
  		 * 
  		 * 2--WebClient (From Spring 5.x)--Its a interface it available in webFlux stater 
  		 * 
  		 * 3--FeignClient
		
		Using-----RestTemplete...
	
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(bookTctUrl,passenger,Ticket.class);		
		Ticket ticket = responseEntity.getBody();
		return ticket;
		*/
		
		//Using WebClient---------------
		
		WebClient webClient=WebClient.create();
		Ticket ticket = webClient.post()
		         .uri(bookTctUrl)
		         .bodyValue(passenger)
		         .retrieve()
		         .bodyToMono(Ticket.class)
		         .block();
		
		         return ticket;
	}

	
	@Override
	public Ticket getTicketByNum(Integer ticketNumber) {
		/*
		 * Using RestTemplete-------------
		 * 
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(getTctUrl,Ticket.class,ticketNumber);
        Ticket ticket = responseEntity.getBody();
        return ticket;
	
	*/
		//Using WebClient==================
		
		 
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
		         .uri(getTctUrl,ticketNumber)
		         .retrieve()
		         .bodyToMono(Ticket.class)
		         .block(); //this is used to wait for the response....//syns response
		                                                   //.subscribe..//non syns response
		         
		         return ticket;
	}

}

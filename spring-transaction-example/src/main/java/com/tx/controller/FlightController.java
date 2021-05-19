package com.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tx.dto.FlightBookingRequest;
import com.tx.dto.ResponseDTO;
import com.tx.service.FlightBookingService;

@RestController
public class FlightController {
	@Autowired
	private FlightBookingService service;

	// @Transactional

	@PostMapping("/bookFlightTicket")
	public ResponseEntity<ResponseDTO> bookFlightTicket(@RequestBody FlightBookingRequest request) {
		ResponseDTO responseDTO = new ResponseDTO("flight booked successfully", service.bookFlightTicket(request));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
//	{
//	    "passengerInfo": {
//	        "arrivalTime": "string",
//	        "destination": "string",
//	        "email": "string",
//	        "fare": 1000000.0,
//	        "name": "string",
//	        "pickupTime": "string",
//	        "source": "string",
//	        "travelDate": "1-12-2022"
//	    },
//	    "paymentInfo": {
//	        "accountNo": "acc1",
//	        "cardType": "debit"
//	    }
//	}
}

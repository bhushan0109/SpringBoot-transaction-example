package com.javatechie.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.tx.dto.FlightBookingRequest;
import com.javatechie.tx.dto.ResponseDTO;
import com.javatechie.tx.service.FlightBookingService;

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
}

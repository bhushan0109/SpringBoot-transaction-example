package com.tx.service;

import com.tx.dto.FlightBookingAcknowledgement;
import com.tx.dto.FlightBookingRequest;
import com.tx.entity.PassengerInfo;
import com.tx.entity.PaymentInfo;
import com.tx.repository.PassengerInfoRepository;
import com.tx.repository.PaymentInfoRepository;
import com.tx.utils.PaymentUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}

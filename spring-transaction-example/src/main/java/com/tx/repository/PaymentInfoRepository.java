package com.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tx.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}

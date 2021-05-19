package com.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tx.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}

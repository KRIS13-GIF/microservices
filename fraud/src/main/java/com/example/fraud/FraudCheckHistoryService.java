package com.example.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudelant(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .CustomerId(customerId)
                .isFraud(false)
                .createdAt(LocalDate.from(LocalDateTime.now()))
                .build());

        return false;
    }

}

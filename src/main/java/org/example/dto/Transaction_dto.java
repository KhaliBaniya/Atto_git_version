package org.example.dto;

import org.example.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction_dto {
    private Integer id;
    private Integer cardId;
    private Double amount;
    private Integer terminalId;
    private TransactionType transactionType;
    private LocalDateTime createdDate;

}

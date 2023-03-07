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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Transaction_dto{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", amount=" + amount +
                ", terminalId=" + terminalId +
                ", transactionType=" + transactionType +
                ", createdDate=" + createdDate +
                '}';
    }
}

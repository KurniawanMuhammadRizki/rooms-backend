package com.rooms.rooms.payment.entity;

import lombok.Data;

import java.util.List;

@Data
public class PaymentRequest {
     private String payment_type;
     private PaymentTransactionDetails transaction_details;
     private BankTransfer bank_transfer;
     private CustomerDetails customer_details;
     private CustomExpiry custom_expiry;
     private List<ItemDetail> item_details;
}

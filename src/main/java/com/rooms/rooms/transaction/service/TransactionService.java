package com.rooms.rooms.transaction.service;

import com.rooms.rooms.Responses.PageResponse;
import com.rooms.rooms.transaction.dto.MonthlyTransactionsDto;
import com.rooms.rooms.transaction.dto.TransactionRequest;
import com.rooms.rooms.transaction.dto.TransactionResponse;
import com.rooms.rooms.transaction.entity.Transaction;
import com.rooms.rooms.transaction.entity.TransactionStatus;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
     String createTransaction(TransactionRequest req);

     String updateTransactionStatus(Long transactionId, TransactionStatus status);

     String cancelTransaction(String bookingCode);

     String expireTransaction(String bookingCode);

     TransactionResponse getTransactionResponseById(Long id);

     Transaction getTransactionById(Long id);

     Transaction getTransactionByBookingCode(String bookingCode);

     List<TransactionResponse> getTransactionByStatus(TransactionStatus status);

     PageResponse<TransactionResponse> getTransactionByUsersId(
             Long usersId, int page, int size, TransactionStatus status, String sort);

     List<TransactionResponse> getTransactionByPropertyId(Long id);

     List<TransactionResponse> getTransactionByPropertyId(Long propertyId, LocalDate startDate, LocalDate endDate);

     List<TransactionResponse> getAllTransaction();

     TransactionResponse getTransactionResponseByBookingCode(String bookingCode);

     void acceptTransaction(String bookingCode, String signature);

     void pendingTransaction(String bookingCode);

     void sendCheckInReminder();

     void sendCheckInEmail();

     void acceptTransactionEmail();

     void checkPendingTransactions();

     void acceptCheckedTransactions();

     BigDecimal getTotalRevenueByPropertyId(Long propertyId, LocalDate startDate, LocalDate endDate);

     BigDecimal getTotalTaxByPropertyId(Long propertyId, LocalDate startDate, LocalDate endDate);

     BigDecimal getTotalRevenueWithTaxByPropertyId(Long propertyId, LocalDate startDate, LocalDate endDate);

     Integer getTotalTransactionsByPropertyId(Long propertyId, LocalDate startDate, LocalDate endDate);

     List<MonthlyTransactionsDto> getMonthlyTransactionsByPropertyId(Long propertyId);

     List<Transaction> getLatestTransactionsByPropertyId(Long propertyId);
}

package com.rooms.rooms.transaction.controller;

import com.rooms.rooms.helper.CurrentUser;
import com.rooms.rooms.helper.JwtClaims;
import com.rooms.rooms.transaction.dto.MonthlyTransactionsDto;
import com.rooms.rooms.transaction.dto.TransactionRequest;
import com.rooms.rooms.transaction.dto.TransactionResponse;
import com.rooms.rooms.transaction.entity.Transaction;
import com.rooms.rooms.transaction.entity.TransactionStatus;
import com.rooms.rooms.transaction.service.TransactionService;
import lombok.extern.java.Log;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Log
@Controller
public class TransactionResolver {
     private TransactionService transactionService;
     private  CurrentUser currentUser;

     public TransactionResolver(TransactionService transactionService, CurrentUser currentUser) {
          this.transactionService = transactionService;
          this.currentUser = currentUser;
     }

     @QueryMapping(value = "hello")
     public String sayHello() {
          return "Hallo Gaes!!!";
     }

//     @QueryMapping(value = "transactionById")
//     public TransactionResponse getTransactionById(@Argument Long id) {
//          return transactionService.getTransactionResponseById(id);
//     }

//     @QueryMapping(value = "transactions")
//     public List<TransactionResponse> getTransactions() {
//          return transactionService.getAllTransaction();
//     }
     @PreAuthorize("hasAuthority('SCOPE_TENANT')")
     @QueryMapping(value = "transactionsByStatus")
     public List<TransactionResponse> getTransactionByStatus(@Argument TransactionStatus status) {
          return transactionService.getTransactionByStatus(status);
     }

     @PreAuthorize("hasAuthority('SCOPE_USER')")
     @QueryMapping(value = "transactionsByUsersId")
     public List<TransactionResponse> getTransactionByUsersId() {
          Long usersId = currentUser.getCurrentUserId();
          return transactionService.getTransactionByUsersId(usersId);
     }

     @PreAuthorize("isAuthenticated()")
     @QueryMapping(value = "transactionsByBookingCode")
     public TransactionResponse getTransactionByBookingCode(@Argument String bookingCode) {
          return transactionService.getTransactionResponseByBookingCode(bookingCode);
     }

     @PreAuthorize("hasAuthority('SCOPE_TENANT')")
     @QueryMapping(value = "transactionsByPropertyId")
     public List<TransactionResponse> getTransactionByPropertyId(@Argument Long propertyId, @Argument LocalDate startDate, @Argument LocalDate endDate) {
          return transactionService.getTransactionByPropertyId(propertyId, startDate, endDate);
     }

     @PreAuthorize("hasAuthority('SCOPE_USER')")
     @MutationMapping(value = "createTransaction")
     public String createTransaction(@Argument("input") TransactionRequest input) {
          return transactionService.createTransaction(input);
     }

     @PreAuthorize("hasAuthority('SCOPE_USER')")
     @MutationMapping(value = "cancelTransaction")
     public String cancelTransaction(@Argument("bookingCode") String bookingCode) {
          return transactionService.cancelTransaction(bookingCode);
     }

     @PreAuthorize("hasAuthority('SCOPE_TENANT')")
     @QueryMapping(value = "revenueByProperty")
     public BigDecimal getRevenueByProperty(@Argument Long propertyId, @Argument LocalDate startDate, @Argument LocalDate endDate) {
          return transactionService.getTotalRevenueByPropertyId(propertyId, startDate, endDate);
     }

     @PreAuthorize("hasAuthority('SCOPE_TENANT')")
     @QueryMapping(value = "totalTransactionsByPropertyId")
     public Integer getTotalTransactionByPropertyId(@Argument Long propertyId, @Argument LocalDate startDate, @Argument LocalDate endDate) {
          return transactionService.getTotalTransactionsByPropertyId(propertyId, startDate, endDate);
     }

     @PreAuthorize("hasAuthority('SCOPE_TENANT')")
     @QueryMapping(value = "monthlyTransactionsByPropertyId")
     public List<MonthlyTransactionsDto> getMonthlyTransactions(@Argument Long propertyId) {
          return transactionService.getMonthlyTransactionsByPropertyId(propertyId);
     }

     @PreAuthorize("hasAuthority('SCOPE_TENANT')")
     @QueryMapping(value = "latestTransactionsByPropertyId")
     public List<Transaction> getLatestTransactionsByPropertyId(@Argument Long propertyId) {
          return transactionService.getLatestTransactionsByPropertyId(propertyId);
     }


}

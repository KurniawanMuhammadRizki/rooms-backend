package com.rooms.rooms.paymentProof.service;

import com.rooms.rooms.paymentProof.entity.PaymentProof;

import java.util.List;

public interface PaymentProofService {
     List<PaymentProof> getPendingManualTransferProofs();
     List<PaymentProof> getPendingTransactionProofsByPropertyId(Long propertyId);
     List<PaymentProof> getCheckTransactionProofsByPropertyId(Long propertyId);
     String acceptPaymentProof(Long  transactionId);
     String rejectPaymentProof(Long  transactionId);
     String addPaymentProof(Long transactionId, String imgUrl);
}

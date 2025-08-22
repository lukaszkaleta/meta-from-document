package com.hvd.docs.google.document.ai.schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceiptJson {

    String creditCardLastFourDigits;
    String currency;
    LocalDate endDate;
    BigDecimal netAmount;
    String paymentAuthorizationId;
    LocalDate receiptDate;
    String paymentType;
    LocalDate purchaseTime;
    LocalDate receiptSate;
    String reservationId;
    LocalDate startDate;
    String supplierAddress;
    String supplierCity;
    String supplierName;
    String supplierPhone;
    BigDecimal tipAmount;
    BigDecimal totalAmount;
    BigDecimal totalTaxAmount;
    String travelerName;

    List<LineItem> lineItem = new ArrayList<>();

    public String getCreditCardLastFourDigits() {
        return creditCardLastFourDigits;
    }

    public void setCreditCardLastFourDigits(String creditCardLastFourDigits) {
        this.creditCardLastFourDigits = creditCardLastFourDigits;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public String getPaymentAuthorizationId() {
        return paymentAuthorizationId;
    }

    public void setPaymentAuthorizationId(String paymentAuthorizationId) {
        this.paymentAuthorizationId = paymentAuthorizationId;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    public LocalDate getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDate purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public LocalDate getReceiptSate() {
        return receiptSate;
    }

    public void setReceiptSate(LocalDate receiptSate) {
        this.receiptSate = receiptSate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierCity() {
        return supplierCity;
    }

    public void setSupplierCity(String supplierCity) {
        this.supplierCity = supplierCity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(BigDecimal tipAmount) {
        this.tipAmount = tipAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    public static class LineItem {

        BigDecimal amount;
        String description;
        String productCode;
        Integer quantity;
        LocalDate transactionDate;

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public LocalDate getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(LocalDate transactionDate) {
            this.transactionDate = transactionDate;
        }
    }
}

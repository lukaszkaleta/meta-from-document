package com.hvd.docs.google.document.ai.schema;

import com.google.cloud.documentai.v1.Document;
import com.google.type.DateOrBuilder;
import com.profsys.integrator.common.java.lang.string.BigDecimalString;
import com.profsys.integrator.common.java.lang.string.SeparatedString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class InvoiceJson {

    String invoiceType;
    BigDecimal amountDue;
    BigDecimal amountPaidSinceLastInvoice;
    String carrier;
    String currency;
    Integer currencyExchangeRate;
    String customerTaxId;
    LocalDate deliveryDate;
    LocalDate dueDate;
    BigDecimal freightAmount;
    LocalDate invoiceDate;
    String invoiceId;

    BigDecimal netAmount;
    String paymentTerms;
    String purchaseOrder;
    String receiverAddress;
    String receiverEmail;
    String receiverName;
    String receiverPhone;
    String receiverTaxId;
    String receiverWebsite;
    String remitToAddress;
    String remitToName;
    String shipFromAddress;
    String shipFromName;
    String shipToAddress;
    String shipToName;
    String supplierAddress;
    String supplierEmail;
    String supplierIban;
    String supplierName;
    String supplierPaymentRef;
    String supplierPhone;
    String supplierRegistration;
    String supplierTaxId;
    String supplierWebsite;
    BigDecimal totalAmount;
    BigDecimal totalTaxAmount;

    final List<LineItem> lineItem = new ArrayList<>();
    final List<Vat> vat = new ArrayList<>();

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public BigDecimal getAmountPaidSinceLastInvoice() {
        return amountPaidSinceLastInvoice;
    }

    public void setAmountPaidSinceLastInvoice(BigDecimal amountPaidSinceLastInvoice) {
        this.amountPaidSinceLastInvoice = amountPaidSinceLastInvoice;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(Integer currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public String getCustomerTaxId() {
        return customerTaxId;
    }

    public void setCustomerTaxId(String customerTaxId) {
        this.customerTaxId = customerTaxId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverTaxId() {
        return receiverTaxId;
    }

    public void setReceiverTaxId(String receiverTaxId) {
        this.receiverTaxId = receiverTaxId;
    }

    public String getReceiverWebsite() {
        return receiverWebsite;
    }

    public void setReceiverWebsite(String receiverWebsite) {
        this.receiverWebsite = receiverWebsite;
    }

    public String getRemitToAddress() {
        return remitToAddress;
    }

    public void setRemitToAddress(String remitToAddress) {
        this.remitToAddress = remitToAddress;
    }

    public String getRemitToName() {
        return remitToName;
    }

    public void setRemitToName(String remitToName) {
        this.remitToName = remitToName;
    }

    public String getShipFromAddress() {
        return shipFromAddress;
    }

    public void setShipFromAddress(String shipFromAddress) {
        this.shipFromAddress = shipFromAddress;
    }

    public String getShipFromName() {
        return shipFromName;
    }

    public void setShipFromName(String shipFromName) {
        this.shipFromName = shipFromName;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public String getShipToName() {
        return shipToName;
    }

    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierIban() {
        return supplierIban;
    }

    public void setSupplierIban(String supplierIban) {
        this.supplierIban = supplierIban;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPaymentRef() {
        return supplierPaymentRef;
    }

    public void setSupplierPaymentRef(String supplierPaymentRef) {
        this.supplierPaymentRef = supplierPaymentRef;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierRegistration() {
        return supplierRegistration;
    }

    public void setSupplierRegistration(String supplierRegistration) {
        this.supplierRegistration = supplierRegistration;
    }

    public String getSupplierTaxId() {
        return supplierTaxId;
    }

    public void setSupplierTaxId(String supplierTaxId) {
        this.supplierTaxId = supplierTaxId;
    }

    public String getSupplierWebsite() {
        return supplierWebsite;
    }

    public void setSupplierWebsite(String supplierWebsite) {
        this.supplierWebsite = supplierWebsite;
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

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public List<Vat> getVat() {
        return vat;
    }

    public InvoiceJson() {
    }

    public static class Vat {

        BigDecimal amount;
        String category_Code;
        BigDecimal taxAmount;
        Integer taxRate;

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getCategory_Code() {
            return category_Code;
        }

        public void setCategory_Code(String category_Code) {
            this.category_Code = category_Code;
        }

        public BigDecimal getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(BigDecimal taxAmount) {
            this.taxAmount = taxAmount;
        }

        public Integer getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(Integer taxRate) {
            this.taxRate = taxRate;
        }
    }

    public static class LineItem {

        BigDecimal amount;
        String description;
        String productCode;
        String purchaseOrder;
        Integer quantity;
        String unit;
        BigDecimal unitPrice;

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

        public String getPurchaseOrder() {
            return purchaseOrder;
        }

        public void setPurchaseOrder(String purchaseOrder) {
            this.purchaseOrder = purchaseOrder;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public BigDecimal getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
        }
    }
}

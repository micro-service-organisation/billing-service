package org.sid.enset.billingservice.services;

import org.sid.enset.billingservice.dtos.InvoiceRequestDto;
import org.sid.enset.billingservice.dtos.InvoiceResponseDto;

import java.util.List;

public interface InvoiceService {

    InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);

    InvoiceResponseDto getInvoice(String invoiceId);

    List<InvoiceResponseDto> invoicesByCustomerId(String customerId);

    List<InvoiceResponseDto> getInvoices();
}

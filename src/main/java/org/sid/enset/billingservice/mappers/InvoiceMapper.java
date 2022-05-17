package org.sid.enset.billingservice.mappers;

import org.mapstruct.Mapper;
import org.sid.enset.billingservice.dtos.InvoiceRequestDto;
import org.sid.enset.billingservice.dtos.InvoiceResponseDto;
import org.sid.enset.billingservice.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    Invoice fromInvoiceRequestDto(InvoiceRequestDto invoiceRequestDto);
    InvoiceResponseDto invoiceResponseDtoFromInvoice(Invoice invoice);
}

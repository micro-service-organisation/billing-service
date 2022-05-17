package org.sid.enset.billingservice.services;

import org.sid.enset.billingservice.dtos.InvoiceRequestDto;
import org.sid.enset.billingservice.dtos.InvoiceResponseDto;
import org.sid.enset.billingservice.entities.Customer;
import org.sid.enset.billingservice.entities.Invoice;
import org.sid.enset.billingservice.exceptions.CustomerNotFoundException;
import org.sid.enset.billingservice.mappers.InvoiceMapper;
import org.sid.enset.billingservice.openfeign.CustomerRestClient;
import org.sid.enset.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {
        Customer customer = null;

        try{
            customer = customerRestClient.getCustomer(invoiceRequestDto.getCustomerId());
        }
        catch (Exception e)
        {
            throw new CustomerNotFoundException(String.format("Customer %s not found, please add a valid customer for this invoice ", invoiceRequestDto.getCustomerId()), e);
        }


        Invoice invoice = invoiceMapper.fromInvoiceRequestDto(invoiceRequestDto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice = invoiceRepository.save(invoice);
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceResponseDtoFromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDto getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();

        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceResponseDtoFromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDto> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        return invoices.stream()
                .map(invoice -> invoiceMapper.invoiceResponseDtoFromInvoice(invoice))
                .collect(Collectors.toList());

    }

    @Override
    public List<InvoiceResponseDto> getInvoices() {

        List<Invoice> allInvoices = invoiceRepository.findAll();

        allInvoices.forEach(invoice -> {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        });

        return allInvoices
                .stream()
                .map(inv -> invoiceMapper.invoiceResponseDtoFromInvoice(inv))
                .collect(Collectors.toList());


    }
}

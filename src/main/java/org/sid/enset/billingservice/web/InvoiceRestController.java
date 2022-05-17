package org.sid.enset.billingservice.web;

import org.apache.http.HttpStatus;
import org.sid.enset.billingservice.dtos.InvoiceRequestDto;
import org.sid.enset.billingservice.dtos.InvoiceResponseDto;
import org.sid.enset.billingservice.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {

    private final InvoiceService invoiceService;


    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices/{id}")
    public InvoiceResponseDto getInvoice(@PathVariable(name = "id") String invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping("/invoices/customer/{customerId}")
    public List<InvoiceResponseDto> getInvoicesByCustomer(@PathVariable(name = "id") String customerId) {
        return invoiceService.invoicesByCustomerId(customerId);
    }


    @PostMapping("/invoices")
    public InvoiceResponseDto save(@RequestBody InvoiceRequestDto invoiceRequestDto) {
        return invoiceService.save(invoiceRequestDto);
    }


    @GetMapping("/invoices")
    public List<InvoiceResponseDto> allInvoices() {
        return invoiceService.getInvoices();
    }


    @ExceptionHandler
    public ResponseEntity exceptionHanlder(Exception e)
    {
        return new ResponseEntity(e.getMessage(), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

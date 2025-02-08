package com.dthunn.accounts.service.client;

import com.dthunn.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="loans",fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("app-correlation-id")
                                              String correlationId, @RequestParam String mobileNumber);

}
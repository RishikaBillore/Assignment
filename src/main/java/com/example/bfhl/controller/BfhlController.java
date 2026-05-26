package com.example.bfhl.controller;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import com.example.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @PostMapping
    public ResponseDto process(@RequestBody RequestDto request) {
        return bfhlService.processData(request);
    }
}

package com.example.bfhl.controller;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import com.example.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP"
        );
    }

    @PostMapping("/bfhl")
    public ResponseDto process(@RequestBody RequestDto request) {
        return bfhlService.processData(request);
    }
}
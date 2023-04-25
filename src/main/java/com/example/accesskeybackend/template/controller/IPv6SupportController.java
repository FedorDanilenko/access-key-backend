package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.IPv6SupportService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web/")
@AllArgsConstructor
public class IPv6SupportController {

    private final IPv6SupportService ipv6SupportService;

    @GetMapping("/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@NonNull @RequestParam String siteUrl) {
        return ResponseEntity.ok(ipv6SupportService.checkIpv6Support(siteUrl));
    }
}

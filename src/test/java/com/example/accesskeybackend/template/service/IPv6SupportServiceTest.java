package com.example.accesskeybackend.template.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPv6SupportServiceTest {

    private IPv6SupportService service = new IPv6SupportService();

    @Test
    void testCheckIpv6SupportReturnsTrue() {
        assertTrue(service.checkIpv6Support("http://[::1]"));
    }

    @Test
    void testCheckIpv6SupportReturnsFalse() {
        assertFalse(service.checkIpv6Support("google.com"));
    }

    @Test
    void testCheckIpv6SupportThrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.checkIpv6Support("bad-url"));
    }

    @Test
    void testCheckIpv6SupportReturnsExceptionForNull() {
        assertThrows(IllegalArgumentException.class, () -> service.checkIpv6Support(null));
    }
}
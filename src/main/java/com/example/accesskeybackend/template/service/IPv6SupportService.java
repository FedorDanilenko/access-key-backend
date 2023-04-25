package com.example.accesskeybackend.template.service;

import java.net.*;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class IPv6SupportService {

    private final Pattern URL_PATTERN = Pattern.compile("^https?://.*");

    public boolean checkIpv6Support(String siteUrl) {
        if (siteUrl == null) throw new IllegalArgumentException("URL cannot be null");
        if (!URL_PATTERN.matcher(siteUrl).matches()) {
            siteUrl = "http://" + siteUrl;
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(new URL(siteUrl).getHost());
            return inetAddress instanceof Inet6Address;
        } catch (UnknownHostException | MalformedURLException e) {
            throw new IllegalArgumentException("Bad URL:" + siteUrl);
        }
    }
}

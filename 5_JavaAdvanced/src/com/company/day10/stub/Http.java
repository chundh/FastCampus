package com.company.day10.stub;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Http {
    String get(String targetUrl) throws IOException;
}

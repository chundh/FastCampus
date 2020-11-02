package com.company.day10.stub;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WebparserTest {

    /**
     * 이렇게 테스트 하는것의 문제점
     * - 느리다. Fast에 대응되지 않는다.
     * - 웹페이지 내용이 변할 수 있다.
     */
//    @Test
//    public void countImageFromGoogleDotCom() throws IOException {
//        Webparser webparser = new Webparser();
//        int actualResult = webparser.countImageFromWebPage("http://google.com");
//        assertThat(actualResult, equalTo(5));
//    }

    private Webparser parser;
    @Before
    public void setUpUsingPageWithThreeImages(){
        // Dependency Injection을 이용해 http 객체의 stub를 구현하여 넣어준다.
        parser = new Webparser((targetUrl) -> {
            return "<html> <meta content=a.png> <meta content=b.gif> <meta content=c.jpg> </html>";
        });
    }

    @Test
    public void countImageFrom() throws IOException {
        int actualResult = parser.
                countImageFromWebPage("http://google.com");
        assertThat(actualResult, is(equalTo(3)));
    }
}
package com.company.day10.TDD;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanConverterTest {
    RomanConverter converter;
    @Before
    public void setUp() throws Exception {
        converter = new RomanConverter();
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // 1. 빈 문자열 예외 처리하기
    @Test
    public void exceptionWhenRomanNotSet(){
        thrown.expect(ArithmeticException.class);
        int actualResult = converter.transform();
    }
    // 2. I를 테스트
    @Test
    public void coneverI(){
        converter.setRoman("I");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(1)));
    }
    // 3. X를 테스트
    @Test
    public void convertX(){
        converter.setRoman("X");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(10)));
    }
    // 4. III 테스트
    @Test
    public void convertIII(){
        converter.setRoman("III");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(3)));
    }
    // 5. IV를 테스트
    @Test
    public void convertIV(){
        converter.setRoman("IV");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(4)));
    }
    // 6. VV를 테스트
    @Test
    public void convertVV(){
        converter.setRoman("VV");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(6)));
    }
}
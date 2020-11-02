package com.company.day10.UnitTest;

/**
 * AAA(Triple-A)
 * - Arrange(준비) - 시스템이 적절한 상태에 있는지 확인. 객체를 생성하고, API를 호출하면서 테스트할 상태인지 파악한다.
 * - ACT(실행) - 실제로 테스트 코드를 실행
 * - Assert(단언) - 실행한 코드의 결과를 기대하는 값과 비교
 *
 * + @
 * After(사후) - 자원을 할당한 경우에는 이를 해지
 */

import org.junit.*;
import org.junit.rules.ExpectedException;

// CoreMatchers의 assertThat을 활용해서 실패했을 때 정보를 cli를 통해 자세히 알 수 있다.
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

// BeforeClass -> Before -> Test1 -> After -> Before -> Test2 -> After -> AfterClass

public class AccountTest {
    Account account2;
    @BeforeClass
    public static void classSetUp(){ // static으로 맨처음에 한번 실행된다.

    }

    @Before // before annotation을 사용해 먼저 생성할 수 있다.
    public void setUpBySetBalanceOneHundred() {
        account2 = new Account(100);
    }
    @Test
    public void answerIsMinusWithNegativeBalance(){
        Account account = new Account(100); // Arrange 과정
        account.withdraw(150); // ACT 고정
        boolean actualResult = account.isMinus();
        // boolean에 대한 assertion은 assertTrue, assertFalse를 쓴다.
//        assertTrue(actualResult);
        assertThat(actualResult, equalTo(false)); // Assert 과정
        // is, not을 사용해서 문맥을 더 매끄럽게 만들 수 있다.
        // assertThat(actualResult, is(equalTo(true)));
        // assertThat(actualResult, not(equalTo(false)));
    }
    @Test
    public void answerIsMinusWithPositiveBalance(){
        account2.withdraw(50);
        boolean actualResult = account2.isMinus();
        assertThat(actualResult, equalTo(false));
    }

    @Test
    public void checkPositiveBalanceAfterWithdrawal(){
        account2.withdraw(80);
        int actualResult = account2.getBalance();
        assertThat(actualResult, is(equalTo(20)));
    }

    @Test
    @Ignore ("This will be tested later")
    public void checkNegativeBalanceAfterWithdrawal(){
        account2.withdraw(120);
        int actualResult = account2.getBalance();
        assertThat(actualResult, is(equalTo(-20)));
    }

    // ArithmeticException이 발생하는지 assert하는 테스트

    // 간단하다는 장점이 있지만, 테스트 메소드 내부에 assert가 드러나지 않는다.
    @Test(expected = ArithmeticException.class)
    public void checkExceptionByAnnotation(){
//        account2.throwExcept();
    }
    // 인지적으로는 더 개선되지만, 코드가 매우 복잡해진다.
    @Test
    public void checkExceptionByTryCatch(){
        try {
//            account2.throwExcept();
        }catch (ArithmeticException e){
            assertThat(e.getClass(), equalTo(ArithmeticException.class));
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


//    @Test
//    public void checkExceptionByRule{
//        thrown.expect(ArithmeticException.class);
//        account2.throwExcept();
//    }
}
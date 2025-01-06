package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    Account account;
    Account account2;

    @BeforeEach
    void setUpAccount() {
        account = new Account(1000); //Initialising my account with this money sum
        account2 = new Account(500); //Initialising another account with this money sum
    }

    @Test
    void deposit() {
        account.deposit(200); //Adding 200 to my account, it should return 1200
        assertEquals(1200, account.checkBalance()); //Checks if the depositing worked
    }

    @Test
    void withdraw() {
        account.withdraw(300); //Taking 300 from my account, it should return 700
        assertEquals(700, account.checkBalance());   //Checks if the withdrawal worked
    }

    @Test
    void checkBalance(){
    assertEquals(1000, account.checkBalance()); //Simply checks the initial money sum in my account
    }

    @Test
    void transfer(){
        account.transfer(400, account2); //Transfers 400 to the second accout
        assertEquals(600, account.checkBalance()); // 400 are removed from my initial sum of money
        assertEquals(900, account2.checkBalance()); // 400 are added from the second account initial sum of money
    }

    @Test
    void depositNoMoney() {
        account.deposit(-1000);  // Negative deposit is not taken into consideration
        assertEquals(1000, account.checkBalance());
    }

    @Test
    void withdrawNegative() {
        account.withdraw(-1000);  // Negative withdrawal is not taken into consideration
        assertEquals(1000, account.checkBalance());
    }

}

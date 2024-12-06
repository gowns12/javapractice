package BankAccountClass;

public class BankAccount {
    public String accountNumber;
    public Money balance;
    public String owner;
    public String dateOfCreate;

    public BankAccount(String accountNumber, Money balance, String owner) {
        if (accountNumber.length() != 13) {
            throw new IllegalArgumentException("계좌를 잘못입력하셨습니다");
        }
        if (owner.length() > 10) {
            throw new IllegalArgumentException("이름이 너무 깁니다");

        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(Money money) {
        balance = money.plusMoney(balance);
    }

    public void withdraw(Money money) {
        balance = money.minusMoney(balance);
    }
}

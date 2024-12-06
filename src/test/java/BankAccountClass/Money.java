package BankAccountClass;

import java.util.Objects;

public class Money {
    private int money;

    public Money(int money) {
        if (money<0){
            throw new IllegalArgumentException("금액이 0보다 작을 수 없습니다.");
        }
        this.money = money;
    }

    public int plusMoney(int money){
        return this.money+money;
    }

    public int minusMoney(int money){
        return this.money-money;
    }

    public Money plusMoney(Money value){
        return new Money(value.plusMoney(money));
    }

    public Money minusMoney(Money value){
        return new Money(value.minusMoney(money));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money);
    }
}

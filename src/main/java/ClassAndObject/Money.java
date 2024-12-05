package ClassAndObject;

public class Money {
    public int money;

    public Money(int money) throws Exception {
        if (money<0){
            throw new Exception("금액이 0보다 작습니다.");
        }
        this.money = money;
    }
}

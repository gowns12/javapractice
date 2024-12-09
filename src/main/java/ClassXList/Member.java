package ClassXList;

public class Member {
    private String id;
    private String nickname;
    private String password;

    public Member(String id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public Member(String id, String password) {
        this.id = id;
        this.nickname = "";
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public String getNickname() {
        return nickname;
    }
}

package ClassXList;

public class MemberResponse {
    private String loginId;
    private String username;

    public MemberResponse(Member member) {
        this.loginId = member.getId();
        this.username = member.getNickname();
    }


    public String getLoginId() {
        return loginId;
    }

    public String getUsername() {
        return username;
    }
}

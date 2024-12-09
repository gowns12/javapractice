package ClassXList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemberResponseList {
    private List<MemberResponse> memberResponseList;

    public MemberResponseList(MemberList memberList) {
        List<MemberResponse> memberResponses = new ArrayList<>();
        for (int i = 0; i < memberList.getMemberList().size(); i++) {
            memberResponses.add(new MemberResponse(memberList.getMemberList().get(i)));
        }
        this.memberResponseList = memberResponses;
    }

    public List<MemberResponse> getMemberResponseList() {
        return memberResponseList;
    }

    public MemberResponseList(MemberList memberList, boolean nickName) {
        List<MemberResponse> memberResponses = new ArrayList<>();
        if (nickName) {
            for (int i = 0; i < memberList.getMemberList().size(); i++) {
                if (!memberList.getMemberList().get(i).getNickname().isEmpty()) {
                    memberResponses.add(new MemberResponse(memberList.getMemberList().get(i)));
                }
            }
        } else {
            for (int i = 0; i < memberList.getMemberList().size(); i++) {
                if (memberList.getMemberList().get(i).getNickname().isEmpty()) {
                    memberResponses.add(new MemberResponse(memberList.getMemberList().get(i)));
                }
            }
        }

        this.memberResponseList = memberResponses;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberResponseList that = (MemberResponseList) o;
        return Objects.equals(memberResponseList, that.memberResponseList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberResponseList);
    }
}

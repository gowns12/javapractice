package ClassXLIst;

import ClassXList.Member;
import ClassXList.MemberList;
import ClassXList.MemberResponse;
import ClassXList.MemberResponseList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTests {

    @Test
    void member() {
        Member member = new Member("gowns4414", "준해", "12345");

        MemberResponse memberResponse = new MemberResponse(member);

        Assertions.assertThat(memberResponse.getLoginId()).isEqualTo("gowns4414");
        Assertions.assertThat(memberResponse.getUsername()).isEqualTo("준해");
    }

    @Test
    void memberLists() {
        Member member1 = new Member("asd", "12254545");
        Member member2 = new Member("asdd",  "12544545");
        Member member3 = new Member("assgd","asdasd", "12545545");
        Member member4 = new Member("asdsfd",  "1254566145");
        Member member5 = new Member("asasdd",  "1254544735");
        Member member6 = new Member("aswed", "asddasd", "1254545465");

        MemberList memberList = new MemberList(List.of(member1, member2, member3, member4, member5, member6));

        MemberResponseList memberResponseList = new MemberResponseList(memberList);

        Assertions.assertThat(memberResponseList.getMemberResponseList().get(0).getLoginId()).isEqualTo(memberList.getMemberList().get(0).getId());

        MemberResponseList memberResponseList1 = new MemberResponseList(memberList, false);

        Assertions.assertThat(memberResponseList1.getMemberResponseList().size()).isEqualTo(4);

        MemberResponseList memberResponseList2 = new MemberResponseList(memberList, true);

        Assertions.assertThat(memberResponseList2.getMemberResponseList().size()).isEqualTo(2);

    }
}

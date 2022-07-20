package com.soongkordan.dothejib.Domain;

import com.soongkordan.dothejib.DOMAIN.Member;
import com.soongkordan.dothejib.REPOSITORY.MemberRepository;
import com.soongkordan.dothejib.SERVICE.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberDomainTest {

    @Autowired
    MemberRepository memberRepository ;
    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입(){
        Member member = getMember();
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();
        Assertions.assertThat(findMember).isEqualTo(findMember);
    }

    @Test
    public void 회원가입2(){
        Member member = getMember();
        Long savedMemberId = memberService.saveMember(member);

        Member findMember = memberRepository.findById(savedMemberId).get();
        Assertions.assertThat(findMember.getId()).isEqualTo(savedMemberId);
    }
    @Test
    public void email로회원찾기(){
        Member member1 = getMember();
        Member member2 = Member.createMember("dkansof@gmail.com","weijfw");
        Long savedMemberId1 = memberService.saveMember(member1);
        Long savedMemberId2 = memberService.saveMember(member2);

        Member findMember = memberRepository.findByEmail("wjddns@gmail.com");
        Assertions.assertThat(findMember.getId()).isEqualTo(savedMemberId1);
    }

    private Member getMember() {
        Member member = Member.createMember("wjddns@gmail.com","wjddns5656");
        return member;
    }

}

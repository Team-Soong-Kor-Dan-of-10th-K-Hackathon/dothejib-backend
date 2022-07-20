package com.soongkordan.dothejib.SERVICE;

import com.soongkordan.dothejib.DOMAIN.Member;
import com.soongkordan.dothejib.REPOSITORY.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long saveMember(Member member){
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

}

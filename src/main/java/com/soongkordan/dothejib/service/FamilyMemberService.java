package com.soongkordan.dothejib.service;

import com.soongkordan.dothejib.domain.Family;
import com.soongkordan.dothejib.domain.FamilyMember;
import com.soongkordan.dothejib.repository.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;

    /*
    * save : Long
    * findOne : Optional<FamilyMember>
    * findByFamilyId : List<FamilyMember>
    * findByMemberId : List<FamilyMember>
    * findByFamilyIdAndMemberId : Optional<FamilyMember>
    * modifyFamilyMemberInfo : void
     */

    @Transactional
    public Long save(FamilyMember familyMember){
        validateDuplicateFamilyMember(familyMember);
        familyMemberRepository.save(familyMember);
        return familyMember.getId();
    }

    public Optional<FamilyMember> findOne(Long familyMemberId){
        return familyMemberRepository.findById(familyMemberId);
    }

    public List<FamilyMember> findByFamilyId(Long familyId){
        return familyMemberRepository.findByFamilyId(familyId);
    }

    public List<FamilyMember> findByMemberId(Long memberId){
         return familyMemberRepository.findByMemberId(memberId);
    }

    public Optional<FamilyMember> findByFamilyIdAndMemberId(Long familyId, Long memberId){
        return familyMemberRepository.findByFamilyIdAndMemberId(familyId,memberId);
    }

    @Transactional
    public void modifyFamilyMemberInfo(Long familyMemberId, String name){
        Optional<FamilyMember> familyMember = familyMemberRepository.findById(familyMemberId);
        familyMember.get().modifyName(name);
    }

    // TODO: 에러 메시지 수정
    private void validateDuplicateFamilyMember(FamilyMember familyMember){
        Long memberId = familyMember.getMember().getId();
        Long familyId = familyMember.getFamily().getId();
        Optional<FamilyMember> find =
                familyMemberRepository.findByFamilyIdAndMemberId(familyId,memberId);
        if(!find.isEmpty()){
            throw new IllegalStateException("이미 해당 그룹에 가입되어 있습니다.");
        }
    }
}

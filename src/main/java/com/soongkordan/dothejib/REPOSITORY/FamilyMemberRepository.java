package com.soongkordan.dothejib.REPOSITORY;

import com.soongkordan.dothejib.DOMAIN.FamilyMember;
import com.soongkordan.dothejib.DOMAIN.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember,Long> {
}

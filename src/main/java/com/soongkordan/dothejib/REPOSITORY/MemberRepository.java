package com.soongkordan.dothejib.REPOSITORY;

import com.soongkordan.dothejib.DOMAIN.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByEmail(String email);

}

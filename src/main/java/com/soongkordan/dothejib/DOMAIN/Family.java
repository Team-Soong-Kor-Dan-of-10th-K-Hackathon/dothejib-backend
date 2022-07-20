package com.soongkordan.dothejib.DOMAIN;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Family {
    @Id @Column(name="family_id")
    @GeneratedValue()
    private Long id;

    private String name;
}

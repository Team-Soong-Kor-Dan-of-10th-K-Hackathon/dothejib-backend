package com.soongkordan.dothejib.DOMAIN;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter
public class Todo {
    @Id @Column(name = "todo_id")
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charged_familymember_id")
    private FamilyMember personInCharge; //책임자

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "published_familymember_id")
    private FamilyMember publisher; //발행자

    private String title;
    private LocalDateTime endAt; //마감기한
    private int difficulty; //중요도
    private String content;
}

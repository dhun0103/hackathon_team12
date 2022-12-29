package com.example.hackathon_team12.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column
    private String email;

    @Column
    private String accountName;

    @Column
    private Boolean isAccepted = false;

    @Column
    private Boolean isDeleted;

    @Builder
    public Member(String email, String accountName, Boolean isAccepted, Boolean isDeleted){
        this.email=email;
        this.accountName=accountName;
        this.isAccepted=isAccepted;
        this.isDeleted=isDeleted;
    }
}

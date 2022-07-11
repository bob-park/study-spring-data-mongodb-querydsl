package com.example.exammongodb.model.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CreateMemberRequest {

    private String userId;
    private String password;
    private String name;


}

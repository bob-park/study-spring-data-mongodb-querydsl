package com.example.exammongodb.model.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class SearchMemberRequest {

    private String name;

    private String userId;

    @Builder
    private SearchMemberRequest(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }
}

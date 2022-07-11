package com.example.exammongodb.service;

import com.example.exammongodb.entity.Member;
import com.example.exammongodb.model.member.CreateMemberRequest;
import com.example.exammongodb.model.member.SearchMemberRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    Member saveMember(CreateMemberRequest createRequest);

    Page<Member> search(SearchMemberRequest searchRequest, Pageable pageable);

}

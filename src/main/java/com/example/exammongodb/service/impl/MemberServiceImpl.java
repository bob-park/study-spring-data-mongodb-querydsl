package com.example.exammongodb.service.impl;

import com.example.exammongodb.entity.Member;
import com.example.exammongodb.entity.QMember;
import com.example.exammongodb.model.member.CreateMemberRequest;
import com.example.exammongodb.model.member.SearchMemberRequest;
import com.example.exammongodb.repository.MemberRepository;
import com.example.exammongodb.service.MemberService;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member saveMember(CreateMemberRequest createRequest) {

        Member member = Member.builder()
            .userId(createRequest.getUserId())
            .password(createRequest.getPassword())
            .name(createRequest.getName())
            .build();

        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    @Override
    public Page<Member> search(SearchMemberRequest searchRequest, Pageable pageable) {

        QMember member = new QMember("member");

        BooleanBuilder builder = new BooleanBuilder();

        if (searchRequest.getUserId() != null) {
            builder.and(member.userId.eq(searchRequest.getUserId()));
        }

        if (searchRequest.getName() != null) {
            builder.and(member.name.eq(searchRequest.getName()));
        }

        return memberRepository.findAll(builder, pageable);
    }
}

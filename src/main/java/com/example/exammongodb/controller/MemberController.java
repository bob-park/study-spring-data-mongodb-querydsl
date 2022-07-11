package com.example.exammongodb.controller;

import com.example.exammongodb.entity.Member;
import com.example.exammongodb.model.member.CreateMemberRequest;
import com.example.exammongodb.model.member.SearchMemberRequest;
import com.example.exammongodb.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping(path = "")
    public Member save(@RequestBody CreateMemberRequest createMemberRequest) {
        return memberService.saveMember(createMemberRequest);
    }

    @GetMapping(path = "search")
    public Page<Member> search(SearchMemberRequest searchRequest,
        @PageableDefault(sort = "name", direction = Direction.ASC) Pageable pageable) {
        return memberService.search(searchRequest, pageable);
    }

}

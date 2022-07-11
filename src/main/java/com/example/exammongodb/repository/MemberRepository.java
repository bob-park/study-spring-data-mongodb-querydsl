package com.example.exammongodb.repository;

import com.example.exammongodb.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends MongoRepository<Member, String>,
    QuerydslPredicateExecutor<Member> {

}

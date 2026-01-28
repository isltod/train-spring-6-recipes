package com.apress.spring6recipes.court.service;

import com.apress.spring6recipes.court.domain.Member;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryMemberService implements MemberService {

    private Map<String, Member> members = new HashMap<>();

    @Override
    public void add(Member member) {
        members.put(member.getName(), member);
    }

    @Override
    public void remove(String name) {
        members.remove(name);
    }

    @Override
    public Optional<Member> find(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> list() {
        return new ArrayList<>(members.values());
    }
}

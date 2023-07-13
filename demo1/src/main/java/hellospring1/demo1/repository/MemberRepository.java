package hellospring1.demo1.repository;

import hellospring1.demo1.domain.Member;

import java.util.List;
import java.util.Optional;

//회원 객체를 저장하는 저장소
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

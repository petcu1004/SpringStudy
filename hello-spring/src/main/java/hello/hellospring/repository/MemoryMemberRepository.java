package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store= new HashMap<>();
    private static long sequence = 0L; //key값을 생성해주는 것
    @Override
    public Member save(Member member) { //회원이 저장소에 저장이 되는 것
        member.setId(++sequence); //시퀀스 값을 올려주고
        store.put(member.getId(), member); //맵에 데이터를 넣어주고
        return member; //리턴함
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //람다식
                .filter(member -> member.getName().equals(name))
                .findAny(); //하나라도 찾는것, 하나라도 찾아서 있으면 반환해주지만, 끝까지 없으면 Optional에 null이 포함돼서 반환됨
    }

    @Override
    public List<Member> findAll() { //지금까지 저장된 회원의 id를 전부 반환해줌
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }


}

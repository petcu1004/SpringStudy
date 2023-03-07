package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository; //테스트할 때 같은 레퍼지를 쓰기 위해 위와 같은 코드가 아닌 이와 같은 코드로 작성하고 Test 코드도 @BeforeEach로 수정해줌
    public MemberService(MemberRepository memberRepository) { //외부에서 넣어주도록 바꾸면 테스트할 때 쓰는 것과 같음
        this.memberRepository = memberRepository;
    }


    //    회원가입
    public Long join(Member member){

        //같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m->{ //Optional로 감싸면 ifPresent를 사용할 수 있음.
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m->{ //Optional로 감싸면 ifPresent를 사용할 수 있음.
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}

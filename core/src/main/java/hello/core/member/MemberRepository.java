package hello.core.member;

public interface MemberRepository {
    void save(Member member); //회원저장

    Member findById(Long memberId); //회원 ID 가져오기
}

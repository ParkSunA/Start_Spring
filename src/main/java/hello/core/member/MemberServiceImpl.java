package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // 이 코드의 문제점은 MemberServiceImpl이 MemberRepository(추상화)에도 의존하고 MemoryMemberRepository(구체화)에도 의존
    // DIP를 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

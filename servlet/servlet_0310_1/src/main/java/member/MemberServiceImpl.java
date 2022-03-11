package member;

public class MemberServiceImpl implements MemberService{

	MemberRepository members = new MemoryMemberRepository();
	
	@Override
	public void join(Member member) {
		members.save(member);
	}

	@Override
	public Member findMember(Long id) {
		return members.findById(id);
	}

}

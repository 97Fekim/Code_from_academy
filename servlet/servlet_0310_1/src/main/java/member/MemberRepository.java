package member;

public interface MemberRepository {
	public void save(Member member);
	public Member findById(Long id);
}
package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    //    save
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        log.info("save : member = {}", member);
        return member;
    }

    //    findById
    public Member findById(Long id) {
        return store.get(id);
    }

    //    findByLoginId
    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }


    //    findAll
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //    clearStore
    public void clearStore() {
        store.clear();
    }
}

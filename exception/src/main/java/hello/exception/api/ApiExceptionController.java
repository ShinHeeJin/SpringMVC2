package hello.exception.api;

import hello.exception.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionController {

    @GetMapping("/api/members/{id}")
    public MemberDTO getMember(@PathVariable("id") String id) {

        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 아이디 입니다.");
        }

        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 값 입니다.");
        }

        if (id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }
        return new MemberDTO(id, "hello" + id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDTO{
        private String memberId;
        private String name;
    }
}

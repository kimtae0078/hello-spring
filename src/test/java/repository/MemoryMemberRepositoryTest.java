package repository;

import dante.hellospring.domain.Member;
import dante.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // optional에서 값을 꺼낼 때 .get()으로 가능. 좋은 방법은 아님.
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(result, member);

        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);

    }
}

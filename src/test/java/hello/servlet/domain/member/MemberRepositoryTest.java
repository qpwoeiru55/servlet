package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);

        Member save = memberRepository.save(member);

        Member fiMember1 = memberRepository.findById(save.getId());

        assertThat(fiMember1).isEqualTo(save);


    }

    @Test
    void findAll(){

        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);


        memberRepository.save(member1);
        memberRepository.save(member2);


        List<Member> all = memberRepository.findAll();

        assertThat(all).contains(member1,member2);



    }
}

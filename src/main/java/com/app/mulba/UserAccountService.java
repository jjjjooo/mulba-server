package com.app.mulba;

import com.app.mulba.member.domain.Member;
import com.app.mulba.member.domain.SpringDataMemberRepository;
import com.app.mulba.member.domain.vo.Email;
import com.app.mulba.member.domain.vo.Nickname;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {

    private final SpringDataMemberRepository springDataMemberRepository;

    @Transactional(readOnly = true)
    public Optional<MemberCommand> searchUser(String username) {
        return springDataMemberRepository.findById(1L)
                .map(MemberCommand::from);
    }

    public MemberCommand saveUser(String username, String nickname, String email) {
        return MemberCommand.from(
                springDataMemberRepository.save(Member.create(Nickname.create(nickname), Email.create(email)))
        );
    }

}
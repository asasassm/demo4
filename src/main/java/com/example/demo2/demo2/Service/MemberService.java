package com.example.demo2.demo2.Service;

import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Entity.MemberEntity;
import com.example.demo2.demo2.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
private final MemberRepository memberRepository;
    public void save(MemberDto memberDto) {
        //reposotpry 의 save메서드 호출 (조건 : entity객체 넘겨줘야함
        // dto -> entity 변환
        // repository의 save 호출

        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);

    }

    public MemberDto login(MemberDto memberDto) {
        //회원이 입력한 id로 db에서 조회
        // DB에 있는 비번이랑 입력한거랑 같은지 판단
        //Dto에서 Entity값 받아옴
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDto.getMemberId());
        if(byMemberId.isPresent()){
            MemberEntity memberEntity = byMemberId.get();
            if(memberEntity.getMemberPw().equals(memberDto.getMemberPw())){
                //entity -> dto 변환 후 리턴
                MemberDto dto = MemberDto.toMemberDTO(memberEntity);
                return dto;
            }else{
                return null;
            }
            //조회결과가 있다.
        }else{
            //결과 없음
            return null;
        }

    }

    public List<MemberDto> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDto> memberDtoList = new ArrayList<>();
        for(MemberEntity memberEntity: memberEntityList){
            memberDtoList.add(MemberDto.toMemberDTO(memberEntity));

        }
        return memberDtoList;
    }

    public MemberDto findByNum(Long num) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByNum(num);
        if(optionalMemberEntity.isPresent()){
            return MemberDto.toMemberDTO(optionalMemberEntity.get());
        }else return null;
    }


    public MemberDto updateForm(String myId) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberId(myId);
        if(optionalMemberEntity.isPresent()){
            return MemberDto.toMemberDTO(optionalMemberEntity.get());
        }else {
            return null;
        }
    }

    public void update(MemberDto memberDto) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDto));
    }

    public void deleteByNum(Long num) {
        memberRepository.deleteById(num);
    }

    public String idCheck(String memberId) {
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberId);
        if(byMemberId.isPresent()){
            return null;
        }else {
            return "ok";
        }

    }
}

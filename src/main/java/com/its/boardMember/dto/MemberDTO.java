package com.its.boardMember.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // - @Getter, @Setter, @ToString.. 같은 기존에 getter, setter를 자바 코드에 쓰지 않아도 알아서 스프링이 인식하도록 해주는 어노테이션
@NoArgsConstructor  // 기본 생성자를 자바 코드에 쓰지 않아도 알아서 스프링이 인식하도록 해주는 어노테이션
@AllArgsConstructor // 필드 생성자를 자바 코드에 쓰지 않아도 알아서 스프링이 인식하도록 해주는 어노테이션
public class MemberDTO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberBirth;
    private String memberGender;
    private String memberEmail;
    private String memberPhone;
}

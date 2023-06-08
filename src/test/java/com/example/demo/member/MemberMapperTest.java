package com.example.demo.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.domain.MemberDto;
import com.example.demo.member.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class MemberMapperTest {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void 사용자추가() {
		MemberDto dto = new MemberDto("user1","1234","둘리","ROLE_USER",null,null);
		int result = mapper.insert(dto);
		log.info("CREATE USER:"+result);
	}
	
	@Test
	public void 사용자목록조회() {
		for (MemberDto dto:mapper.selectList()) {
			log.info(dto.toString());
		}
	}
	@Test
	public void 사용자상세조회() {
		MemberDto readDto = mapper.select("user");
		log.info(readDto);
	}
	@Test
	public void 사용자정보수정() {
		MemberDto updateDto = mapper.select("user1");
		updateDto.setName("또치");
		int result = mapper.update(updateDto);
		log.info("UPDATE USER: "+result);
	}
	@Test
	public void 사용자정보삭제() {
		int result = mapper.delete("user2");
		log.info("DELETE USER: "+result);
	}
}

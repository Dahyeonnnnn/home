package com.example.demo.emp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.emp.domain.EmpDto;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
//@SpringBootTest
public class EmpMapperTests {

	@Autowired
	private EmpMapper mapper;
	
	@Test
	public void 사원추가() {
		EmpDto dto = new EmpDto(1004,"둘리",3);
		int result = mapper.insert(dto);
		log.info("CREATE USER:"+result);
	}
	
	@Test
	public void 사원목록조회() {
		for (EmpDto dto:mapper.selectList()) {
			log.info(dto.toString());
		}
	}
	@Test
	public void 사원상세조회() {
		EmpDto readDto = mapper.select(1004);
		log.info(readDto);
	}
	@Test
	public void 사원정보수정() {
		EmpDto updateDto = mapper.select(1004);
		updateDto.setEmpName("또치");
		int result = mapper.update(updateDto);
		log.info("UPDATE EMP_NO: "+result);
	}
	@Test
	public void 사원정보삭제() {
		int result = mapper.delete(1005);
		log.info("DELETE EMP_NO: "+result);
	}
	
}

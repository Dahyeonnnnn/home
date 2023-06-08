package com.example.demo.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardServieTests {

	@Autowired BoardService service;
	
	@Test
	public void 게시물추가() {
		BoardDto dto = new BoardDto(0,"새로 작성하는 글","새로 작성하는 내용","user1",null,null);
		BoardDto newDto = service.register(dto);
		log.info("REGISTER BOARD"+newDto.toString());
	}
	
	
}

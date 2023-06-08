package com.example.demo.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override 
	public BoardDto register(BoardDto dto) { /* 리턴타입 및 로직 수정 */
		
		log.info("register......" + dto);
		mapper.insert(dto);
		int newNo = dto.getNo();
		BoardDto newDto = get(newNo);
		return newDto;
	}

	@Override
	public List<BoardDto> getList() {
		log.info("get List......");
		return mapper.selectList();
	}

	@Override
	public BoardDto get(int no) {
		log.info("get......" + no);
		return mapper.select(no);
	}

	@Override
	public boolean modify(BoardDto dto) { /* 로직 변경 */
		BoardDto readDto = mapper.select(dto.getNo());
		if (readDto == null) {
			log.info("해당 게시물은 존재하지않습니다.");
			return false;
		} else {
			log.info("modify......" + dto);
			return mapper.update(dto) == 1;
		}
	}

	@Override
	public boolean remove(int no) {
		BoardDto readDto = mapper.select(no);
		if (readDto == null) {
			log.info("해당 게시물은 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + no);
			return mapper.delete(no) == 1;
		}
	}

}

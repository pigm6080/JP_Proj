package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	// 등록 : /replies/new : post
	// 조회 : /replies/:rno : GET
	// 삭제 : /replies/:rno : DELETE
	// 수정 : /replies/:rno : PUT or PATCH
	//페이지 : /replies/:pages/:bno/:page : get
	
	@Autowired
	private ReplyService service;
	
	//rest 방식으로 처리할때 주의해야 할 점은 브라우저나 외부에서 서버를 호출할때 데이터의 포맷과서버에서 보내주는 데이터의 타입을 명확히설계해야하는 것이다.
	
	//create mapping
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE}) // JSON 방식의 데이터만 처리하도록한다.
	// 요청 : aplliction/json 응답은 text/plain 형식으로 제공됩니다.
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		//RequestBody : json 형태의데이터를  vo 로 저장한다.
		
		log.info("ReplyVO" + vo);
		
		int insertCount = service.regsiter(vo);
		
		return insertCount == 1 ? 
				new ResponseEntity<String>("sucess",HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 목록을 확인 하는 작업
	@GetMapping(value = "/pages/{bno}/{page}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
		
		log.info("getList--------------");
		
		Criteria cri = new Criteria(page,10);
		
		log.info(cri);
		
		
		return new ResponseEntity<List<ReplyVO>>(service.getList(cri, bno), HttpStatus.OK);
		
	}	
	
	//하나가져오기.
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, 	MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		
		log.info("get : " + rno);
		
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
		
	}
	//하나 삭제하기
	@DeleteMapping(value = "/{rno}",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove : " + rno);
		
		return service.remove(rno) == 1 ?
				new ResponseEntity<>("success",HttpStatus.OK) :
					new ResponseEntity<>("It is ererroer",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	//수정하기
	@RequestMapping(method = {RequestMethod.PUT , RequestMethod.PATCH}, value = "/{rno}"
			, consumes = "application/json" 
			, produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo , @PathVariable("rno") Long rno){
		vo.setRno(rno);
		
		
		log.info("rno :" + rno);
		
		log.info("modify:" + vo);
		
		return service.modify(vo) ==1 ? new ResponseEntity<>("success" , HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}

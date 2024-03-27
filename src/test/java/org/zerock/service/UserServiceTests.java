package org.zerock.service;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceTests {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	@Test
	public void testService() {
		log.info(service);
		assertNotNull(service);
		UserVO vo = new UserVO();
		vo.setId("sssss");
		vo.setPassword("asdasd");
		vo.setUsername("newbie");
		vo.setPhone("sds");
		
		
		
		service.register(vo);
	}
	

	@Test
	public void testGet() {
		log.info(service.get("sssss"));
	}
	
	@Test
	public void testDelete() {
		//게시물번호를 먼저 확인하고 테스트
		log.info("remove : " + service.remove("sssss"));
	}
	@Test
	public void testUpdate() {
		//게시물번호를 먼저 확인하고 테스트
		UserVO vo = service.get("sssss");
		
		if(vo == null) {
			return;
		}
		vo.setPhone("전화번호를을 수정한다");
		log.info("Modify 수정완료 : " + service.modify(vo));
	}
}

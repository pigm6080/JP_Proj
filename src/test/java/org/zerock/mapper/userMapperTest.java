package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UserVO;
import org.zerock.security.UserTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class userMapperTest {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder pwecoderEncoder;
	
	@Test
	public void testRead() {
		
		UserVO vo = mapper.read("admin90");
		
		log.info(vo);
		
		vo.getAuthList().forEach(authVO -> log.info(authVO));
	}
	
	@Test
	public void testInsert() {
		
		UserVO vo = new UserVO();
		vo.setId("sky1");
		vo.setPassword(pwecoderEncoder.encode("pw"));
		vo.setUsername("하늘");
		vo.setPhone("010-0000-0000");
		mapper.insert(vo);
		
		log.info(vo);
	
	}
	
	@Test
	public void testDelete() {
		
		log.info("DELETE COUNT:" + mapper.delete("sky1"));
	}
	
	@Test
	public void testUpdate() {
		
		UserVO vo = new UserVO();
		
		vo.setId("sky1");
		vo.setPassword(pwecoderEncoder.encode("pw"));
		vo.setUsername("하늘1");
		vo.setPhone("010-0000-0000");
		
		mapper.update(vo);
		
	}
	@Test
	public void testGetList() {
		log.info(mapper.getClass().getName());
		log.info(mapper.getList());
	}
}

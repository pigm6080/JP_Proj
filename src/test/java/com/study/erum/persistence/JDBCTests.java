package com.study.erum.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		//try쓰는이유?
		/*
		오류의 종류 
		1. Syntes 오류 : 오타, 문법오류 - 컴파일러
		2. 논리적 오류 : 다른결과가 출력될때 - 디버깅툴
		3. 실행오류(Runtime) : 예외처리 익셉션 
			1) try(실행코드) - catch(오류날때) - finally (close메소드)
		
		H2가 짱이다.. 왜? 평상시에는 안돌아가서 서버에부하를 안주기떄문이다.
		 */
		try{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
		@Test
		public void testConnection() {
			try(Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/kimjewog?serverTimezone=Asia/Seoul",
							"root",
							"1234")){
					log.info(con);
			} catch (Exception e) {
				fail(e.getMessage());
			}
		}
	}

package org.zerock.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KakaoTokenVO {
	/*
	{
	 "access_token": 액세스 토큰 결과 "String",
	  "token_type": "bearer" "String",,
	  "refresh_token": 리프레시 토큰 결과 "String",
	  "expires_in": "int" 유효기간,
	  "scope": "profile_image profile_nickname"  "String",
	  "refresh_token_expires_in": 5183999 "int" 유효기간
	}*/
	
	private String access_token;  //varchar(255)
	private String token_type;    //varchar(20)
	private String refresh_token;   //varchar(255)
	private int expires_in;    //DECIMAL(10,0)   (sec)
	private String scope;		//varchar(255)
	private int refresh_token_expires_in;    //DECIMAL(10,0)   (sec)
	
}

/*
 * TODO ADD QUERY ON DB ( MYSQL )
 * 
 Expected SQL Query . . .
 
 create table KaKaToken (
   access_token varchar(255) not null,
   token_type varchar(30) not null,
   refresh_token varchar(255) not null,
   expires_in INT not null,
   scope varchar(255) not null,
   refresh_token_expires_in INT not null,
   PRIMARY KEY (access_token)
 );
 
 */
 
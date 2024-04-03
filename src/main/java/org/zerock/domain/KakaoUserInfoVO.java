package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class KakaoUserInfoVO {
	private Long id;
	private Date connected_at;
	private String nickname;
	private String profile_image;
	private String thumbnail_image;
	private int profile_nickname_needs_agreement;  //boolean type parsing need
	private int profile_image_needs_agreement;  //boolean type parsing need
	private int is_default_image;  //boolean type parsing need
	private int is_default_nickname;  //boolean type parsing need
}


/*
 * TODO ADD QUERY ON DB ( MYSQL )
 * 
 Expected SQL Query . . .
 
 create table KaKaToken (
   id INT not null ,
   connected_at timestamp not null,
   nickname varchar(50) not null,
   profile_image longtext not null, --image path on kakao CDN
   thumbnail_image longtext not null, --thumbnail image path on kakao CDN
   profile_nickname_needs_agreement INT not null,
   profile_image_needs_agreement INT not null,
   is_default_image INT not null,
   is_default_nickname INT not null,
   PRIMARY KEY (id)
 )
 
 */
package org.zerock.domain;

import java.util.Map;

import lombok.Data;

@Data
public class KakaoUserInfoVO {
    private long id;
    private String connectedAt;
    private KakaoAccount kakaoAccount;
    private Map<String, String> properties;
    private ForPartner forPartner;
}

/*
 * TODO ADD QUERY ON DB ( MYSQL )
 * 
 Expected SQL Query . . .
 
 create table KaKaUserInfo (
   id INT not null ,
   connected_at timestamp not null,
   nickname varchar(50) not null,
   profile_image longtext not null, -- image path on kakao CDN
   thumbnail_image longtext not null, -- thumbnail image path on kakao CDN
   profile_nickname_needs_agreement INT not null,
   profile_image_needs_agreement INT not null,
   is_default_image INT not null,
   is_default_nickname INT not null,
   PRIMARY KEY (id)
 );
 
 */
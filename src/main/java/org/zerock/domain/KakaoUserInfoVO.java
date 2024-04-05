package org.zerock.domain;

import lombok.Data;

import java.util.Map;

@Data
public class KakaoUserInfoVO {
    private long id;
    private String connectedAt;
    private KakaoAccount kakaoAccount;
    private Map<String, String> properties;
    private ForPartner forPartner;
}

@Data
class KakaoAccount {
    private boolean profileNicknameNeedsAgreement;
    private boolean profileImageNeedsAgreement;
    private Profile profile;
    private boolean nameNeedsAgreement;
    private String name;
    private boolean emailNeedsAgreement;
    private boolean isEmailValid;
    private boolean isEmailVerified;
    private String email;
    private boolean ageRangeNeedsAgreement;
    private String ageRange;
    private boolean birthyearNeedsAgreement;
    private String birthyear;
    private boolean birthdayNeedsAgreement;
    private String birthday;
    private String birthdayType;
    private boolean genderNeedsAgreement;
    private String gender;
    private boolean phoneNumberNeedsAgreement;
    private String phoneNumber;
    private boolean ciNeedsAgreement;
    private String ci;
    private String ciAuthenticatedAt;
}

@Data
class Profile {
    private String nickname;
    private String thumbnailImageUrl;
    private String profileImageUrl;
    private boolean isDefaultImage;
    private boolean isDefaultNickname;
}

@Data
class ForPartner {
    private String uuid;
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
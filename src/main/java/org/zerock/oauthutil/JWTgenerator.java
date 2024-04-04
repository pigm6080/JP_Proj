package org.zerock.oauthutil;

import javax.crypto.SecretKey;

public class JWTgenerator {
	private SecretKey skey = Jwts.SIG.HS256.key().build();

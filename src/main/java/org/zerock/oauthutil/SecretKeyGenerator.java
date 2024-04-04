package org.zerock.oauthutil;

import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecretKeyGenerator { // TODO secretkey 생성 -> JWT 토큰생성 작업필요
	public static SecretKey generateKey(String algorithm, int keySize) {
		byte[] keyBytes = new byte[keySize / 8]; // 시크릿 키 길이 (비트 단위, 예: 128, 192, 256)
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        
        return new SecretKeySpec(keyBytes, algorithm); // 암호화 알고리즘 선택 (예: AES, DES, ...)
	}
	
	public static void main(String[] args) {
		byte[] result1 = generateKey("AES",128).getEncoded();
		String result2 = generateKey("AES",128).toString();
		int result3 = generateKey("AES", 128).hashCode();
		
		System.out.println(result1); 
		System.out.println(result2); 
		System.out.println(result3); 
	}
}

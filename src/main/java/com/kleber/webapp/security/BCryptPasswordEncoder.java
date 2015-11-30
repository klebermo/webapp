package com.kleber.webapp.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

	public String encode(CharSequence rawPassword) {
		try {
			return getMD5Hex((String) rawPassword);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(encode(rawPassword));
	}

	public static String getMD5Hex(final String inputString) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(inputString.getBytes());
	    byte[] digest = md.digest();
	    return convertByteToHex(digest);
	}

	private static String convertByteToHex(byte[] byteData) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < byteData.length; i++)
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	    return sb.toString();
	}

}

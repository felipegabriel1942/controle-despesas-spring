package com.felipegabriel.controledespesas.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Md5 implements PasswordEncoder {
	
	private static MessageDigest md = null;
	
	@Override
	public String encode(CharSequence charSequence) {
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		try {
			return md5Encripter(rawPassword).equals(encodedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
    public static String md5Encripter(CharSequence rawPassword) throws NoSuchAlgorithmException {
    	md = MessageDigest.getInstance("MD5");
    	
    	if (rawPassword == null) {
    		return "";
    	}
    	
        if (md == null) {
            return "";
        }
        
        return new String(hexCodes(md.digest(rawPassword.toString().getBytes())));
    }
    
    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
           hexString = "00" + Integer.toHexString(text[i]);
           hexString.toUpperCase().getChars(hexString.length() - 2,
                   hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }
}

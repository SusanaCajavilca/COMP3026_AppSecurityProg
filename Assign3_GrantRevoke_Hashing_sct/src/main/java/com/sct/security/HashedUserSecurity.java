package com.sct.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashedUserSecurity {
	
	// SHA-512 hashing
    public static String hashPassword(String input) {

        try {
        	
        	// getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into number representation
            
            BigInteger no = new BigInteger(1, messageDigest);
            
            // Convert message digest into hex value
            String hashText = no.toString(16);

            // Ensure the hash is padded to 128 characters
            while (hashText.length() < 128) {
                hashText = "0" + hashText;
            }
            
            // return the HashText
            return hashText;

        } 
            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                 throw new RuntimeException(e);
        }
    }

}

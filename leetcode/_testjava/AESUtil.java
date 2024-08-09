package _testjava;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final ThreadLocal<Cipher> cipherThreadLocal = ThreadLocal.withInitial(() -> {
        try {
            return Cipher.getInstance(ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Cipher", e);
        }
    });

    private static SecretKey generateKeyFromBytes(byte[] keyBytes) {
        if (keyBytes.length != 16 && keyBytes.length != 24 && keyBytes.length != 32) {
            throw new IllegalArgumentException("Invalid key length; it should be either 16, 24, or 32 bytes long");
        }
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    private static SecretKey generateKeyFromString(String keyString) {
        byte[] keyBytes = keyString.getBytes();
        return generateKeyFromBytes(keyBytes);
    }

    private static byte[] encrypt(byte[] data, SecretKey secretKey) {
        try {
            Cipher cipher = cipherThreadLocal.get();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to encrypt data", e);
        }
    }

    private static byte[] decrypt(byte[] encryptedData, SecretKey secretKey) {
        try {
            Cipher cipher = cipherThreadLocal.get();
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to decrypt data", e);
        }
    }

    public static String encrypt(String data, String keyString) {
        SecretKey secretKey = generateKeyFromString(keyString);
        byte[] encryptedData = encrypt(data.getBytes(), secretKey);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedDataStr, String keyString) {
        SecretKey secretKey = generateKeyFromString(keyString);
        byte[] encryptedData = Base64.getUrlDecoder().decode(encryptedDataStr);
        byte[] decryptedData = decrypt(encryptedData, secretKey);
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        String keyString = "xxxxxxxxxxxxxxxx";
        String originalText = "1320916995";
        String encryptedText = encrypt(originalText, keyString);
        String decryptedText = decrypt(encryptedText, keyString);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}

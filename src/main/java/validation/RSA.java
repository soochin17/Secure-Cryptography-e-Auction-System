package validation;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

// Exception:
//NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException


public class RSA {
    private static byte[] puk_bytes;
    private static byte[] prk_bytes;
    private static PublicKey publicKey;
    private static PublicKey publicKey2;
    private static PrivateKey privateKey, privateKey2;

    public RSA() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
     
        keyPairGenerator.initialize(1024,secureRandom);
     
        KeyPair pair = keyPairGenerator.generateKeyPair();
    
        publicKey = pair.getPublic();
        privateKey = pair.getPrivate();
        
    }
    
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    
    public static PublicKey convertBytesToPK(byte[] pk) throws Exception {

        try{
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(pk);
            publicKey2 = keyFactory.generatePublic(publicKeySpec);

        }
        catch(Exception e){
            System.out.println("Error");
        }
        return publicKey2;
    }

    // after retrieve sk from mysql, then convert it back to PrivateKey datatype
    public PrivateKey convertBytesToSK(byte[] sk) throws Exception {
        try{
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(sk);
            privateKey2 = keyFactory.generatePrivate(privateKeySpec);
        }
        catch(Exception e){
            System.out.println("Error");
        }

        return privateKey2;
    }
    
    public static byte[] encrypt(String message, PublicKey pk) throws Exception {
        //Encrypt the bid
        Cipher encryptionCipher = Cipher.getInstance("RSA");
        encryptionCipher.init(Cipher.ENCRYPT_MODE,pk);
        byte[] encryptedMessage = encryptionCipher.doFinal(message.getBytes());
        return encryptedMessage;
    }

    public byte[] decrypt(byte[] encrypted_message, PrivateKey sk) throws Exception{
        //Decrypt the bid
        Cipher decryptionCipher = Cipher.getInstance("RSA");
        decryptionCipher.init(Cipher.DECRYPT_MODE,sk);
        byte[] decryptedMessage = decryptionCipher.doFinal(encrypted_message);
        return decryptedMessage;
    }
}
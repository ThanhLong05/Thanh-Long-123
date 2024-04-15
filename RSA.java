package Mahoadulieu;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import javax.crypto.Cipher;
public class RSA {

    public static void main(String[] args) throws Exception {
      
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); 
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        
        PublicKey publickey = keyPair.getPublic();
        PrivateKey privatekey = keyPair.getPrivate();
        
       
        String Message = "Hello word!";
        
        byte[] mahoa = MahoaRSA(Message, publickey);
        System.out.println("Mã hóa: " + new String(mahoa));
        
        String giaima = GiaimaRSA(mahoa, privatekey);
        System.out.println("Giải mã: " + giaima);
    }

    public static byte[] MahoaRSA(String message, PublicKey publickey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publickey);
        return cipher.doFinal(message.getBytes());
    }

    public static String GiaimaRSA(byte[] mahoa, PrivateKey privatekey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privatekey);
        byte[] decryptedBytes = cipher.doFinal(mahoa);
        return new String(decryptedBytes, "UTF-8");
    }
}

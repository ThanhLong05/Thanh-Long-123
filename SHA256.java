package Mahoadulieu;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256 {

    public static void main(String[] args) {
        String Message = "Hello word!";
        
        try {
            String hashedMessage = MahoaSHA256(Message);
            System.out.println("Mã hóa: " + hashedMessage);
            System.out.println("Giải mã: " + Message);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static String MahoaSHA256(String message) throws Exception {
        MessageDigest cipher = MessageDigest.getInstance("SHA-256");
        byte[] hash = cipher.digest(message.getBytes(StandardCharsets.UTF_8));
               
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        
        return hexString.toString();
    }
}

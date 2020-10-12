import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hash{

  public static void main(String[] args) {
    System.out.println(hashPassword("Alberta.123".toCharArray(), "salt".getBytes(), 1000, 384));
  }

  private static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength){
    try{
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
      SecretKey key = skf.generateSecret(spec);
      byte[] res = new byte[32];
      System.arraycopy(key.getEncoded(), 0, res, 0, 32);
      return res;
    }
    catch(NoSuchAlgorithmException | InvalidKeySpecException e){
      throw new RuntimeException(e);
    }
  }
}
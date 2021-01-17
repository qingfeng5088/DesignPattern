package utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

public class DesUtil {
    private static final String SECRET_KEY_TYPE = "DES";
    private static final String ECB_MOB = "DES/ECB/PKCS5Padding";
    private static final String CHAESET_NAME = "UTF-8";

    private static Key getKey(String password) throws Exception {
        byte[] DESkey = password.getBytes(CHAESET_NAME);
        DESKeySpec keySpec = new DESKeySpec(DESkey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_TYPE);
        return keyFactory.generateSecret(keySpec);
    }

    public static String encode(String data, String password) throws Exception {
        Cipher enCipher = Cipher.getInstance(ECB_MOB);
        Key key = getKey(password);
        enCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] pasByte = enCipher.doFinal(data.getBytes(CHAESET_NAME));
        return Base64.encodeBase64String(pasByte).replaceAll("=", "-");
    }

    public static String decode(String data, String password) throws Exception {
        Cipher deCipher = Cipher.getInstance(ECB_MOB);
        Key key = getKey(password);
        deCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] pasByte = deCipher.doFinal(Base64.decodeBase64(data.getBytes(CHAESET_NAME)));
        return new String(pasByte, CHAESET_NAME);
    }

    public static void main(String[] args) throws Exception {
        String str = "userId=0001,password=qiu123456,Time=" + System.currentTimeMillis();
        String encode = DesUtil.encode(str, "123234222232");
        System.out.println(DesUtil.encode(str, "123234222232"));
        System.out.println(DesUtil.decode(encode, "123234222232"));
    }
}

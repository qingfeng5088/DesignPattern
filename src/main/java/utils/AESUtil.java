package utils;

import cn.hutool.core.codec.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;


public class AESUtil {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";

    /**
     * AES加密
     * @param data
     *            加密内容
     * @param password
     *            加密密码
     * @return
     * @throws Exception
     */
    public static String encryptData(String data, String password) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        // 初始化为加密模式的密码
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
        // 加密
        byte[] result = cipher.doFinal(data.getBytes());

        return Base64.encode(result);
    }

    /**
     * AES解密
     * @param base64Data
     *            解密内容
     * @param password
     *            解密密码
     * @return
     * @throws Exception
     */
    public static String decryptData(String base64Data, String password) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        // 使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
        // 执行操作
        byte[] result = cipher.doFinal(Base64.decode(base64Data));
        return new String(result, "utf-8");
    }

    /**
     * 生成加密秘钥
     * @return
     */
    private static SecretKeySpec getSecretKey(String password) {
       // SecretKeySpec key = new SecretKeySpec(JDKMessageDigest.MD5.sign(password, "UTF-8").toLowerCase().getBytes(), ALGORITHM);
        return null;
    }
}

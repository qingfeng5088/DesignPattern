package utils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaUtils {

    private static final Logger logger = LoggerFactory.getLogger(RsaUtils.class);

    /**
     * RSA2签名
     * @param content 待签名的字符串
     * @param privateKey rsa私钥字符串
     * @param charset 字符集编码
     * @return 签名结果
     */
    public static String rsaSign(String content, String privateKey, String charset) {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(priKey);
            if (StringUtils.isBlank(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            logger.error("RSA签名异常:{}", e.getMessage(), e);
            return null;
        }
    }

    /**
     * RSA2验签
     *
     * @param content 被签名的内容
     * @param sign 签名后的结果
     * @param publicKey rsa公钥
     * @param charset 字符集编码
     * @return 验签结果
     */
    public static boolean doCheck(String content, String sign, String publicKey, String charset) {
        try {
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(pubKey);
            signature.update(getContentBytes(content, charset));
            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            logger.error("RSA验签异常:{}", e.getMessage(), e);
            return false;
        }
    }

    /**
     *
     * 获取私钥对象
     * @param algorithm 签名方式
     * @param ins 私钥流
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey = readText(ins, "utf-8", true).getBytes();
        encodedKey = Base64.decodeBase64(encodedKey);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /**
     *
     * 获取公钥对象
     * @param algorithm 签名方式
     * @param ins 公钥流
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            StringWriter writer = new StringWriter();
            io(new InputStreamReader(ins), writer, true, true);
            byte[] encodedKey = writer.toString().getBytes();
            // 先base64解码
            encodedKey = Base64.decodeBase64(encodedKey);
            return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
        } catch (InvalidKeySpecException e) {
            logger.error("公钥签名InvalidKeySpecException异常:{}", e.getMessage(), e);
            return null;
        } catch (NoSuchAlgorithmException e) {
            logger.error("公钥签名NoSuchAlgorithmException异常:{}", e.getMessage(), e);
            return null;
        }
    }

    /**
     *
     * 获取字符串对应编码的字节
     * @param content 字符串内容
     * @param charset 字符集编码
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(charset)) {
            return content.getBytes();
        }
        return content.getBytes(charset);
    }

    /**
     *
     * 将指定输入流的所有文本全部读出到一个字符串中
     * @param in 输入流
     * @param charset 字符集编码
     * @param closeIn 是否关闭流
     * @return
     * @throws IOException
     */
    private static String readText(InputStream in, String charset, boolean closeIn) throws IOException {
        Reader reader = charset == null ? new InputStreamReader(in) : new InputStreamReader(in, charset);
        return readText(reader, closeIn);
    }

    /**
     *
     * 将指定<code>Reader</code>的所有文本全部读出到一个字符串中
     * @param in 输入流
     * @param closeIn 是否关闭流
     * @return
     * @throws IOException
     */
    private static String readText(Reader in, boolean closeIn) throws IOException {
        StringWriter out = new StringWriter();
        io(in, out, closeIn, true);
        return out.toString();
    }

    /**
     *
     * 从输入流读取内容，写入到输出流中
     * @param in 输入流
     * @param out 输出流
     * @param closeIn 是否关闭流
     * @param closeOut 是否关闭流
     * @throws IOException
     */
    private static void io(Reader in, Writer out, boolean closeIn, boolean closeOut) {
        int bufferSize = 8192 >> 1;
        char[] buffer = new char[bufferSize];
        int amount;
        try {
            while ((amount = in.read(buffer)) >= 0) {
                out.write(buffer, 0, amount);
            }
            out.flush();
        } catch (Exception e) {
            logger.error("从输入流读取内容，写入到输出流中异常:{}", e.getMessage(), e);
        } finally {
            if (closeIn) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("从输入流读取内容，写入到输出流中异常:{}", e.getMessage(), e);
                }
            }
            if (closeOut) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("从输入流读取内容，写入到输出流中异常:{}", e.getMessage(), e);
                }
            }
        }
    }
}


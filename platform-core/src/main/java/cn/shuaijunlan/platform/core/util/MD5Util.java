package cn.shuaijunlan.platform.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:21 PM 3/10/19.
 */
public class MD5Util {
    public static String encrypt(String source) {
        return encodeMd5(source.getBytes());
    }

    private static String encodeMd5(byte[] source) {
        try {
            return encodeHex(MessageDigest.getInstance("MD5").digest(source));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private static String encodeHex(byte[] bytes) {
        StringBuffer buffer = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buffer.append("0");
            }
            buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buffer.toString();
    }
}

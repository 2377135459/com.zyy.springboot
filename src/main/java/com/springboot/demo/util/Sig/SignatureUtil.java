package com.springboot.demo.util.Sig;

import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @ClassName SignatureUtil
 * @Author Sawyer Yong
 * @Date 2020-03-20 14:36
 * @Description 加解密公工具类
 */
public class SignatureUtil {
    private static final String ENCODEING = "UTF-8";

    /**
     * 加密方法
     * text需要加密的字符串
     * subKey密匙
     */
    public static String md5DigestEncryption(String text, String subKey) {
        String md5 = DigestUtils.md5Hex(crackedKey(subKey));
        try {
            DESedeKeySpec dks = new DESedeKeySpec(md5.getBytes(ENCODEING));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey securekey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(1, securekey);
            byte[] b = cipher.doFinal(text.getBytes());
            String message = parseByte2HexStr(b);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加密异常");
        }
    }

    /**
     * 解密方法,将加密的字符串变为解密的字符串
     *
     * @param text
     * @param subKey text需要解密的字符串
     *               subKey密匙
     * @return
     */
    public static String md5DigestDecryption(String text, String subKey) {
        String md5 = DigestUtils.md5Hex(crackedKey(subKey));
        try {
            byte[] bytesrc = parseHexStr2Byte(text);
            DESedeKeySpec dks = new DESedeKeySpec(md5.getBytes(ENCODEING));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey securekey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, securekey);
            byte[] retByte = cipher.doFinal(bytesrc);
            String message = new String(retByte);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解密异常");
        }
    }

    /**
     * 生成签名的方法
     *
     * @param object    添加了需要签名字段注解的对象
     * @param secretKey
     * @return
     */
    public static String generateSignature(Object object, String secretKey) {
        return generateSignature(getSignatureMap(object), secretKey);
    }

    /**
     * 需要生成签名方法
     *
     * @param map
     * @param secretKey
     * @return
     */
    public static String


    generateSignature(Map<String, String> map, String secretKey) {
        // 获取验签映射集
        List<String> encodeList = mapToListBySort(map);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < encodeList.size(); i++) {
            sb.append(encodeList.get(i)).append("&");
        }
        sb.append(secretKey);
        String signature = DigestUtils.sha256Hex(sb.toString().trim());
        return signature;
    }

    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = ((byte) (high * 16 + low));
        }
        return result;
    }

    private static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static Map<String, String> getSignatureMap(Object object) {
        Map<String, String> map = new HashMap<String, String>();
        Class<?> clazz = object.getClass();
        while (clazz != Object.class) {
            Field[] files = clazz.getDeclaredFields();
            try {
                for (Field field : files) {
                    field.setAccessible(true);
                    if (field.getAnnotation(Signature.class) != null) {
                        map.put(field.getName(), String.valueOf(field.get(object)));
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            clazz = clazz.getSuperclass();
        }
        return map;
    }

    private static List<String> mapToListBySort(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        String[] tmpReqVo = new String[map.size()];
        int index = 0;
        while (it.hasNext()) {
            Map.Entry<?, ?> entry = it.next();
            tmpReqVo[index] = joinString((String) entry.getKey(), (String) entry.getValue(), "=");
            index++;
        }

        List<String> list = Arrays.asList(tmpReqVo);
        Collections.sort(list);

        return list;
    }

    private static String joinString(String name, String value, String symbol) {
        StringBuffer sf = new StringBuffer();
        sf.append(name).append(symbol);
        if (value != null && value.length() > 0) {
            sf.append(value);
        }
        return sf.toString();
    }

    public static String crackedKey(String key) {
        return "cracked" + key + "znzt";
    }
}

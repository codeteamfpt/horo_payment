package fpt.horo.payment.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;


public class Utils {
    public static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    public static String genUid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String createCheckSum(String accessCode, String billCode, String merchantCode, String orderId, Double transAmount, String hashKey){
        try {
            String message = accessCode + billCode + merchantCode + orderId + transAmount.toString();
            byte[] secretBytes = hashKey.getBytes("UTF-8");
            SecretKeySpec key = new SecretKeySpec(secretBytes, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(key);
            byte[] messageBytes = message.getBytes("UTF-8");
            byte[] hashBytes = mac.doFinal(messageBytes);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}

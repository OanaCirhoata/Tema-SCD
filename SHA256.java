import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import static java.lang.System.err;
public class SHA256
{

    private static String bytesToHex(byte[] hash)//converteste hash-ul in hexazecimal
    {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);//adauga in buffer ce a convertit
        }
        return hexString.toString();
    }

    public static String convert(String stringvalue)//converteste datele hexa in octeti si invers
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");//messageDigest ia date cu dimensiuni arbitrare si trimit o valoare hash cu lingime fixa
            byte[] encodedhash = digest.digest(stringvalue.getBytes(StandardCharsets.UTF_8));
            return SHA256.bytesToHex(encodedhash).toUpperCase();
        }catch (Exception e){
            System.out.println("Got an exception! " + err);
            return "";
        }
    }

}
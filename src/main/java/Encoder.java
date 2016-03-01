
import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.Base64;
import java.io.UnsupportedEncodingException;

public class Encoder {
    public static void main(String args[]) {
        if (args == null) {
            throw new IllegalArgumentException("Arguments required.");
        }


        try {

            final String value = Joiner.on(",").skipNulls().join(args);

            final String base64EncodedString = Base64.getEncoder().encodeToString(value.getBytes("utf-8"));

            // Decode
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64EncodedString);

            // URL encoded
            final String base64UrlEncodedString = Base64.getUrlEncoder().encodeToString(value.getBytes("utf-8"));

            System.out.println(value);
            System.out.println(String.format("Original String: %s", new String(base64decodedBytes, "utf-8")));
            System.out.println(String.format("Base64 Encoded String (Basic) : %s", base64EncodedString));
            System.out.println(String.format("Base64 Encoded String (URL) : %s", base64UrlEncodedString));


        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}

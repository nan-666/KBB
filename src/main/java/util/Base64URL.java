package util;

import org.bouncycastle.util.encoders.Base64;

public class Base64URL {
	public static byte[] base64EncodeUrl(byte[] in_str) {
        byte[] base64 = Base64.encode(in_str);
        for (int i = 0; i < base64.length; ++i)
            switch (base64[i]) {
                case '+':
                    base64[i] = '*';
                    break;
                case '/':
                    base64[i] = '-';
                    break;
                case '=':
                    base64[i] = '_';
                    break;
                default:
                    break;
            }
        return base64;
    }

    public static byte[] base64DecodeUrl(byte[] in_str){
        byte[] base64 = in_str.clone();
        for (int i = 0; i < base64.length; ++i)
            switch (base64[i]) {
                case '*':
                    base64[i] = '+';
                    break;
                case '-':
                    base64[i] = '/';
                    break;
                case '_':
                    base64[i] = '=';
                    break;
                default:
                    break;
            }
        return Base64.decode(base64);
    }
}

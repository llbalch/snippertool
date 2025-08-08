package Utility;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class Crypto {

    private static final String ENCRYPTION_PASS = "XyZSecretPassword";
    private static final String ENCRYPTION_SALT = "sweetSnippets";


    private static final TextEncryptor encryptor =
            Encryptors.text(ENCRYPTION_PASS, ENCRYPTION_SALT);

    public static String encrypt(String plain) {
        return encryptor.encrypt(plain);
    }

    public static String decrypt(String cipher) {
        return encryptor.decrypt(cipher);
    }
}




/**
 * Created by Louis on 15/03/2015.
 */
public class Crypto {

    public String encrypt(String password) {
        String crypte = "";
        for (int i = 0; i < password.length(); i++) {
            int c = password.charAt(i) ^ 48;
            crypte = crypte + (char) c;
        }
        return crypte;
    }

    public String decrypt(String password) {
        String aCrypter = "";
        for (int i = 0; i < password.length(); i++) {
            int c = password.charAt(i) ^ 48;
            aCrypter = aCrypter + (char) c;
        }
        return aCrypter;
    }
}

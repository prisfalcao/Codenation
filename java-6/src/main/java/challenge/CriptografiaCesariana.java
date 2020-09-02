package challenge;

public class CriptografiaCesariana implements Criptografia {

    int key = 3;

    @Override
    public String criptografar(String texto) {

        if(texto == null){
            throw new NullPointerException();
        }
        else if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }

        String iCrypt = "";
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            iCrypt += encrypt(texto.charAt(i), this.key);
        }

        return iCrypt;
    }

    public char encrypt(char ascii, int key) {
        char encryptedMsg;

        if (ascii >= 97 && ascii <= 122) {
            encryptedMsg = (char) ((ascii - 97 + key) % 26 + 97);
        }
        else {
            encryptedMsg = ascii;
        }

        return encryptedMsg;
    }

    @Override
    public String descriptografar(String texto) {

        if(texto == null){
            throw new NullPointerException();
        }
        else if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }

        String iDecrypt = "";
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            iDecrypt += decrypt(texto.charAt(i), this.key);
        }

        return iDecrypt;

    }

    public char decrypt(char encrypted, int key) {
        char ascii;

        if (encrypted >= 97 && encrypted <= 122) {
            if(encrypted - key < 97){
                ascii = (char) ((encrypted - key) + 26);
            }else{
                ascii = (char) ((encrypted - key));
            }
        }
        else {
            ascii = encrypted;
        }

        return ascii;
    }
}
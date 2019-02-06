/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {
        return alterString(original);
    }

    @Override
    public String decrypt(String encrypted) {
        return alterString(encrypted);
    }

    private String alterString(String message) {
        StringBuilder altered = new StringBuilder();
        for (char ch : message.toCharArray()) {
            altered.append(!Character.isAlphabetic(ch) ? ch : ALPHABETH[ALPHABETH.length - 1 - findCharIndex(ch)]);
        }
        return altered.toString();
    }
}

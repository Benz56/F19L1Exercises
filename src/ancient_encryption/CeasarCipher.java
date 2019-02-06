/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

public class CeasarCipher extends AbstractCipher {

    private final int rotFactor;

    public CeasarCipher(int rotFactor) {
        this.rotFactor = rotFactor > 0 ? rotFactor <= ALPHABETH.length ? rotFactor : ALPHABETH.length : 0;
    }

    @Override
    public String encrypt(String original) {
        return alterString(original, false);
    }

    @Override
    public String decrypt(String encrypted) {
        return alterString(encrypted, true);
    }

    private String alterString(String message, boolean reconstruct) {
        StringBuilder altered = new StringBuilder();
        for (char ch : message.toCharArray()) {
            altered.append(!Character.isAlphabetic(ch) ? ch : ALPHABETH[(findCharIndex(ch) + (!reconstruct ? rotFactor : ALPHABETH.length - rotFactor)) % ALPHABETH.length]);
        }
        return altered.toString();
    }
}

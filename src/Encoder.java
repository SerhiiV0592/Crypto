public class Encoder {

    private static final char bigA = 'A';
    private static final char bigZ = 'Z';
    private static final char smallA = 'a';
    private static final char smallZ = 'z';
    private static final int size = bigZ - bigA;


    public int keyToRange(int key) {
        if (key > size) {
            key = key % size;
        } else if (key < 0 && Math.abs(key) > size) {
            key = size - (Math.abs(key) % size);
        } else if (key < 0 && Math.abs(key) < size) {
            key = size - Math.abs(key);
        } else {
            return key;
        }
        return key;
    }

    public String encode(String txt, int key) {
        key = keyToRange(key);
        char[] c = txt.toCharArray();
        for (int i = 0; i < c.length; i++) {
             if (bigChar(c[i])) {
                c[i] = (char) (c[i] + key);
                if (c[i] > bigZ) {
                    c[i] -= size;
                }
            } else if (smallChar(c[i])) {
                c[i] = (char) (c[i] + key);
                if (c[i] > smallZ) {
                    c[i] -= size;
                }
            }
        }
        return new String(c);
    }

    public String decode(String txt, int key) {
        key = keyToRange(key);
        char[] c = txt.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (bigChar(c[i])) {
                c[i] = (char) (c[i] - key);
                if (c[i] < bigA) {
                    c[i] += size;
                }
            } else if (smallChar(c[i])) {
                c[i] = (char) (c[i] - key);
                if (c[i] < smallA) {
                    c[i] += size;
                }
            }
        }
        return new String(c);
    }

    public boolean smallChar(char c) {
        return c >= smallA && c <= smallZ;
    }

    public boolean bigChar(char c) {
        return c >= bigA && c <= bigZ;
    }
}



public class DecodeCesar {
    static String decode(int shift, char startSymbolInAlfabet, char endSymbolInAlfabet, String lineEncode) {

        int shift1 = shift;
        char startSymbolInAlfabet1 = startSymbolInAlfabet;
        char endSymbolInAlfabet1 = endSymbolInAlfabet;
        int startSymbolInAlfabetCode = (int) startSymbolInAlfabet;
        int endSymbolInAlfabetCode = (int) endSymbolInAlfabet;
        String line1 = lineEncode;
        StringBuilder abc = new StringBuilder();
        for (int i = startSymbolInAlfabetCode; i <= endSymbolInAlfabetCode; i++) {
            abc.append((char) i);
        }
        String alfabet = "" + abc;
        //System.out.println(alfabet);
        char[] charsAlfabet = alfabet.toCharArray();
        char[] encodeIn = line1.toCharArray();
        char[] decode = new char[encodeIn.length];
        for (int i = 0; i < encodeIn.length; i++) {
            int n = ((int) encodeIn[i] - shift1);
            char shiftSymbol = (char) n;
            if (n < startSymbolInAlfabetCode) {
                int n1 = n - startSymbolInAlfabetCode;
                int n2 = endSymbolInAlfabetCode + 1 + n1;
                shiftSymbol = (char) n2;
            }
            int shiftSymbolIndexInABC = alfabet.lastIndexOf(shiftSymbol);
            decode[i] = (charsAlfabet[shiftSymbolIndexInABC]);
        }

        System.out.println("\nDecode message");
        String lineDecode = new String(decode);
        System.out.println(lineDecode);

        return lineDecode;
    }
}

public class EncodeCesar {
    //Encode
    public static String encode(int shift, char startSymbolInAlfabet, char endSymbolInAlfabet, String line) {

        int shift1 = shift;
        char startSymbolInAlfabet1 = startSymbolInAlfabet;
        char endSymbolInAlfabet1 = endSymbolInAlfabet;
        int startSymbolInAlfabetCode = (int) startSymbolInAlfabet;
        int endSymbolInAlfabetCode = (int) endSymbolInAlfabet;
        String line1 = line;
        StringBuilder abc = new StringBuilder();
        for (int i = startSymbolInAlfabetCode; i <= endSymbolInAlfabetCode; i++) {
            abc.append((char) i);
        }
        String alfabet = "" + abc;
        System.out.println("SymbolsMassiveUsingForEncodingCesar" + alfabet);

        char[] chars = line1.toCharArray();
        char[] charsAlfabet = alfabet.toCharArray();
        System.out.println("Encode with shift " + shift1);
        char[] encode = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int n = ((int) chars[i] + shift1);
            char shiftSymbol = (char) n;
            if (n > endSymbolInAlfabetCode) {
                int n1 = n - endSymbolInAlfabetCode;
                int n2 = startSymbolInAlfabetCode - 1 + n1;
                shiftSymbol = (char) n2;
                //System.out.println("n="+n+"n1="+n1+"n2="+n2+"shiftSymbol="+shiftSymbol);
            }
            int shiftSymbolIndexInABC = alfabet.lastIndexOf(shiftSymbol);
            encode[i] = (charsAlfabet[shiftSymbolIndexInABC]);
        }
        System.out.println();
        System.out.println("Encode message");
        String lineEncode = new String(encode);
        System.out.println(lineEncode);
        return lineEncode;
    }
}
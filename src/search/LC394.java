package search;

public class LC394 {
    int idx = 0;
    char[] chars;
    public String decodeString(String s) {
        chars = s.toCharArray();
        return decode();
    }

    public String decode(){
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(readChars());
            int num = readNum();
            String subStr;
            if (idx < chars.length && chars[idx] == '[') {
                idx++;
                subStr = decode();
            } else {
                subStr = readChars();
            }
            for (int i = 0; i < Math.max(num, 1); i++) {
                sb.append(subStr);
            }
            if(idx < chars.length && chars[idx] == ']'){
                idx++;
                break;
            }
        } while (idx < chars.length);
        return sb.toString();

    }


    private String readChars(){
        StringBuilder sb = new StringBuilder();
        while (idx < chars.length && chars[idx] >= 'a' && chars[idx] <= 'z'){
            sb.append(chars[idx++]);
        }
        return sb.toString();
    }

    private int readNum(){
        int num = 0;
        while (idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9'){
            num = num * 10 + (chars[idx++] - '0');
        }
        return num;
    }


}

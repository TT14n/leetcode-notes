class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for(String word : words){
            boolean flag = true;
            for(char c : brokenLetters.toCharArray()){
                if (word.indexOf(c) != -1){
                    flag = false;
                    break;
                }
            }
            count += flag ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.canBeTypedWords("hello world", "ad");
        System.out.println(result);

    }
}
class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            int size = word.length();

            for (int i = 0; i < size; i++) {
                char ch = word.charAt(i);

                if (ch == 'z') {
                    word.append('a');
                } else {
                    word.append((char)(ch + 1));
                }
            }
        }

        return word.charAt(k - 1);
    }
}
class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, result);

        return result;
    }

    private void backtrack(
        String s,
        int idx,
        List<String> current,
        List<String> result
    ) {

        // We need exactly 4 parts
        if (current.size() == 4) {

            // All digits must be used
            if (idx == s.length()) {
                result.add(String.join(".", current));
            }

            return;
        }

        // Try taking 1, 2, or 3 digits
        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {

            // Leading zero is not allowed
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }

            String part = s.substring(idx, i + 1);

            int num = Integer.parseInt(part);

            // Value must be between 0 and 255
            if (num > 255) {
                break;
            }

            // Choose
            current.add(part);

            // Explore
            backtrack(s, i + 1, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}
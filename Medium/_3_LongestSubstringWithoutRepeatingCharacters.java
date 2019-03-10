    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        int curr = 0, start = 0, max = 0, len = s.length();
        Set<Character> set = new HashSet<>();

        while(curr < len && start < len) {
            char c = s.charAt(curr);
            if(set.contains(c)) {
                set.remove(s.charAt(start++));
            } else {
                set.add(c);
                curr++;
                max = Math.max(max, curr - start);
            }
        }

        return max;
    }

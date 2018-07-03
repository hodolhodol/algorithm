import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int longLength, curLength;
        int curStart, curEnd, tmpStart;
        curStart = curEnd = longLength = curLength = 0;

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                curLength = curEnd - curStart + 1;
                longLength = Math.max(longLength, curLength);
                tmpStart = map.get(s.charAt(i)) + 1;
                for(int j = curStart; j < tmpStart; j++) map.remove(s.charAt(j));
                curStart = tmpStart;
            } 
            curEnd = i;
            map.put(s.charAt(i), i);
        }
        return Math.max(longLength, curEnd - curStart + 1);
    }
}
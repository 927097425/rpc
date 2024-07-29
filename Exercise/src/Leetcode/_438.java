package Leetcode;


import java.util.*;

public class _438 {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            Map<Character,Integer> numsPstr = new HashMap<>();
            Map<Character,Integer> numsSstr = new HashMap<>();
            for(int i = 0;i<p.length();i++){
                char c = p.charAt(i);
                if(numsPstr.containsKey(c)) numsPstr.put(c,numsPstr.get(c)+1);
                else numsPstr.put(c,1);
            }
            int q = 1;
            numsSstr.put(s.charAt(0),1);
            for(int i = 0;i<s.length();i++){
                while(q-i<p.length()&&q<s.length()){
                    char c = s.charAt(q);
                    if(numsSstr.containsKey(c)) numsSstr.put(s.charAt(q),numsSstr.get(c)+1);
                    else numsSstr.put(s.charAt(q),1);
                    q++;
                }
                if(check(numsSstr,numsPstr)) result.add(i);
                numsSstr.put(s.charAt(i),numsSstr.get(s.charAt(i))-1);
            }
            return result;
        }

        public static boolean check(Map<Character,Integer> numsSstr,Map<Character,Integer> numsPstr){
            for(char c:numsPstr.keySet()){
                if(!numsSstr.containsKey(c)) return false;
                if(!numsPstr.get(c).equals(numsSstr.get(c))) return false;
            }
            return true;
        }

}

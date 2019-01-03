package com.cyriacdomini.ctci.leetcode;
import java.util.*;
import java.util.regex.*;

public class BoldString{
    public static String addBoldTag(String s, String[] dict){
        List<List<Integer>> matchIndex = new ArrayList<>();      
        for (String reg : dict) {
            Matcher m = Pattern.compile(Pattern.quote(reg)).matcher(s);
            while (m.find()) {
                List<Integer> current = new ArrayList<>();
                current.add(m.start());
                current.add(m.end());
                matchIndex.add(current);
            }
    
        }
        int count = 1, previ = -1;
        while(count > 0){
            count = 0;
            for(int i = 0; i < matchIndex.size(); i++){
                List<Integer> curr = matchIndex.get(i);
                if(curr.get(0)<=previ && i>0){
                    List<Integer> prev = matchIndex.get(i-1);
                    prev.set(1, curr.get(1));
                    matchIndex.remove(i);
                    count++;
                    i--;                        
                }
                previ = curr.get(1);
            }
        }
        for(int i = matchIndex.size()-1;i>=0; i--){
            s = s.substring(0,matchIndex.get(i).get(1)) + "</b>" + s.substring(matchIndex.get(i).get(1),s.length()); 
            s = s.substring(0,matchIndex.get(i).get(0)) + "<b>" + s.substring(matchIndex.get(i).get(0),s.length()); 
        }
        return s;
    }
}
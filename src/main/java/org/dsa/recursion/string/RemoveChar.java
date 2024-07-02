package org.dsa.recursion.string;

public class RemoveChar {

    public static void main(String[] args) {
        String s ="baccd";
        System.out.println(removeChar(s.toCharArray(),0));
        String s1= "baccd";
        System.out.println(removeCharPass(s1.toCharArray(),0,""));

        System.out.println(withoutConvertingToChar("baccd"));


        String sap = " abccsapplecc";
        System.out.println(skipApple(sap));


    }

    static String removeChar(char[] ch , int start){
        String answer = "";
        if(start > ch.length-1){
            return "";
        }
        if( ch[start] != 'a'){
            answer = String.valueOf(ch[start]);
        }
        return answer + removeChar(ch , start+1);
    }

    static String removeCharPass(char[] ch , int start, String answer){
        if(start > ch.length-1){
            return answer;
        }
        if( ch[start] != 'a'){
            answer = answer + String.valueOf(ch[start]);
        }
        return removeCharPass(ch , start+1, answer);
    }

    static String withoutConvertingToChar(String s){
        String answer = "";
        if(s.isEmpty()){
            return "";
        }
        if( s.charAt(0) == 'a'){
            return answer + withoutConvertingToChar(s.substring(1));
        } else{
             answer = String.valueOf(s.charAt(0));
            return  answer + withoutConvertingToChar(s.substring(1));
        }
    }

    static String skipApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if( s.startsWith("apple")){
            return  skipApple(s.substring("apple".length()));
        } else{
            return  s.charAt(0) + skipApple(s.substring(1));
        }
    }
}

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> a=new ArrayDeque<>();
        for(int i=0;i<word.length();i++){
            a.addLast(word.charAt(i));
        }
        return a;
    }
    public boolean isPalindrome(String word){
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        if(word.length()%2==1){
            for(int i=0;i<(word.length()-1)/2;i++){
                if(!cc.equalChars(word.charAt(i),word.charAt(word.length()-1-i))){
                    return false;
                }
            }
            return true;
        }
        else {
            for(int i=0;i<(word.length()/2);i++){
                if(!cc.equalChars(word.charAt(i),word.charAt(word.length()-1-i))){
                    return false;
                }
            }
            return true;
        }
    }
}

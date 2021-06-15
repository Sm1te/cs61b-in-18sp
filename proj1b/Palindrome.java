/**
 * @author Yijian Li
 * @create 2021-06-15 3:44 PM
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> Chars = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Chars.addLast(word.charAt(i));
        }
        return Chars;
    }

    public boolean isPalindrome(String word){
        int flag=0;
        if(word.length()<=1){
            flag=1;
        }else{
            int i=0,j=word.length()-1;
            while(i<j){
                if(word.charAt(i)!=word.charAt(j)){
                    flag=0;
                }else {
                    flag = 1;
                }
                i++;
                j--;
            }
        }
        if(flag==1){
            return true;
        }else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        for(int i = 0; i < word.length()/2; i++) {
            if(!cc.equalChars(word.charAt(i),word.charAt(word.length() -1 -i))){
                return false;
            }
        }
        return true;
    }
}

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

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while(deque.size()>1){
            for (int i = 0; i < deque.size() / 2; i++) {
                char temp1 = deque.removeFirst();
                char temp2 = deque.removeLast();
                if (temp1 - temp2!=0) {
                    return false;
                }
            }
        }
        return true;
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

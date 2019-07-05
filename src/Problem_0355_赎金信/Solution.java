package Problem_0355_赎金信;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = magazine.indexOf(c);
            if (index != -1) {
                magazine = magazine.replaceFirst(c + "", "");
            } else
                return false;
        }
        return true;
    }
}


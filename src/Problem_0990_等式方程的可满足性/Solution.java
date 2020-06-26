package Problem_0990_等式方程的可满足性;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {

    private Set<Set<Character>> collectioin = new HashSet<>();

    public boolean equationsPossible(String[] equations) {
        Arrays.sort(equations, (o1, o2) -> o2.charAt(1) - o1.charAt(2));
        for (int i = 0; i < equations.length; i++) {
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(3);
            boolean operatorEqual = equations[i].charAt(1) == '=';
            Set<Character> set1 = find(a);
            Set<Character> set2 = find(b);
            if (set1 != null && set2 != null) {
                if (operatorEqual)
                    merge(set1, set2);
                else if (set1 == set2)
                    return false;
            } else {
                if (set1 == null && set2 == null) {
                    if (operatorEqual) {
                        Set<Character> add = add(a, null);
                        add(b, add);
                    } else {
                        if (a == b) return false;
                        add(a, null);
                        add(b, null);
                    }
                } else {
                    if (operatorEqual) {
                        if (set1 != null) add(b, set1);
                        else add(a, set2);
                    } else {
                        if (a == b) return false;
                        if (set1 != null) add(b, null);
                        else add(a, null);
                    }
                }
            }
        }
        return true;
    }

    private void merge(Set<Character> set1, Set<Character> set2) {
        if (set1 == set2) return;
        set1.addAll(set2);
        boolean result = collectioin.remove(set2);
    }

    private Set<Character> find(Character c) {
        for (Set<Character> set : collectioin)
            if (set.contains(c)) return set;
        return null;
    }

    private Set<Character> add(Character c, Set<Character> set) {
        if (set == null) {
            set = new HashSet<>();
            set.add(c);
            collectioin.add(set);
        } else
            set.add(c);
        return set;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().equationsPossible(new String[]{
                "a==b","b==c","d==e","e==f",
                "d==a",
                "f!=a"
        });
        System.out.println(b);
    }
}
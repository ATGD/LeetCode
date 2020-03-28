package Problem_5345_通过投票对团队排名;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String rankTeams(String[] votes) {
        //A:1,0,1,0,1
        //B:0,1,0,1,0
        int[][] result = new int[26][votes[0].length()];
        for (int i = 0; i < votes.length; i++) {
            String vote = votes[i];//ABC
            for (int j = 0; j < vote.length(); j++) {
                result[vote.charAt(j) - 'A'][j]++;
            }
        }
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (isEmpyt(result[i])) continue;
            list.add(
                    new Entry(
                            ((char) ('A' + i)),
                            result[i])
            );
        }
        Collections.sort(list, (o1, o2) -> {
                    for (int i = 0; i < o1.point.length; i++) {
                        if (o1.point[i] == o2.point[i]) continue;
                        return o2.point[i] - o1.point[i];
                    }
                    return (int) (o1.name - o2.name);
                }
        );
        StringBuilder sb = new StringBuilder();
        for (Entry entry : list)
            sb.append(entry.name);
        return sb.toString();
    }

    class Entry {
        char name;
        int point[];

        public Entry(char name, int point[]) {
            this.name = name;
            this.point = point;
        }

    }

    public boolean isEmpyt(int[] num) {
        boolean empty = true;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) return false;
        }
        return empty;
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().rankTeams(new String[]{
                "FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL", "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"
//                "ABC", "ACB", "CBA"
//                "ABC",
//                "ACB",
//                "BCA",
//                "BAC",
//                "CBA",
//                "CAB"
        });
        System.out.println(s);
    }
}
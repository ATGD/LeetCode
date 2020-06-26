package Problem_0944_删列造序;

class Solution {
    public int minDeletionSize(String[] A) {
        char[][] charAry = new char[A.length][A[0].length()];
        if (A.length < 2) return 0;
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
//        Map<Integer, StringBuffer> columnMap = new HashMap<>();
//        for (int i = 0; i < A.length; i++) {
//            for (int i1 = 0; i1 < A[i].length(); i1++) {
//                if (columnMap.get(i1) == null) columnMap.put(i1, new StringBuffer());
//                columnMap.get(i1).append(A[i].charAt(i1));
//            }
//        }
//        Iterator<Map.Entry<Integer, StringBuffer>> iterator = columnMap.entrySet().iterator();
//        int count = 0;
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, StringBuffer> next = iterator.next();
//            String s = next.getValue().toString();
//            if (s.length() != 1) {
//                for (int i = 1; i < s.length(); i++) {
//                    if (s.charAt(i) < s.charAt(i - 1)) {
//                        iterator.remove();
//                        count++;
//                        break;
//                    }
//                }
//            }
//        }
//        return count;
    }


}

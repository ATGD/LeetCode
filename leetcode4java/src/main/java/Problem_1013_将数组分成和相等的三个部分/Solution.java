package Problem_1013_将数组分成和相等的三个部分;

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i = 0;i<A.length;i++) sum+=A[i];
        if(sum %3 != 0) return false;
        int target = sum/3;
        int stage = 0,tmpValue = 0,count = 0;
        for(int i = 0;i<A.length;i++){
            tmpValue+=A[i];
            count++;
            if(tmpValue == target && count>0){
                stage++;
                count = 0;
                tmpValue = 0;
            }
        }
        return stage >= 3;
    }
}

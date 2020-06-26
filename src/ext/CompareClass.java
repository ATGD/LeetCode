package ext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareClass {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) list1.add(i);
        for (int i = 250000; i < 1250000; i++) list2.add(i);
        for (int i = 500000; i < 1500000; i++) list3.add(i);
        System.out.println(System.currentTimeMillis());
//        for (int i = 0; i < list1.size(); i++) {
//            Integer value = list1.get(i);
//            if (list2.contains(value) && list3.contains(value))  list4.add(value);
//        }
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        set2.addAll(list2);
        set3.addAll(list3);
        list1.retainAll(set2);
        set2.retainAll(set3);
        System.out.println(System.currentTimeMillis());
        System.out.println(list4.size());
    }
}

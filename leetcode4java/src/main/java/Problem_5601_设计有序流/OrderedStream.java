package Problem_5601_设计有序流;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    String[] sSrg;//later init
    int prt = 1;

    public OrderedStream(int n) {
        sSrg = new String[n];
    }

    public List<String> insert(int id, String value) {
        sSrg[id - 1] = value;
        ArrayList<String> list = new ArrayList<>();
        if (id == prt) {
            for (int i = id - 1; i < sSrg.length; i++) {
                if (sSrg[i] == null) {
                    prt = i + 2;
                    break;
                } else {
                    list.add(sSrg[i]);
                }
            }
            prt = id + list.size();
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
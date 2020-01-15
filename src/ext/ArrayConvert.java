package ext;

import java.util.ArrayList;
import java.util.List;

public class ArrayConvert {

    public static <T> List<List<T>> array2To(T[][] array) {
        List<List<T>> returnList = new ArrayList<>();
        for (T[] ts : array) {
            List<T> list = new ArrayList<>();
            for (T t : ts)
                list.add(t);
            returnList.add(list);
        }
        return returnList;
    }
}

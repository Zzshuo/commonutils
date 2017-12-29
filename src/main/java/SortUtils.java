import java.util.*;

/**
 * @author zeus
 * @date 2017/11/20
 */
public class SortUtils {

    /**
     * 以Map的value排序，并返回x
     *
     * @param oldMap
     * @return
     */
    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> oldMap) {

        if (oldMap != null && !oldMap.isEmpty()) {
            return Collections.emptyMap();
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(oldMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Map<Integer, Integer> newMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            newMap.put(entry.getKey(), entry.getValue());
        }

        return newMap;

    }


}

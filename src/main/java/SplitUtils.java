import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author zeus
 * @date 2017/11/1
 */
public class SplitUtils {

    /**
     * 把字符串分割成  String[]
     *
     * @param value 要分割的字符串，如：“1a,2b,3d,4d,5f”
     * @param split 分隔符
     * @return
     */
    public static String[] split2StringArray(String value, String split) {
        if (StringUtils.isBlank(value)) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        String[] indexAry = value.split(split);
        String[] indexes = new String[indexAry.length];
        try {
            for (int i = 0; i < indexAry.length; i++) {
                if (StringUtils.isEmpty(indexAry[i])) {
                    continue;
                }
                indexes[i] = indexAry[i];
            }
            return indexes;
        } catch (Exception e) {
            e.printStackTrace();
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
    }

    /**
     * 把字符串分割成  Set<String>
     *
     * @param value 要分割的字符串，如：“1a,2b,3d,4d,5f”
     * @param split 分隔符
     * @return
     */
    public static Set<String> split2StringSet(String value, String split) {
        if (StringUtils.isBlank(value)) {
            return Collections.emptySet();
        }

        String[] indexAry = value.split(split);
        Set<String> set = new LinkedHashSet<>();
        try {
            for (int i = 0; i < indexAry.length; i++) {
                if (StringUtils.isEmpty(indexAry[i])) {
                    continue;
                }
                set.add(indexAry[i]);
            }
            return set;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptySet();
        }
    }

    /**
     * 把字符串分割成  Map<String, String>
     *
     * @param value  要分割的字符串，如：“key1:value1,key2:value2”
     * @param split1 第一层分隔符
     * @param split2 第二层分隔符
     * @return
     */
    public static Map<String, String> split2StringMap(String value, String split1, String split2) {
        if (StringUtils.isBlank(value)) {
            return Collections.emptyMap();
        }
        String[] firstAry = value.split(split1);
        Map<String, String> map = new LinkedHashMap<>(firstAry.length);
        try {
            for (int i = 0; i < firstAry.length; i++) {
                if (StringUtils.isEmpty(firstAry[i])) {
                    continue;
                }
                String[] secondAry = firstAry[i].split(split2);
                if (secondAry.length == 1) {
                    map.put(secondAry[0], null);
                } else {
                    map.put(secondAry[0], secondAry[1]);
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }


    /**
     * 把ap组合成字符串
     *
     * @param map
     * @param split1 第一层分隔符
     * @param split2 第二层分隔符
     * @return
     */
    public static String mapJoin2String(Map<?, ?> map, String split1, String split2) {
        if (MapUtils.isEmpty(map)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (i > 0) {
                sb.append(split1);
            }
            sb.append(entry.getKey().toString());
            sb.append(split2);
            sb.append(entry.getValue().toString());
            i++;
        }
        return sb.toString();
    }

    /**
     * 把Collection组合成字符串
     *
     * @param collection
     * @param split      分隔符
     * @return
     */
    public static String collectionJoin2String(Collection<?> collection, String split) {
        if (CollectionUtils.isEmpty(collection)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object object : collection) {
            if (i > 0) {
                sb.append(split);
            }
            sb.append(object.toString());
            i++;
        }
        return sb.toString();
    }


    /**
     * 把对象数组组合成字符串
     *
     * @param objArr int数组
     * @param split  分隔符
     * @return
     */
    public static String intArrayJoin2String(Object[] objArr, String split) {
        if (ArrayUtils.isEmpty(objArr)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : objArr) {
            if (i > 0) {
                sb.append(split);
            }
            sb.append(obj.toString());
            i++;
        }
        return sb.toString();
    }


}

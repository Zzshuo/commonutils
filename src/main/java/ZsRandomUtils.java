import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zeus
 * @date 2017/11/1
 */
public class ZsRandomUtils {


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
}

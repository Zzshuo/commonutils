import java.util.UUID;

/**
 * @author zeus
 * @date 2017/11/6
 */
public class IdUtils {

    public static String generateStringId() {
        return UUID.randomUUID().toString();
    }
}

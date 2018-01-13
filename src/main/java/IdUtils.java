import java.util.UUID;

/**
 * @author zeus
 * @date 2017/11/6
 */
public class IdUtils {

    /**
     * UUID
     *
     * @return
     */
    public static String generateStringId() {
        return UUID.randomUUID().toString();
    }
}

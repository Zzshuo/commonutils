import java.util.Collection;
import java.util.List;

/**
 * @author zeus
 * @date 2018/1/11
 */
public class RandomUtils {

    public static final int      BASE     = 10000;
    private static      Randomer instance = Randomer.getInstance();

    public static Randomer getInstance() {
        return instance;
    }

    public static int nextInt(int limit) {
        return instance.nextInt(limit);
    }

    public static float nextFloat(int limit) {
        return instance.nextFloat(limit);
    }

    public static int nextInt(int min, int max) {
        return instance.nextInt(min, max);
    }

    public static float nextFloat(float min, float max) {
        return instance.nextFloat(min, max);
    }

    public static boolean randomHit(int limit, int value) {
        return instance.randomHit(limit, value);

    }

    public static boolean baseRandomHit(int value) {
        return instance.baseRandomHit(value);
    }

    public static boolean randomHit(int limit, float rate) {
        return instance.randomHit(limit, rate);
    }

    public static boolean bashRandomHit(float rate) {
        return instance.baseRandomHit(rate);
    }


    /**
     * 随机不重复索引
     *
     * @param count 需要生产的不重复索引数量
     * @param size  索引范围
     * @return
     */
    public int[] notRepeatIndexs(int count, int size) {
        return instance.notRepeatIndexs(count, size);
    }

    /**
     * 随机可重复数据
     *
     * @param count   需要生产可重复的数据量
     * @param sources 源数据
     * @param <T>
     * @return
     */
    public <T extends Object> List<T> repeat(int count, List<T> sources) {
        return instance.repeat(count, sources);
    }

    /**
     * 随机不重复数据
     *
     * @param count   需要生产的不重复数据数量
     * @param sources 源数据
     * @param <T>
     * @return
     */
    public <T extends Object> List<T> notepeat(int count, List<T> sources) {
        return instance.notRepeat(count, sources);
    }

    /**
     * Collection 随机获取数据
     *
     * @param sources
     * @param <T>
     * @return
     */
    public <T extends Object> T next(Collection<T> sources) {
        return instance.next(sources);
    }

    /**
     * Collection 随机获取数据 去除excludes
     *
     * @param sources
     * @param excludes
     * @param <T>
     * @return
     */
    public <T extends Object> T next(Collection<T> sources, T... excludes) {
        return instance.next(sources, excludes);
    }

    /**
     * Collection 随机获取数据，去除excludes
     *
     * @param sources
     * @param excludes
     * @param <T>
     * @return
     */
    public <T extends Object> T next(Collection<T> sources, Collection<T> excludes) {
        return instance.next(sources, excludes);
    }

    /**
     * List 随机获取数据
     *
     * @param sources
     * @param <T>
     * @return
     */
    public <T extends Object> T next(List<T> sources) {
        return instance.next(sources);
    }
}

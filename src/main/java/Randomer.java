import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @author zeus
 * @date 2018/1/11
 */
public class Randomer {

    private static final Random   random   = new Random(System.currentTimeMillis());
    private static       Randomer instance = new Randomer();
    private static       Random[] randoms  = new Random[10];

    static {
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = new Random(System.currentTimeMillis() + random.nextInt(Integer.MAX_VALUE));
        }
    }

    public static Randomer getInstance() {
        return instance;
    }

    public boolean randomHit(int limit, int value) {
        if (value <= 0) {
            return false;
        }
        if (value >= limit) {
            return true;
        }
        int randomValue = nextInt(1, limit);
        return randomValue <= value;
    }

    public boolean baseRandomHit(int value) {
        return randomHit(RandomUtils.BASE, value);
    }

    public boolean randomHit(int limit, float rate) {
        if (rate <= 0) {
            return false;
        }
        rate = rate * limit;
        if (rate >= limit) {
            return true;
        }
        int randomValue = nextInt(1, limit);
        return randomValue <= rate;
    }

    public boolean baseRandomHit(float rate) {
        return randomHit(RandomUtils.BASE, rate);
    }

    public int nextInt(int limit) {
        int randomIndex = random.nextInt(randoms.length);
        Random random = randoms[randomIndex];
        return random.nextInt(limit);
    }

    public float nextFloat(float limit) {
        int randomIndex = random.nextInt(randoms.length);
        Random random = randoms[randomIndex];
        return random.nextInt((int) (limit * RandomUtils.BASE)) / RandomUtils.BASE * 1f;
    }

    public int nextInt(int min, int max) {
        if (min == max) {
            return min;
        }
        int randomIndex = random.nextInt(randoms.length);
        Random random = randoms[randomIndex];
        int value = max - min + 1;
        return random.nextInt(value <= 0 ? 1 : value) + min;
    }

    public float nextFloat(float min, float max) {
        int randomInt = nextInt((int) (min * RandomUtils.BASE), (int) (max * RandomUtils.BASE));
        return randomInt * 1f / RandomUtils.BASE;
    }


    /**
     * 随机不重复索引
     *
     * @param count 需要生产的不重复索引数量
     * @param size  索引范围
     * @return
     */
    public int[] notRepeatIndexs(int count, int size) {
        if (count == 0 || size == 0) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        int[] sources = new int[size];
        for (int i = 0; i < count; i++) {
            sources[i] = i;
        }
        if (count > size) {
            count = size;
        }
        int randomRange = size;
        for (int i = 0; i < count; i++) {
            int randomIndex = RandomUtils.nextInt(randomRange);
            int replaceIndex = size - i - 1;
            int randomValue = sources[randomIndex];
            int replaceValue = sources[replaceIndex];
            sources[randomIndex] = replaceValue;
            sources[replaceIndex] = randomValue;
            randomRange--;
        }
        return ArrayUtils.subarray(sources, size - count, size);
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
        if (count == 0 || sources == null || sources.isEmpty()) {
            return Collections.emptyList();
        }
        int total = sources.size();
        List<T> repeats = new ArrayList<T>(count);
        for (int i = 0; i < count; i++) {
            int index = nextInt(total);
            repeats.add(sources.get(index));
        }
        return repeats;
    }

    /**
     * 随机不重复数据
     *
     * @param count   需要生产的不重复数据数量
     * @param sources 源数据
     * @param <T>
     * @return
     */
    public <T extends Object> List<T> notRepeat(int count, List<T> sources) {
        if (count == 0 || sources == null || sources.isEmpty()) {
            return Collections.emptyList();
        }
        int size = sources.size();
        if (count >= size) {
            return sources;
        }
        int[] notRepeatIndexs = notRepeatIndexs(count, size);
        List<T> notRepeats = new ArrayList<T>(count);
        for (int i = 0; i < notRepeatIndexs.length; i++) {
            int index = notRepeatIndexs[i];
            notRepeats.add(sources.get(index));
        }
        return notRepeats;
    }

    public <T extends Object> T next(Collection<T> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return null;
        }
        List<T> list = new ArrayList<>();
        list.addAll(sources);
        T target = list.get(RandomUtils.nextInt(sources.size()));
        list.clear();
        list = null;
        return target;
    }

    public <T extends Object> T next(Collection<T> sources, T... excludes) {
        if (CollectionUtils.isEmpty(sources)) {
            return null;
        }
        List<T> list = new ArrayList<>();
        if (excludes.length > 0) {
            for (Iterator<T> it = sources.iterator(); it.hasNext(); ) {
                T object = it.next();
                if (ArrayUtils.contains(excludes, object)) {
                    continue;
                }
                list.add(object);
            }
        } else {
            list.addAll(sources);
        }
        if (list.isEmpty()) {
            return null;
        }
        T target = list.get(RandomUtils.nextInt(sources.size()));
        list.clear();
        list = null;
        return target;
    }

    public <T extends Object> T next(Collection<T> sources, Collection<T> excludes) {
        if (CollectionUtils.isEmpty(sources)) {
            return null;
        }
        List<T> list = new ArrayList<>();
        if (excludes.size() > 0) {
            for (Iterator<T> it = sources.iterator(); it.hasNext(); ) {
                T object = it.next();
                if (excludes.contains(object)) {
                    continue;
                }
                list.add(object);
            }
        } else {
            list.addAll(sources);
        }
        if (list.isEmpty()) {
            return null;
        }
        T target = list.get(RandomUtils.nextInt(sources.size()));
        list.clear();
        list = null;
        return target;
    }

    public <T extends Object> T next(List<T> sources) {
        if (CollectionUtils.isEmpty(sources)) {
            return null;
        }
        return sources.get(RandomUtils.nextInt(sources.size()));
    }

}

package top.tobing.algorithm.sort;

/**
 * @author tobing
 * @date 2021/9/3 14:28
 * @description
 */
class Couple implements Comparable {
    int val;
    int id;

    public Couple(int val, int id) {
        this.val = val;
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Couple o1 = (Couple) o;
        if (this.val > o1.val) {
            return 1;
        } else if (this.val < o1.val) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Couple{" +
                "val=" + val +
                ", id=" + id +
                '}';
    }
}

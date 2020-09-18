package example.domain.model.booking;

/**
 * 航海
 */
public class Voyage {
    int bookedSize;
    static final int capacity = 100;

    // TODO　setterは撲滅する
    public void addBookedSize(int size) {
        this.bookedSize += size;
    }

    // TODO getterは使わない
    public int capacity() {
        return capacity;
    }

    // TODO getterは使わない
    public int bookedSize() {
        return bookedSize;
    }
}

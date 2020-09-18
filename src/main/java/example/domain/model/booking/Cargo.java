package example.domain.model.booking;

/**
 * 貨物
 */
public class Cargo {
    int size;

    public Cargo(int size) {
        this.size = size;
    }

    // TODO getterは使わない
    public int size() {
        return size;
    }
}

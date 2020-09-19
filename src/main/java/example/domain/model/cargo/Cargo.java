package example.domain.model.cargo;

import example.domain.model.type.Size;

/**
 * 貨物
 */
public class Cargo {
    Size size;

    public Cargo(Size size) {
        this.size = size;
    }

    public boolean isLargerThan(Size other) {
        return size.isLargerThan(other);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "size=" + size +
                '}';
    }
}

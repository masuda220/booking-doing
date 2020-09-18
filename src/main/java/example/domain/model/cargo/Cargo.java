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

    public boolean isSmallerThan(Size other) {
        return size.isSmallerThan(other);
    }
}

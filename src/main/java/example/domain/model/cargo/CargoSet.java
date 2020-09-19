package example.domain.model.cargo;

import example.domain.model.type.Size;

import java.util.HashSet;
import java.util.Set;

/**
 * 貨物の集合
 */
public class CargoSet {
    Set<Cargo> set;

    private CargoSet(Set<Cargo> set) {
        this.set = set;
    }

    public CargoSet addCargo(Cargo cargo) {
        Set<Cargo> result = new HashSet<>(set);
        result.add(cargo);
        return new CargoSet(result);
    }

    public Size total() {
        Size result = Size.ZERO;
        for (Cargo each : set) {
            result = result.add(each.size);
        }
        return result;
    }

    public static CargoSet of(Cargo... cargos) {
        Set<Cargo> result = Set.of(cargos);
        return new CargoSet(result);
    }
    public static CargoSet EMPTY = CargoSet.of();

    @Override
    public String toString() {
        return "CargoSet{" +
                "set=" + set +
                '}';
    }
}

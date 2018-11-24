package l6task1.factories;

import l6task1.Pack;
import l6task1.PackType;

import java.util.Collections;
import java.util.List;

public class PackFactory {

    public static List<Pack> createPacks(PackType packType) {
        switch (packType) {
            case BAG: {
                return new BagPackFactory().createPacks();
            }
            case CAN: {
                return new CanPackFactory().createPacks();
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
}

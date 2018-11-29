package l6task1.factory;

import l6task1.constant.PackType;
import l6task1.model.Pack;

import java.util.Collections;
import java.util.List;

public class PackFactory {

    private PackFactory() {
    }

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

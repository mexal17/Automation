package l6task1.factories;

import l6task1.Pack;
import l6task1.PackType;

import java.util.ArrayList;
import java.util.List;

public class PackFactory {

    public static List<Pack> createPacks(PackType packType) {
        List<Pack> packs = new ArrayList<>();
        switch (packType) {
            case BAG: {
                packs = new BagPackFactory().createPacks();
                break;
            }
            case CAN: {
                packs = new CanPackFactory().createPacks();
                break;
            }
        }
        return packs;
    }
}

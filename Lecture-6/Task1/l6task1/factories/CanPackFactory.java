package l6task1.factories;

import l6task1.Pack;
import l6task1.ProductGenerator;

import java.util.ArrayList;
import java.util.List;

public class CanPackFactory implements PackFactory {
    @Override
    public List<Pack> createPacks() {
        List<Pack> packs = new ArrayList<>();
        for (int i = 0; i < ProductGenerator.PACK_CAPACITY.length; i++) {
            packs.add(new Pack("can", 2 * ProductGenerator.PACK_WEIGHT[i], 2 * ProductGenerator.PACK_PRICE[i], ProductGenerator.PACK_CAPACITY[i]));
        }
        return packs;
    }
}

package l6task1.factory;

import l6task1.model.Pack;
import l6task1.constant.PackType;
import l6task1.util.ProductGenerator;

import java.util.ArrayList;
import java.util.List;

public class BagPackFactory implements IPackFactory {
    @Override
    public List<Pack> createPacks() {
        List<Pack> packs = new ArrayList<>();
        for (int i = 0; i < ProductGenerator.getPackCapacity().length; i++) {
            packs.add(new Pack(PackType.BAG.name(), ProductGenerator.getPackWeight()[i], ProductGenerator.getPackPrices()[i], ProductGenerator.getPackCapacity()[i]));
        }
        return packs;
    }
}

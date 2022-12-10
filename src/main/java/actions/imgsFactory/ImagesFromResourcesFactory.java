package actions.imgsFactory;

import actions.box.Skin;
import utils.MyUtils;

public class ImagesFromResourcesFactory {
    public static CharacterImagesFromResources createCharacterImagesFromResources(Skin skin) {
        if (skin == Skin.Spirit) {
            return new SpiritImagesFromResources();
        } else if (skin == Skin.Undead) {
            return new UndeadImagesFromResources();
        } else if (skin == Skin.Devil) {
            return new DevilImagesFromResources();
        } else if (skin == Skin.Punk) {
            return new PunkImagesFromResources();
        } else if (skin == Skin.BrawlerGirl) {
            return new GirlImagesFromResources();
        } else {
            MyUtils.printSkinNotFound();
            return new SpiritImagesFromResources();
        }
    }
}

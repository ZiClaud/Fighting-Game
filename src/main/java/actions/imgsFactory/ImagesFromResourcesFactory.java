package actions.imgsFactory;

import utils.MyUtils;

public class ImagesFromResourcesFactory {
    public static CharacterImagesFromResources createCharacterImagesFromResources2(Skin skin){
        if (skin == Skin.Spirit) {
            return new SpiritImagesFromResources();
        } else if (skin == Skin.Undead) {
            return new UndeadImagesFromResources();
        } else if (skin == Skin.Devil) {
            return new DevilImagesFromResources();
        } else {
            MyUtils.printSkinNotFound();
            return new SpiritImagesFromResources();
        }
    }
}

package actions.imgsFactory;

public class ImagesFromResourcesFactory {
    public static CharacterImagesFromResources createCharacterImagesFromResources2(Skin skin){
        if (skin == Skin.Spirit) {
            return new SpiritImagesFromResources();
        } else if (skin == Skin.Undead) {
            return new UndeadImagesFromResources();
        } else if (skin == Skin.Devil) {
            return new DevilImagesFromResources();
        } else {
            System.err.println("Skin not found");
            System.out.println("Skin not found");
            System.out.println("Skin not found");
            System.err.println("Skin not found");
            return new SpiritImagesFromResources();
        }
    }
}

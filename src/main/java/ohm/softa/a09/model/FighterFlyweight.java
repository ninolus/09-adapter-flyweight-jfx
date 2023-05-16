package ohm.softa.a09.model;

import javafx.scene.image.Image;
import ohm.softa.a09.resource.ResourceLoader;

public class FighterFlyweight {

	private final Image fighterImage;

	public FighterFlyweight(String path, ResourceLoader<Image> imageResourceLoader) {
		this.fighterImage = imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), path);
	}

	public Image getFighterImage() {
		return fighterImage;
	}
}

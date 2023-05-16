package ohm.softa.a09.model;

import javafx.scene.image.Image;
import ohm.softa.a09.resource.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public class FighterFlyweightFactory {
	private Map<String, FighterFlyweight> flyweights = new HashMap<>();
	private final ResourceLoader<Image> imageResourceLoader;

	public FighterFlyweightFactory() {
		imageResourceLoader = new ResourceLoader<>(Image::new);

	}


	public FighterFlyweight getFlyweight(String path) {
		if (flyweights.containsKey(path)) {
			return flyweights.get(path);
		}

		FighterFlyweight fw = new FighterFlyweight(path, imageResourceLoader);
		flyweights.put(path, fw);
		return fw;
	}
}

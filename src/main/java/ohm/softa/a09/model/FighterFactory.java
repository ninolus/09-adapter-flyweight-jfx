package ohm.softa.a09.model;

import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;
import ohm.softa.a09.resource.ResourceLoader;
import ohm.softa.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;

	private Map<String, Image> imageCache = new HashMap<>();
	private final ResourceLoader<Image> imageResourceLoader;


	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		imageResourceLoader = new ResourceLoader<>(Image::new);

	}

	public Image getImage(String path) {
		if (imageCache.containsKey(path)) {
			return imageCache.get(path);
		}
		this.imageCache.put(path, imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), path));
		return this.imageCache.get(path);

	}

	/**
	 * Create a random Fighter
	 *
	 * @return a new Fighter instance
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 */
	public Fighter createFighter() {
		switch (random.nextInt(NumberOfKnownFighterTypes)) {
			case 0:
				return new AWing(nameGenerator.generateName(), getImage("fighter/awing.jpg"));
			case 1:
				return new XWing(nameGenerator.generateName(), getImage("fighter/xwing.jpg"));
			case 2:
				return new YWing(nameGenerator.generateName(), getImage("fighter/ywing.jpg"));
			case 3:
				return new TieBomber(nameGenerator.generateName(), getImage("fighter/tiebomber.jpg"));
			case 4:
				return new TieFighter(nameGenerator.generateName(), getImage("fighter/tiefighter.jpg"));
			default:
				return new TieInterceptor(nameGenerator.generateName(), getImage("fighter/tieinterceptor.jpg"));
		}
	}
}

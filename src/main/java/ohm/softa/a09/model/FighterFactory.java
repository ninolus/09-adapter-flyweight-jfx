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

	private final FighterFlyweightFactory flyweightFactory;

	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		flyweightFactory = new FighterFlyweightFactory();
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
				return new AWing(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/awing.jpg"));
			case 1:
				return new XWing(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/xwing.jpg"));
			case 2:
				return new YWing(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/ywing.jpg"));
			case 3:
				return new TieBomber(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/tiebomber.jpg"));
			case 4:
				return new TieFighter(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/tiefighter.jpg"));
			default:
				return new TieInterceptor(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/tieinterceptor.jpg"));
		}
	}
}

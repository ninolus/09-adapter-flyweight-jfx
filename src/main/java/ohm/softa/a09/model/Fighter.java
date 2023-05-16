package ohm.softa.a09.model;

import javafx.scene.image.Image;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Peter Kurfer
 */

public abstract class Fighter {

	private final String pilot;
	private final FighterFlyweight fighterFlyweight;

	public Fighter(String pilot, FighterFlyweight fighterFlyweight) {
		this.pilot = pilot;
		this.fighterFlyweight = fighterFlyweight;
	}

	public String getPilot() {
		return pilot;
	}

	public FighterFlyweight getFighterFlyweight() {
		return fighterFlyweight;
	}

	public abstract Force getSideOfForce();

	public abstract String getFighterType();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Fighter)) return false;

		Fighter fighter = (Fighter) o;

		return new EqualsBuilder()
			.append(getPilot(), fighter.getPilot())
			.append(getFighterType(), fighter.getFighterType())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getPilot())
			.append(getFighterType())
			.toHashCode();
	}
}

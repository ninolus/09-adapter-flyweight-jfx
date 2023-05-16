package ohm.softa.a09.model.rebellion;

import ohm.softa.a09.model.Fighter;
import ohm.softa.a09.model.FighterFlyweight;
import ohm.softa.a09.model.Force;
import javafx.scene.image.Image;

public class XWing extends Fighter {

	public XWing(String pilot, FighterFlyweight fighterFlyweight) {
		super(pilot, fighterFlyweight);
	}

	@Override
	public Force getSideOfForce() {
		return Force.LightSide;
	}

	@Override
	public String getFighterType() {
		return "X-Wing";
	}
}

package ohm.softa.a09.resource;


import javafx.scene.image.Image;

public class FxImageLoaderAdapter {
	private ResourceLoader<Image> resourceLoader;

	public FxImageLoaderAdapter() {
		this.resourceLoader = new ResourceLoader<>(Image::new);

	}

	public Image loadImage(String resourcePath) {
		return resourceLoader.loadResource(ClassLoader.getSystemClassLoader(), resourcePath);
	}

	public Image loadImage(ClassLoader resoucreContext, String resourcePath) {
		return resourceLoader.loadResource(resoucreContext, resourcePath);

	}

}

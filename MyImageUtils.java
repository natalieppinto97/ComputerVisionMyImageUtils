import java.awt.Color;

public class MyImageUtils  {
	
	public static void main(String[] args) {
		String filename = null;
		if(args.length == 1) {
			filename = args[0];
	
		ImageUtils utils = new ImageUtils();
		Color[][] img = utils.loadImage(filename);
		
		
		Color[][] sepia = SepiaImage(img);
		Color[][]inverted = InvertImage(img);
		Color[][] blackwhite = BlackWhiteImage(img);
		Color[][] brighter = BrightenImage(BrightenImage(BrightenImage(BrightenImage(img))));
		Color[][] darker = DarkenImage(DarkenImage(DarkenImage(DarkenImage(DarkenImage(DarkenImage(img))))));
		Color[][] flip = FlipImage(img);
		Color[][] mirror = MirrorImage(img);
		Color[][] mirrorsepia = MirrorImage(sepia);
		Color[][] transposedinverted = FlipImage(MirrorImage(InvertImage(img)));
		utils.addImage(img, "Original");
		utils.addImage(sepia, "Sepia");
		utils.addImage(inverted, "Inverted");
		utils.addImage(blackwhite, "Black and White");
		utils.addImage(brighter, "Brightened");
		utils.addImage(darker, "Darkened");
		utils.addImage(flip , "Flipped");
		utils.addImage(mirror , "Mirrored");
		utils.addImage(mirrorsepia, "Mirrored Sepia");
		utils.addImage(transposedinverted, "Transposed Inverted");
		
		utils.display();
		}	
	}

public static Color[][] InvertImage(Color[][] img) {
	 Color[][] Invert = ImageUtils.cloneArray(img);
	int width = img[0].length;
	int height = img.length;
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			int red = img[x][y].getRed();
			int green = img[x][y].getGreen();
			int blue = img[x][y].getBlue();		
			int r = 255 - red;
			int g = 255 - green;
			int b = 255 - blue;	
			Color RGB = new Color(r, g, b);
			Invert[x][y] = RGB;
		}
	}
	return Invert;
}

public static Color[][] SepiaImage(Color[][] img) {
	Color[][] Sepia = ImageUtils.cloneArray(img);
	int width = img[0].length;
	int height = img.length;
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			int r = img[x][y].getRed();
			int g = img[x][y].getGreen();
			int b = img[x][y].getBlue();	
			int tr = (int)(0.393* r +(0.796*g +(0.189*b)));
			int tg = (int)(0.349*r +(0.686*g +(0.168*b)));
			int tb = (int)(0.272*r +(0.534*g +(0.131*b)));
			if(tr > 255) {
				r =255;
			}
			else {
				r= tr;
			}
			if(tg > 255) {
				g = 255;
			}
			else {
				g = tg;
			}
			if(tb > 255) {
				b = 255;
			}
			else {
				b = tb;
			}
			Color RGB = new Color(r, g, b);
			Sepia[x][y] = RGB;
		}
	}
	return Sepia;
}



public static Color[][] BlackWhiteImage(Color[][] img){
	 Color[][] BlackWhite = ImageUtils.cloneArray(img);
		int width = img[0].length;
		int height = img.length;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
			
				int r = img[x][y].getRed();
				int g = img[x][y].getGreen();
				int b = img[x][y].getBlue();
				int averageRGB = (r+g+b)/3;
				Color RGB = new Color(averageRGB, averageRGB, averageRGB);
				BlackWhite[x][y] = RGB;
			}
		}
		return BlackWhite;
	}

public static Color[][] BrightenImage(Color[][] img){
	Color[][] Brighten = ImageUtils.cloneArray(img);
	int width = img[0].length;
	int height = img.length;
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			Brighten[x][y] = img[x][y].brighter();
		}
}
	return Brighten;
}

public static Color[][] DarkenImage(Color[][] img){
	Color [][] Darken = ImageUtils.cloneArray(img);
	int width = img[0].length;
	int height = img.length;
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			Darken[x][y] = img[x][y].darker();
		}
	}
	return Darken;
}

public static Color[][] FlipImage(Color[][] img){
	Color[][] Flip = ImageUtils.cloneArray(img);
	int width = img[0].length;
	int height = img.length;
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			int change = width - x - 1;
			Flip[y][x] = img[y][change];
		}	
}
	return Flip;
}

public static Color[][] MirrorImage(Color[][] img){
	Color[][] Mirror = ImageUtils.cloneArray(img);
	int width = img[0].length;
	int height = img.length;
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			int change = width - x - 1;
			Mirror[x][y] = img[change][y];
		}
}
	return Mirror;
}




}

	







	


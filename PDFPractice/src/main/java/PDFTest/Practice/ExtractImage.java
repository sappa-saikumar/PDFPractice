package PDFTest.Practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class ExtractImage {

	public static void main(String[] args) throws IOException {
		//It's in developing stage
		File file= new File("C:\\Users\\Personal\\Downloads\\sample-pdf-with-images.pdf");
		PDDocument doc= PDDocument.load(file);
		
		PDFRenderer renderer= new PDFRenderer(doc);
		BufferedImage image= renderer.renderImage(4);
		
		ImageIO.write(image, "jpeg", new File(System.getProperty("user.dir")+"//target//Myimage.jpeg"));
		
		
	}

}

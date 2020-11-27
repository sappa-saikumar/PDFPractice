package PDFTest.Practice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class TextExtract {

	public static void main(String[] args) throws IOException {
		File file= new File("C:\\Users\\Personal\\Documents\\Desktop\\FillablePDFFormSample.pdf");
	
		PDFTextStripper textExtract= new PDFTextStripper();	
		//textExtract.setStartPage(1);
		//textExtract.setEndPage(2);
		PDDocument doc= PDDocument.load(file);
		
		//Extract total text from PDF
		String text= textExtract.getText(doc);
		System.out.print(text);
		
		//int iStartPage= textExtract.getStartPage();
		//int iEndPage= textExtract.getEndPage();
		//System.out.print("StartPageNumber: "+iStartPage+" EndPageNumber: "+iEndPage);
		
		doc.close();
	}

}

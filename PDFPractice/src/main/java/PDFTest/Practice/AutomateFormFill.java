package PDFTest.Practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDComboBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
//import org.apache.pdfbox.Loader;

public class AutomateFormFill {

	public static void main(String[] args) throws IOException {
		File Input= new File(System.getProperty("user.dir")+"\\src\\main\\resources\\FillablePDFFormSample.pdf");
		File Output= new File(System.getProperty("user.dir")+"\\target\\FillablePDFFormSample.pdf");
		
		PDDocument doc= PDDocument.load(Input);
		PDAcroForm form= doc.getDocumentCatalog().getAcroForm();
		List<PDField> list= form.getFields();
		System.out.print(list.size());
		
		//PDTextField field= (PDTextField) list.get(0);
		PDTextField Name= (PDTextField) form.getField("Given Name Text Box");
		Name.setValue("Sai Kumar");
		
		PDTextField FamilyName= (PDTextField) form.getField("Family Name Text Box");
		FamilyName.setValue("Sappa");
		
		PDTextField Address1= (PDTextField) form.getField("Address 1 Text Box");
		Address1.setValue("BuradavariStreet");
		
		PDTextField Address2= (PDTextField) form.getField("Address 2 Text Box");
		Address2.setValue("Kothapet");
		
		PDTextField Postcode= (PDTextField) form.getField("Postcode Text Box");
		Postcode.setValue("534002");
		
		PDTextField City= (PDTextField) form.getField("City Text Box");
		City.setValue("Hyderabad");
		
		//CheckBox Validations
		System.out.println("--------Check Box Validations-----------------");
		PDCheckBox lang1= (PDCheckBox) form.getField("Language 1 Check Box");
		PDCheckBox lang2= (PDCheckBox) form.getField("Language 2 Check Box");
		
		String defaultValue= lang1.getDefaultValue();// Get the default value
		System.out.println("Default Value: "+defaultValue);
		
		boolean bFlag= lang1.isChecked();// Verify is already checked or not
		System.out.println("Check box checked flag: "+bFlag);
		
		lang1.check();// To select the check box
		
		boolean bFlag1= lang1.isChecked();// Verify to check language is selected or not after "lang1.check()"
		System.out.println("Check box after check: "+bFlag1);
		
		lang2.unCheck();//To Deselect the check box
		
		boolean bFlag2= lang2.isChecked();// Verify to check language is selected or not after deselect
		System.out.println("Check box unchecked flag: "+bFlag2);
		
		//Combobox Validations
		System.out.println("--------Combobox Validations-----------------");
		PDComboBox color= (PDComboBox) form.getField("Country Combo Box");
		List<String> options= color.getOptions();
		
		//Select a value in combobox
		color.setValue("Cyprus");
		
		List<String> l2= color.getValue();
		System.out.println("Default Value: "+l2.get(0));
		
		//boolean bFlag= color.isMultiSelect();
		//System.out.println("Is Multiselect:"+bFlag);
		
		
		form.refreshAppearances();
		doc.getDocumentCatalog().getAcroForm().flatten(); // After this step document will not usable editable mode.
		//doc.setAllSecurityToBeRemoved(true);
		doc.save(Output);
		doc.close();
		
	}
}


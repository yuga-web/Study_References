package tst;

import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import java.util.Map;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.Docx4J;

public class PDF2WordExample {

	private static final String FILENAME = "C:\\Users\\PC 1\\Downloads\\1605371752047-2.pdf";
	private static final String INFILE = "C:\\Users\\PC 1\\Downloads\\1605371752047-7.docx";
	private static final String OUTFILE = "C:\\Users\\PC 1\\Downloads\\1605371752047-7.xml";
	

	public static void main(String[] args) throws Docx4JException {
		try {
			generateDocFromPDF(FILENAME);
			convertWordToXml(INFILE,OUTFILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
/*	 public static String pdf2Text(final String inputFile) throws InvalidPasswordException, IOException {
	        final File file = new File(inputFile);
	        final PDDocument document = PDDocument.load(file);
	        final PDFTextStripper pdfStripper = new PDFTextStripper();
	        final String text = pdfStripper.getText(document);
	        document.close();
	        return text;
	    }
	    
	    public static void joinPDFFiles(final String destination, final String... paths) throws IOException {
	        final PDFMergerUtility ut = new PDFMergerUtility();
	        for (final String path : paths) {
	            ut.addSource(path);
	        }
	        ut.setDestinationFileName(destination);
	        ut.mergeDocuments();
	    }
	    */
	  
	private static void generateDocFromPDF(String filename) throws IOException {
		XWPFDocument doc = new XWPFDocument();

		String pdf = filename;
		PdfReader reader = new PdfReader(pdf);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);

		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			TextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			String text = strategy.getResultantText();
			XWPFParagraph p = doc.createParagraph();
			XWPFRun run = p.createRun();
			run.setText(text);
			run.addBreak(BreakType.PAGE);
		}
		FileOutputStream out = new FileOutputStream("C:\\\\Users\\\\PC 1\\\\Downloads\\\\1605371752047-7.DOCX");
		doc.write(out);
		out.close();
		reader.close();
		doc.close();
	}
	
    
	 public static void convertWordToXml(final String wordInFile, final String xmlOutFile) throws Docx4JException {
	        final WordprocessingMLPackage wmlPackage = Docx4J.load(new File(wordInFile));
	        Docx4J.save(wmlPackage, new File(xmlOutFile), 2);
	    }
}
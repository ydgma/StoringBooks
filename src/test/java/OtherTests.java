import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class OtherTests {
    private String PDF_FILE_PATH = "/Users/yasirudahanayake/IdeaProjects/test2/src/main/resources/33364.txt.utf-8.pdf";
    private static final String UTF8_FILE_PATH = "/Users/yasirudahanayake/IdeaProjects/test2/src/main/resources/33364.txt.utf-8.txt";
    private PDF pdf = new PDF(PDF_FILE_PATH);
    private UTF8 utf8 = new UTF8(UTF8_FILE_PATH);

    @Test
    public void comparePDFAndUTF8Strings() {
        String pdfString = pdf.getFileContentAsString();
        String utfString = utf8.getFileContentAsString();
        StringUtils.difference(pdfString,utfString);
        Assert.assertEquals(pdfString,utfString);
    }
}

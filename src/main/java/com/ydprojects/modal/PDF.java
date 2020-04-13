package com.ydprojects.modal;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class PDF extends AbstractBook {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBook.class);
    private String bookContentsAsString;
    private int wordCount;
    private int specificWordCount;
    private byte [] bookAsFile;
    private String bookName;
    private String filePath;
    private PDDocument PDFDocument;

    public PDF (String filePath, String bookName){
        this.bookContentsAsString = convertBookContentsToString();
        this.wordCount = super.wordCount();
        this.bookName = bookName;
        this.filePath = filePath;
    }

    public String convertBookContentsToString() {
        loadPDF();
        try {
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            PDFTextStripper tStripper = new PDFTextStripper();
            bookContentsAsString = tStripper.getText(PDFDocument);
            return bookContentsAsString;
        } catch (IOException e) {
            LOG.info("{}",e);
        }
        return "failed to convert the pdf to string";
    }

    @Override
    public String getBookContentsAsString() {
        return bookContentsAsString;
    }

    @Override
    public int getWordCount() {
        return wordCount;
    }

    @Override
    public int getSpecificWordCount(String wordToSearch) {
        this.specificWordCount = super.specificWordCount(wordToSearch);
        return specificWordCount;
    }

    @Override
    public byte[] getBookAsFile() {
        return new byte[0];
    }

    @Override
    public String bookName() {
        return bookName;
    }

    @Override
    public String getBookFilePath() {
        return filePath;
    }

    @Override
    public String getBookType() {
        return "PDF";
    }

    private void loadPDF() {
        try {
            PDFDocument = PDDocument.load(new File(filePath));
        } catch (IOException e) {
            LOG.info("{}",e);
        }
    }
}

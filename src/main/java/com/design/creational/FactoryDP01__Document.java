package com.design.creational;

interface Document {
	void openDocument();

	void closeDocuemnt();
}

class PdfDocuemnt implements Document {
	@Override
	public void openDocument() {
		System.out.println("Open the Pdf Docuemnt ");

	}

	@Override
	public void closeDocuemnt() {
		System.out.println("Close the PDF Docuemnt ");
	}
}

class WordDocuemnt implements Document {
	@Override
	public void openDocument() {
		System.out.println("Open the word Docuemnt ");

	}

	@Override
	public void closeDocuemnt() {
		System.out.println("Close the word Docuemnt ");
	}
}

abstract class DocumentCreator {
	public abstract Document createDocument();
	
	public void OpenDocument() {
		Document doc=createDocument();
		doc.openDocument();
	}
	
	public void CloseDocument() {
		Document doc=createDocument();
		doc.closeDocuemnt();
	}
}

class PdfDocumentCreator extends DocumentCreator{
	
	@Override
	public Document createDocument() {		
		return new PdfDocuemnt();
	}
}

class WordDocumentCreator extends DocumentCreator{	
	@Override
	public Document createDocument() {		
		return new WordDocuemnt();
	}
}

public class FactoryDP01__Document {

	public static void main(String[] args) {
		DocumentCreator creator;
		
		creator=new PdfDocumentCreator();
		creator.OpenDocument();
		creator.CloseDocument();
		
		creator=new WordDocumentCreator();
		creator.OpenDocument();
		creator.CloseDocument();		
		
	}

}

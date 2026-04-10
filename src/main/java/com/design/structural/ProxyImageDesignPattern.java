package com.design.structural;

interface Image {
	void display();
}

class RealImage implements Image{
	
	public RealImage() {
		loadFromDisk();
	}
	
	private void loadFromDisk() {
		System.out.println("Loading From The Disk ");
	}
	
	@Override
	public void display() {
		System.out.println("Loading From Disk ");
	}
}

class ProxyImage implements Image{
	private Image image;
	
	@Override
	public void display() {
		if(image==null) {
			image=new RealImage();
		}
		image.display();
		
	}
}
public class ProxyImageDesignPattern {

	public static void main(String[] args) {
		Image object=new ProxyImage();
		object.display();
	}
}

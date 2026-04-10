package com.design.structural;

import java.util.HashMap;
import java.util.Map;

interface Icon {
	void draw(int x,int y);
}

class FileIcon implements Icon {
	private String type;
	private String imageName;
	
	public FileIcon(String type, String imageName) {
		super();
		this.type = type;
		this.imageName = imageName;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing :"+type+" icon at position :"+x+" "+y);
		
	}
}

class FolderIcon implements Icon {
	private String color;
	private String imageName;
	
	public FolderIcon(String type, String imageName) {
		super();
		this.color = type;
		this.imageName = imageName;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Color :"+color+" icon at position :"+x+" "+y);
		
	}
}

class IconFactory {
	Map<String,Icon> iconCache=new HashMap<>();
	
	public Icon getIcon(String key) {
		if(iconCache.containsKey(key)) {
			return iconCache.get(key);
		} else {
			Icon icon;
			if(key.equals("file")) {
				icon=new FileIcon("file", "document.png");
			}
			else if(key.equals("folder")) {
				icon=new FolderIcon("folder", "Folder file store");
			} else {
				 throw new IllegalArgumentException("Unsupported icon type: " + key);
			}
			iconCache.put(key, icon);
			return icon;
		}		
	}		
}

public class FlyweightDP_IconPattern {

	public static void main(String[] args) {
		IconFactory factory=new IconFactory();
		
		Icon icon1=factory.getIcon("file");
		icon1.draw(100, 150);
		icon1.draw(200, 300);
		
		Icon icon2=factory.getIcon("folder");
		icon2.draw(200, 300);
		icon2.draw(500, 400);
		

	}

}

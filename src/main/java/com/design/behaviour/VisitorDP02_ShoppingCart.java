package com.design.behaviour;
// Step 1: Define the Visitor interface
interface CartVisitor {
    double visit(Book book);
    double visit(Electronics electronics);
    double visit(Clothing clothing);
}

// Step 2: Define classes for different items in the cart
class Book {
    private double price;
    public double accept(CartVisitor visitor) {
        return visitor.visit(this);
    }
	public Book(double price) {
		super();
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

class Electronics {
    private double price;
    public double accept(CartVisitor visitor) {
        return visitor.visit(this);
    }
	
	public Electronics(double price) {
		super();
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
}

class Clothing {
	private double price;
	public double accept(CartVisitor visitor) {
		return visitor.visit(this);
	}
	public Clothing(double price) {
		super();
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}

// Step 3: Implement specific Visitor
class DiscountVisitor implements CartVisitor {
	
    @Override
    public double visit(Book book) {
        return book.getPrice() * 0.90; // 10% discount
    }

    @Override
    public double visit(Electronics electronics) {
        return electronics.getPrice() * 0.85; // 15% discount
    }

    @Override
    public double visit(Clothing clothing) {
        return clothing.getPrice() * 0.80; // 20% discount
    }
}

// Step 4: Using Visitor with different items
public class VisitorDP02_ShoppingCart {
    public static void main(String[] args) {
        Book book = new Book(30.0);
        Electronics electronics = new Electronics(100.0);
        Clothing clothing = new Clothing(50.0);

        CartVisitor discountVisitor = new DiscountVisitor();

        double totalDiscountedPrice = book.accept(discountVisitor)
                                + electronics.accept(discountVisitor)
                                + clothing.accept(discountVisitor);

        System.out.println("Total Price after discounts: " + totalDiscountedPrice);
    }
}

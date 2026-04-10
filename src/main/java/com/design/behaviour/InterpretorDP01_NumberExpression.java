package com.design.behaviour;

interface Expression {
	int interpret();
}

//Terminal Operation 
class NumberExpression implements Expression {
	private int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int interpret() {
		return number;
	}
}

//Non Terminal Expression
 class AdditionExpression implements Expression {
	private Expression leftExpression;
	private Expression rightExpression;

	public AdditionExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() + rightExpression.interpret();
	}
}

//Non Terminal Expression
class MultiplicationExpression implements Expression {
	private Expression leftExpression;
	private Expression rightExpression;

	public MultiplicationExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() * rightExpression.interpret();
	}
}

class SubtractionExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public SubtractionExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}


public class InterpretorDP01_NumberExpression {

	public static void main(String[] args) {
		
		Expression expr1 = new NumberExpression(2);
        Expression expr2 = new NumberExpression(3);
        Expression expr3 = new NumberExpression(1);
        
        Expression addition=new AdditionExpression(expr1, expr2);
        System.out.println("Addition the Number :"+addition.interpret());
        
        Expression multiExpression=new MultiplicationExpression(expr1, expr3);
        System.out.println("Multiplication of the Number is :"+multiExpression.interpret());
        
        Expression subtraction=new SubtractionExpression(expr1, expr2);
        System.out.println("Substraction of the Number is :"+subtraction.interpret());
        

	}

}

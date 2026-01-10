package weeklytask3;

import java.util.function.BiFunction;

public class LamdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiFunction<Integer, Integer, Double> power =(x,y) -> Math.pow(x, y);
		System.out.println("2^3 = " + Math.round(power.apply(2, 3)));

	}

}

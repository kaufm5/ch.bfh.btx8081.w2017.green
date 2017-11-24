package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

public interface ButtonView {
	public void setDisplay(double disp);
	
	interface CalculatorViewListener {
		void buttonClick(char operation);
	}
	
	public void addListener(CalculatorViewListener listener);

}

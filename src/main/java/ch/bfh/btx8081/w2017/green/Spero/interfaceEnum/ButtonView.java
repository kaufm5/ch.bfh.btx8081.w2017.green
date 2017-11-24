package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

public interface ButtonView {
//	public void setDisplay(double disp);
	
	interface ButtonClickListener {
		void buttonClick(char operation);
	}
	
	public void addListener(ButtonClickListener listener);

}

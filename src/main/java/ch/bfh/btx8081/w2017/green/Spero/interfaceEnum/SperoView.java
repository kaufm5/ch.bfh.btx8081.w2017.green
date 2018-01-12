package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.navigator.View;

/**
 * Interface class that have the following method 
 * 
 * @author mussi
 */
public interface SperoView extends View, SperoViewListener {

	/**
	 * This method is needed for adding listener in a view 
	 * @param listener
	 */
	public void addListener(SperoViewListener listener);


}

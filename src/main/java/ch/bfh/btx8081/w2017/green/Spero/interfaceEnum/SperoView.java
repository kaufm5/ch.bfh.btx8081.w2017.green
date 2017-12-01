package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickListener;

public interface SperoView extends View, ClickListener {
    // XXX: public void setDisplay(double disp);

    public void addListener(ClickListener listener);
}

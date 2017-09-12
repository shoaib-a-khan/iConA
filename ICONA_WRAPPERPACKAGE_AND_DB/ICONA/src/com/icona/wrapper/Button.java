package com.icona.wrapper;

//Mapping of UIButton API
public class Button extends Control {
	
	android.widget.Button currentButton;

	//+ (id) buttonWithType: (UIButtonType) buttonType
	public static Button buttonWithType(ButtonType buttonType)
	{
		Button b =new Button();
		return b;
	}
	
	//- (void) setTitle: (NSString *)title forState: (UIControlState) state
	public void setTitle_forState(String title, ControlState state)
	{
		
	}
}

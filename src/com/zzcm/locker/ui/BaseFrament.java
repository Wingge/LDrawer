package com.zzcm.locker.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * @ClassName:  BaseFrament
 * @Description 基Frament,继承定义父Activity
 * @author 钟荣观
 * @date 2014-11-13 下午2:10:46
 *
 * @param <T>
 */
public class BaseFrament<T extends Activity> extends Fragment {

	private T mActivity;
	protected View root;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity myActivity) {
		super.onAttach(myActivity);
		this.mActivity = (T) myActivity;
	}
	
	protected T getParentActivity(){
		return mActivity;
	}
	
	@SuppressWarnings("unchecked")
	protected final <V extends View> V getView (int id) {
		return (V) root.findViewById(id);
	}

}

package com.zzcm.locker.ui.util;

import android.os.Build;

public class SDKUtil {
	/**5*/
    public static final boolean IS_ECLAIR = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR;
    /**8*/
    public static final boolean IS_FROYO = Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    /**11*/
    public static final boolean IS_HONEYCOMB = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    /**14*/
    public static final boolean IS_ICE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    /**16*/
    public static final boolean IS_JB = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    /**19*/
    public static final boolean IS_KITKAT = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    /**21*/
    public static final boolean IS_L = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
}

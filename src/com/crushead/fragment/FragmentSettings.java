package com.crushead.fragment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.crushead.R;
import com.crushead.utils.Constant;

public class FragmentSettings extends PreferenceFragment{

	private static final boolean ALWAYS_SIMPLE_PREFS = false;
    private String TAG = getClass().getName();    
	private Preference version = null; 
	PackageInfo pinfo = null;
	CheckBoxPreference sonido = null;	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		getActivity().getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.setting));
		getActivity().getActionBar().setTitle("Configuración");
		try {
			pinfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString() + "Package");
			e.printStackTrace();
		}
		sonido = (CheckBoxPreference)findPreference("pref_sound");	
		
		String versionName = pinfo.versionName;
		version = findPreference("prefVersion");
		version.setSummary(versionName);			
		
		sonido.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object value) {
				// TODO Auto-generated method stub
				 if(value instanceof Boolean){
					 Boolean boolVal = (Boolean)value;
					 com.crushead.utils.Preference.putBoolean(Constant.KEY_SONIDO, boolVal, getActivity());	
				 }
				return true;
			}
		});				
	}
	
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	/** tablet 10" */
	/** {@inheritDoc} */
	public boolean onIsMultiPane() {
		return isXLargeTablet(getActivity()) && !isSimplePreferences(getActivity());
	}
	
	private static boolean isXLargeTablet(Context context) {
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
	}
	
	private static boolean isSimplePreferences(Context context) {
		return ALWAYS_SIMPLE_PREFS || Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB || !isXLargeTablet(context);
	}
		
}
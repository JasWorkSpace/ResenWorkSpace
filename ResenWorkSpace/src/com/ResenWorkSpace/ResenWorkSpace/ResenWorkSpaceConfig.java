package com.ResenWorkSpace.ResenWorkSpace;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResenWorkSpaceConfig {
    
	private final String DefaultWorkSpace = "ResenWorkSpace";
	private final String DefaultWorkSpaceCompany = "Copyright © 1989 - 2013 ResenWorkSpace.\nAll Rights Reserved.";
	private final String DefaultEmail     = "ResenWorkSpace@163.com";
	
	
	private boolean    LoadOK = false;
	private Properties props;
	private static ResenWorkSpaceConfig mJasWorkSpaceConfig = null;
	public  static ResenWorkSpaceConfig getInstance(){
		if(mJasWorkSpaceConfig == null){
			new ResenWorkSpaceConfig();
		}
		return mJasWorkSpaceConfig;
	}
	public ResenWorkSpaceConfig(){
		if(mJasWorkSpaceConfig != null)return;
		mJasWorkSpaceConfig = this;
		Load();
	}
	private void Load() {
		// TODO Auto-generated method stub
		try {
        	InputStream is = this.getClass().getResourceAsStream(
        			"/com/ResenWorkSpace/ResenWorkSpace/resenworkspaceconfig.properties");
        	if(is == null)return;
            props = new Properties();
			props.load(is);
			LoadOK = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	public String getWorkSpace(){
		return getString("WORKSPACE",DefaultWorkSpace);
	}
	
	public String getWorkSpaceCompany(){
		return getString("WORKSPACECOMPANY",DefaultWorkSpaceCompany);
	}
	
	public String getEmail(){
		return getString("EMAIL",DefaultEmail);
	}
	
	public boolean getDebugEn(){
		return getBoolean("DEBUG",false);
	}
	public boolean getLogEN(){
		return getBoolean("LOG",false);
	}
	//base Interface for prop
	private String  getString(String KEY,String Default){
		String workspace = getString(KEY);
		Log.d("Jas",""+LoadOK+" getString("+KEY+","+Default+") "+workspace);
		if(workspace == null)return Default;
		return workspace;
	}
	private boolean getBoolean(String KEY,boolean Default){
		String workspace = getString(KEY);
		Log.d("Jas",""+LoadOK+" getBoolean("+KEY+","+Default+") "+workspace);
		if(workspace==null)return Default;
		if("false".equalsIgnoreCase(workspace))return false;
		else if("true".equalsIgnoreCase(workspace))return true;
		return Default;
	}
	private String getString(String KEY){
		if(LoadOK){
			return props.getProperty(KEY).trim();
		}
		return null;
	}
	
}

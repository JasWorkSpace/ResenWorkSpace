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
        			"/com/Jasworkspace/Jasworkspace/senworkspaceconfig.properties");
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
		String workspace = null;
		if(LoadOK){
			workspace = props.getProperty("WorkSpace");
		}
		if(workspace == null || "".equals(workspace)){
			workspace = DefaultWorkSpace;
		}
		return workspace;
	}
	
	public String getWorkSpaceCompany(){
		String workspace = null;
		if(LoadOK){
			workspace = props.getProperty("WorkSpaceCompany");
		}
		if(workspace == null || "".equals(workspace)){
			workspace = DefaultWorkSpaceCompany;
		}
		return workspace;
	}
	
	public String getEmail(){
		String workspace = null;
		if(LoadOK){
			workspace = props.getProperty("Email");
		}
		if(workspace == null || "".equals(workspace)){
			workspace = DefaultEmail;
		}
		return workspace;
	}
	
	
}

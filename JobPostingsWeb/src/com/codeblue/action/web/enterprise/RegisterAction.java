package com.codeblue.action.web.enterprise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.codeblue.model.Enterprise;
import com.codeblue.model.property.EnterpriseAccountState;
import com.codeblue.model.property.EnterpriseProperty;
import com.codeblue.service.enterprise.Register;

public class RegisterAction extends BaseAction{
	private Enterprise enterprise;
	private File image;
	private String imageContentType;
	private String imageFileName;
	
	private String imagePath;//图片相对路径
	
	@Resource(name="ent_register")
	private Register register;
	
	private Map<String,Object> jsonMap=new HashMap<>();
	
	public String register() {
		if(enterprise==null||image==null){
			return "input";
		}
		try {
			imageUpload();
		    enterprise.setLogo(servletContext.getContextPath()+"/"+imagePath);
		    enterprise.setState(EnterpriseAccountState.AUDITING);
		    enterprise.setRegisterDate(new Date());
		    register.register(enterprise);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(register.getMsg().trim().equals("注册成功")){
			System.out.println(register.getMsg());
			return "success";
		}else {
			System.out.println(register.getMsg());
			return "error";
		}
		
		
	}
	
	public void imageUpload() throws Exception{
		/*System.out.println(image);
		System.out.println(image.length());
		System.out.println(imageContentType);
		System.out.println(imageFileName);*/
		
		UUID uuid=UUID.randomUUID();
		//文件名
		String imageName=uuid+imageFileName.substring(imageFileName.lastIndexOf("."));
		//相对路径
		imagePath="logo/"+imageName;
		//System.out.println(imagePath);
		
		//绝对路径
		String realImagePath=servletContext.getRealPath(imagePath);
		//System.out.println(realImagePath);
		//从缓存里面读取图片文件
		BufferedInputStream is=new BufferedInputStream(new FileInputStream(image));
		BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(realImagePath));
		IOUtils.copy(is, os);
		is.close();
		os.close();
	}
	
	

	
	
	public String checkIfExist(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String enterpriseAccount=request.getParameter("enterpriseAccount");
		register.checkIfExist(enterpriseAccount);
		jsonMap.clear();
		jsonMap.put("msg", register.getMsg());
		return "success";
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}





	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}





	public String getImageFileName() {
		return imageFileName;
	}





	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}





	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

}

package com.codeblue.service.impl.admin;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.springframework.stereotype.Service;

import com.codeblue.dao.AdministratorDAO;
import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.dao.StudentDAO;
import com.codeblue.dao.impl.EmployeementInfoDAOImpl;
import com.codeblue.model.Administrator;
import com.codeblue.model.EmployeementInfo;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Student;
import com.codeblue.model.property.EnterpriseAccountState;
import com.codeblue.model.property.EnterpriseProperty;
import com.codeblue.service.admin.AdministratorService;
import com.codeblue.util.PageBean;

@Service("administratorService")
public class AdministratorServiceImpl  implements AdministratorService{
	private AdministratorDAO administratorDAO;
	private EnterpriseDAO enterpriseDAO;
	private StudentDAO studentDAO;
	private EmployeementInfoDAOImpl employeementInfoDAO;
	public EmployeementInfoDAOImpl getEmployeementInfoDAO() {
		return employeementInfoDAO;
	}

	@Resource
	public void setEmployeementInfoDAO(EmployeementInfoDAOImpl employeementInfoDAO) {
		this.employeementInfoDAO = employeementInfoDAO;
	}

	@Override
	public boolean isValidAdmin(String loginAdminAccount, String loginAdminPasswd) {

		Administrator admin=administratorDAO.getAdministratorDAO(loginAdminAccount);
		if(admin==null){
			return false;
		}else {
			if(admin.getPassword().equals(loginAdminPasswd)){
				return true;
			}else {
				return false;
			}
		}
	}

	public boolean modifyPasswd(String loginAdminAccount,String newPasswd){
		
		return false;
	}
	
	public PageBean querySingUpEnterprise(Integer[] states,int page,int rows){
		java.util.List<Enterprise> list=enterpriseDAO.queryAll(states, (page-1)*rows, rows);
		long allRow=enterpriseDAO.getCount(states);
		PageBean pageBean=new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(rows);
		pageBean.setCurrentPage(page);
		pageBean.init();
		return pageBean;
	}
	
	public Map<String,Object> convertEnterpriseInfoToMap(PageBean pagebean){
		Map<String, Object> jsonMap=new HashMap();
		
		jsonMap.put("total", pagebean.getAllRow());
		java.util.List<Enterprise> enterprises=pagebean.getList();
		java.util.List<Map> tempList=new ArrayList<>();
		for (Enterprise enterprise : enterprises) {
			Map<String,Object> tempMap=new HashMap<>();
			
			tempMap.put("enterpriseAccount",enterprise.getEnterpriseAccount());
			tempMap.put("enterpriseName", enterprise.getEnterpriseName());
			tempMap.put("bussinessLicenseId",enterprise.getBusinessLicenseId());
			tempMap.put("foundDate",dateConvert(enterprise.getFoundDate()));
			tempMap.put("enterpriseProperty", enterprise.getEnterpriseProperty());
			tempMap.put("enterpriseScale",enterprise.getEnterpriseScale());
			tempMap.put("registeredFund",enterprise.getRegisteredFund());
			tempMap.put("address", enterprise.getAddress());
			tempMap.put("linkman",enterprise.getLinkman());
			tempMap.put("phone",enterprise.getPhone());
			tempMap.put("brief",enterprise.getBrief());
			tempList.add(tempMap);
		}
		
		jsonMap.put("rows", tempList);
		return jsonMap;
	}
	
	@Override
	public PageBean queryAllStudent(Integer[] states, int page, int rows) {
//		java.util.List<Enterprise> list=enterpriseDAO.queryAll(states, (page-1)*rows, rows);
//		long allRow=enterpriseDAO.getCount(states);
//		PageBean pageBean=new PageBean();
//		pageBean.setList(list);
//		pageBean.setAllRow(allRow);
//		pageBean.setPageSize(rows);
//		pageBean.setCurrentPage(page);
//		pageBean.init();
//		return pageBean;
		//List<Student> list=studentDAO.queryAll(states,(page-1)*rows,rows);
		//error
		List<Student> list= studentDAO.queryByDepartment(1, (page-1)*rows, rows);
		long allRow=studentDAO.getCountByDepartment(1);
		PageBean pageBean=new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(rows);
		pageBean.setCurrentPage(page);
		pageBean.init();
		return pageBean;
	};
	
	@Override
	public java.util.Map<String,Object> convertStudentInfoToMap(PageBean pagebean) {


			Map<String, Object> jsonMap=new HashMap<>();
			jsonMap.put("total", pagebean.getAllRow());
			List<Student> students=pagebean.getList();
			List<Map> tempList=new ArrayList<>();
			for (Student student : students) {
				Map<String, Object> tempMap=new HashMap<>();
				
				tempMap.put("studentId", student.getStudentId());
				tempMap.put("name", student.getName());
				tempMap.put("sex", student.getSex());
				tempMap.put("birthday", dateConvert(student.getBirthday()));
				tempMap.put("nation", student.getNation());
				tempMap.put("degree", student.getDegree());
				tempMap.put("telephone", student.getTelephone());
				tempMap.put("idNum", student.getIdNum());
				tempMap.put("graduationDate", dateConvert(student.getGraduationDate()));
				tempMap.put("gpa", student.getGpa());
				tempMap.put("className", student.getSchoolClass().getClassName());
				tempMap.put("grade", student.getSchoolClass().getGrade());
				tempMap.put("major", student.getSchoolClass().getMajor().getMajorName());
				tempList.add(tempMap);
			}
		jsonMap.put("rows", tempList);
		return jsonMap;
	};
	
	
	public String dateConvert (Date date) {
		return DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);	
	}

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}
	@Resource
	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	@Resource
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Resource
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	@Override
	public boolean postNews(String news,String title,String account) {
		
		EmployeementInfo employeementInfo=new EmployeementInfo();
		employeementInfo.setTitle(title);
		Administrator administrator=new Administrator();
		administrator.setAccount(account);
		employeementInfo.setAdministrator(administrator);
		employeementInfo.setInfo(news);
		Date date=new Date();
		employeementInfo.setReleaseDate(date);
		employeementInfoDAO.insert(employeementInfo);
		return true;
	}
	
	public boolean verifyEnterprisePass(String enterpriseId){
		
		//enterpriseDAO.update(null);
		
		Enterprise enterprise=enterpriseDAO.getEnterpriseByAccount(enterpriseId.trim());
		enterprise.setState(EnterpriseAccountState.PASS);
		this.enterpriseDAO.update(enterprise);
		return true;
	}
	
	public boolean verifyEnterpriseUnPass(String enterpriseId){
		Enterprise enterprise=enterpriseDAO.getEnterpriseByAccount(enterpriseId.trim());
		enterprise.setState(EnterpriseAccountState.UNPASS);
		this.enterpriseDAO.update(enterprise);
		return true;
	}
}

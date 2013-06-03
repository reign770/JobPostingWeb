package com.codeblue.service.impl.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.EmployeementInfoDAO;
import com.codeblue.model.EmployeementInfo;
import com.codeblue.service.enterprise.EmployeementInfoService;
import com.codeblue.util.PageBean;
@Service("ent_employeementInfoService")
public class EmployeementInfoServiceImpl implements EmployeementInfoService {
	@Resource(name="employeementInfoDAO")
	private EmployeementInfoDAO employeementInfoDAO;
	
	@Override
	public PageBean getEmployeementInfos(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<EmployeementInfo> list= employeementInfoDAO.getAll( (pageNum-1)*pageSize,pageSize);
		long allRow = employeementInfoDAO.getCount();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

}

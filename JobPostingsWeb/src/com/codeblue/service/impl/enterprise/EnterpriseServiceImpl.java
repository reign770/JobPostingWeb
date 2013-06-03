package com.codeblue.service.impl.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Student;
import com.codeblue.service.enterprise.EnterpriseService;
import com.codeblue.util.PageBean;
@Service("ent_enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {
	@Resource(name="enterpriseDAO")
	private EnterpriseDAO enterpriseDAO;

	@Override
	public Enterprise queryEnterprise(int enterpriseId) {
		// TODO Auto-generated method stub
		return enterpriseDAO.getByEnterpriseId(enterpriseId);
	}

	@Override
	public void updateEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		enterpriseDAO.update(enterprise);
	}

	@Override
	public PageBean queryEnterprises(Integer[] states,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<Enterprise> enterprises=enterpriseDAO.queryAll(states,(pageNum-1)*pageSize, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.setList(enterprises);
		pageBean.setAllRow(enterpriseDAO.getCount(states));
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

}

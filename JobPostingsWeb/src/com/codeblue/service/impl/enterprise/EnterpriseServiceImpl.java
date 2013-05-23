package com.codeblue.service.impl.enterprise;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.service.enterprise.EnterpriseService;
@Service("ent_enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {
	@Resource(name="ent_enterpriseDAO")
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

}

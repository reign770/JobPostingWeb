package com.codeblue.service.impl.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.EvaluationDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.service.enterprise.EvaluationService;
import com.codeblue.util.PageBean;
@Service("ent_evaluationService")
public class EvaluationServiceImpl implements EvaluationService {
	
	private EvaluationDAO evaluationDAO;

	@Override
	public PageBean queryEvaluationsOfCompany(int enterpriseId, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		List<Evaluation> list= evaluationDAO.queryByEnterpriseId(enterpriseId, (pageNum-1)*pageSize,pageSize);
		long allRow = evaluationDAO.getCountByEnterpriseId(enterpriseId);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}
	@Resource
	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}
	
	

}

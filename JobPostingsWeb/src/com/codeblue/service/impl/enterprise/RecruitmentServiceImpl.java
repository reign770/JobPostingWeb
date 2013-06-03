package com.codeblue.service.impl.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.RecruitmentDAO;
import com.codeblue.model.JobApplication;
import com.codeblue.model.Recruitment;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.util.PageBean;
@Service("ent_recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
	@Resource(name="recruitmentDAO")
	private RecruitmentDAO recruitmentDAO;

	@Override
	public Recruitment queryRecruitment(int recruitmentId) {
		// TODO Auto-generated method stub
		return recruitmentDAO.getByRecruitmentId(recruitmentId);
	}

	@Override
	public PageBean queryRecruitmentsOfCompany(int enterpriseId,Integer[] states, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		List<Recruitment> list= recruitmentDAO.queryByEnterpriseId(enterpriseId, states, (pageNum-1)*pageSize,pageSize);
		long allRow = recruitmentDAO.getCountByEnterpriseId(enterpriseId, states);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

	@Override
	public int insertRecruitment(Recruitment recruitment) {
		// TODO Auto-generated method stub
		return recruitmentDAO.insert(recruitment);
	}

	@Override
	public void updateRecruitment(Recruitment recruitment) {
		// TODO Auto-generated method stub
		recruitmentDAO.update(recruitment);
	}

	

}

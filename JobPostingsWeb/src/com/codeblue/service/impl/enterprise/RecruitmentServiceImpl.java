package com.codeblue.service.impl.enterprise;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.model.Recruitment;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.util.PageBean;
@Service("ent_recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {


	@Override
	public PageBean queryRecruitmentsOfCompany(int enterpriseId, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRecruitment(Recruitment recruitment) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateRecruitment(Recruitment recruitment) {
		// TODO Auto-generated method stub
	}

}

package com.codeblue.service.impl.enterprise;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.JobInvitationDAO;
import com.codeblue.model.JobInvitation;
import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;
import com.codeblue.model.property.JobInvitationState;
import com.codeblue.service.enterprise.JobInvitationService;
@Service("ent_jobInvitationService")
public class JobInvitationServiceImpl implements JobInvitationService {
	@Resource(name="jobInvitationDAO")
	private JobInvitationDAO jobInvitationDAO;

	@Override
	public void addJobInvitation(String[] studentIds,int recruitmentId) {
		// TODO Auto-generated method stub
		for (String studentId : studentIds) {
			Student student=new Student();
			student.setStudentId(studentId);
			Recruitment recruitment=new Recruitment();
			recruitment.setRecruitmentId(recruitmentId);
			JobInvitation jobInvitation=new JobInvitation();
			jobInvitation.setInvitationDate(new Date());
			jobInvitation.setContent("邀请您~~");
			jobInvitation.setRecruitment(recruitment);
			jobInvitation.setState(JobInvitationState.UNPROCESS);
			jobInvitation.setStudent(student);
			jobInvitationDAO.insert(jobInvitation);
		}
		
	}

}

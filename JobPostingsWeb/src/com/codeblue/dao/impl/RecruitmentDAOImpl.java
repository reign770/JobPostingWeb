package com.codeblue.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.JoinType;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.RecruitmentDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;
import com.sun.org.apache.regexp.internal.recompile;

@Repository("recruitmentDAO")
public class RecruitmentDAOImpl implements RecruitmentDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Recruitment getByRecruitmentId(int recruitmentId) {
		return (Recruitment) hibernateTemplate.get(Recruitment.class, recruitmentId);
	}

	@Override
	public int insert(Recruitment recruitment) {
		hibernateTemplate.save(recruitment);
		return recruitment.getRecruitmentId();
	}

	@Override
	public void update(Recruitment recruitment) {
		hibernateTemplate.update(recruitment);
	}

	@Override
	public void delete(int recruitmentId) {
		Recruitment recruitment = new Recruitment();
		recruitment.setRecruitmentId(recruitmentId);
		hibernateTemplate.delete(recruitment);
	}

	@Override
	public List<Recruitment> queryByIndustry(int industryId, int offset,
			int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Recruitment.class);
		detachedCriteria.add(Property.forName("industry.industryId").eq(industryId))
						.add(Property.forName("state").eq(1))
						.addOrder(Order.desc("releaseDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByIndustry(int industryId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Recruitment.class);
		detachedCriteria.setProjection(Projections.rowCount())
						.add(Property.forName("industry.industryId").eq(industryId))
						.add(Property.forName("state").eq(1));

		return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	@Override
	public List<Recruitment> queryByEnterpriseId(int enterpriseId,Integer[] states, int offset,
			int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Recruitment.class);
		detachedCriteria.add(Property.forName("enterprise.enterpriseId").eq(enterpriseId))
						.add(Property.forName("state").in(states))
						.addOrder(Order.desc("releaseDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByEnterpriseId(int enterpriseId,Integer[] states) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Recruitment.class);
		detachedCriteria.setProjection(Projections.rowCount())
						.add(Property.forName("enterprise.enterpriseId").eq(enterpriseId))
						.add(Property.forName("state").in(states));
		return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	@Override
	public List<Recruitment> queryByStudentId(String studentId, int offset,
			int pageSize) {
		DetachedCriteria subDetachedCriteria = DetachedCriteria
											   .forClass(Student.class,"s")
											   .setProjection(Projections.property("c.enterpriseId"))
											   .createAlias("s.concernEnterprises", "c")
											   .add(Property.forName("s.studentId").eq(studentId));						
		
		DetachedCriteria detachedCriteria = DetachedCriteria
				        .forClass(Recruitment.class,"r")
				        .add(Property.forName("r.state").eq(1))
				        .createAlias("r.enterprise", "e")
				        .add(Subqueries.propertyIn("e.enterpriseId", subDetachedCriteria))
				        .addOrder(Order.desc("r.releaseDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria, offset, pageSize);
	}

	@Override
	public long getCountByStudentId(String studentId) {
		DetachedCriteria subDetachedCriteria = DetachedCriteria
				   .forClass(Student.class,"s")
				   .add(Property.forName("r.state").eq(1))
				   .setProjection(Projections.property("c.enterpriseId"))
				   .createAlias("s.concernEnterprises", "c")
				   .add(Property.forName("s.studentId").eq(studentId));						

		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Recruitment.class,"r")
		.setProjection(Projections.rowCount())
		.createAlias("r.enterprise", "e")
		.add(Subqueries.propertyIn("e.enterpriseId", subDetachedCriteria))
		.addOrder(Order.desc("r.releaseDate"));
		return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	@Override
	public List<Recruitment> queryByAddition(String queryWord,
			String postingName, String workingPlace, Integer salary, 
			String enterpriseProperty,Integer industryId,int offset,int pageSize) {
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(Recruitment.class,"r")
				.add(Property.forName("r.state").eq(1))
				.createCriteria("r.enterprise", "e")
				.addOrder(Order.desc("r.releaseDate"));
		if(queryWord != null && !queryWord.equals(""))
			detachedCriteria
			.add(Restrictions.or(
					Restrictions.like("e.enterpriseName", queryWord,MatchMode.ANYWHERE), 
					Restrictions.like("r.postingName", queryWord, MatchMode.ANYWHERE)))
			;
		if(postingName !=null && !postingName.equals(""))
			detachedCriteria
			.add(Restrictions.like("r.postingName", postingName,MatchMode.ANYWHERE));
		
		if(workingPlace != null && !workingPlace.equals(""))
			detachedCriteria
			.add(Restrictions.eq("r.workingPlace", workingPlace));
		
		if(salary != null) {
			if(salary == -1) {
				detachedCriteria.add(Restrictions.eq("r.salary", -1));
			}
			else {
				detachedCriteria.add(Restrictions.ge("r.salary", salary));
				detachedCriteria.addOrder(Order.desc("r.salary"));
			}
		}
		
		if(enterpriseProperty != null && !enterpriseProperty.equals("")) {
			detachedCriteria.add(Restrictions.eq("e.enterpriseProperty", enterpriseProperty));
		}
		
		if(industryId !=null && industryId >=1){
			detachedCriteria = detachedCriteria
					.createAlias("r.industry", "i")
					.add(Property.forName("i.industryId").eq(industryId));
		}
		return hibernateTemplate.findByCriteria(detachedCriteria, offset, pageSize);
	}

	@Override
	public long getCountByAddition(String queryWord, String postingName,
			String workingPlace, Integer salary,String enterpriseProperty,Integer industryId) {
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(Recruitment.class,"r")
				.add(Property.forName("r.state").eq(1))
				.createCriteria("r.enterprise", "e")
				.setProjection(Projections.rowCount());
		if(queryWord != null && !queryWord.equals(""))
			detachedCriteria
			.add(Restrictions.or(
					Restrictions.like("e.enterpriseName", queryWord,MatchMode.ANYWHERE), 
					Restrictions.like("r.postingName", queryWord, MatchMode.ANYWHERE)))
			;
		
		if(postingName !=null && !postingName.equals(""))
			detachedCriteria
			.add(Restrictions.like("r.postingName", postingName,MatchMode.ANYWHERE));
		
		if(workingPlace != null && !workingPlace.equals(""))
			detachedCriteria
			.add(Restrictions.eq("r.workingPlace", workingPlace));
		
		if(salary != null) {
			if(salary == -1) {
				detachedCriteria.add(Restrictions.eq("r.salary", -1));
			}
			else {
				detachedCriteria.add(Restrictions.ge("r.salary", salary));
				detachedCriteria.addOrder(Order.desc("r.salary"));
			}
		}
		
		if(enterpriseProperty != null && !enterpriseProperty.equals("")) {
			detachedCriteria.add(Restrictions.eq("e.enterpriseProperty", enterpriseProperty));
		}
		if(industryId !=null && industryId >=1){
			detachedCriteria = detachedCriteria
					.createAlias("r.industry", "i")
					.add(Property.forName("i.industryId").eq(industryId));
		}
		return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}

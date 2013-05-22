package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.Student;

public interface StudentDAO {
	
	/**
	 * 添加学生
	 * @param student
	 */
	public void insert(Student student);
	/**
	 * 更新学生的信息
	 * @param student
	 */
	public void update(Student student);
	/**
	 * 删除学生
	 * @param studentId
	 */
	public void delete(String studentId);
	/**
	 * 根据学生学号获取学生信息
	 * @param student
	 * @return
	 */
	public Student getByStudentId(String studentId);
	
	/**
	 * 根据就业意向获取学生
	 * @param industryId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Student> queryByJobIntention(int industryId,int offset,int pageSize);
	/**
	 * 根据就业意向获取学生的总数
	 * @param indusrtyId
	 * @return
	 */
	public long getCountByJobIntention(int indusrtyId);
    /**
     * 根据学院获取学生信息
     * @param departmentId
     * @param offset
     * @param pageSize
     * @return
     */
	public List<Student> queryByDepartment(int departmentId,int offset,int pageSize);
	/**
	 * 获取一个学院的总数
	 * @param departmentId
	 * @return
	 */
	public long getCountByDepartment(int departmentId);
	/**
	 * 获取一个专业的学生
	 * @param majorId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Student> queryByMajor(int majorId,int offset,int pageSize);
	/**
	 * 获取一个专业的学生的总数
	 * @param majorId
	 * @return
	 */
	public long getCountByMajor(int majorId);
	/**
	 * 获取一个班级的学生
	 * @param classId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Student> queryByClass(int classId,int offset,int pageSize);
	/**
	 * 获取一个班级的学生的总数
	 * @param classId
	 * @return
	 */
	public long getCountByClass(int classId);
}

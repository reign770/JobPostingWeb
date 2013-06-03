package com.codeblue.service.enterprise;

import com.codeblue.util.PageBean;

public interface StudentService {
  public PageBean queryStudentsOfAClass(int classId, int pageNum, int pageSize);
  
  public PageBean queryRecommandStudentsByJobIntention(int industryId,int pageNum,int pageSize);
  
}

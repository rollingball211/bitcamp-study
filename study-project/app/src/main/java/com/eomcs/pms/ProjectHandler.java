package com.eomcs.pms;

import java.sql.Date;

public class ProjectHandler {

  static class Project {
    int no;
    String title;
    String content;
    Date startDate;
    Date endDate;
    String owner;
    String members;  
  }

  static final int LENGTH = 100;
  static Project[] projects = new Project[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[프로젝트 등록]");

    Project p = new Project();
    p.no = Prompt.inputInt("번호? ");
    p.title = Prompt.inputString("프로젝트명? ");
    p.content = Prompt.inputString("내용? ");
    p.startDate = Prompt.inputDate("시작일? ");
    p.endDate = Prompt.inputDate("종료일? ");
    while(true) {
    p.owner = Prompt.inputString("만든이? ");
    if(/*만든이가 회원이 아니라면 */ 
        MemberHandler.exist(p.owner)) {
      System.out.println("등록된 회원이 아닙니다.");
    }else {
      break;
    }
    }
    p.members = Prompt.inputString("팀원? ");

    projects[size++] = p;
  }

  static void list() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < size; i++) {
      Project p = projects[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          p.no, p.title, p.startDate, p.endDate, p.owner);
    }
  }

}

/*
 * Copyright (c) 2006-2007 Massachusetts General Hospital 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the i2b2 Software License v1.0 
 * which accompanies this distribution. 
 * 
 * Contributors:
 * 		Kavishwar Wagholikar (kavi)
 * 		July 4, 2015
 */



import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

//Hibernate JPA With H2 Example
//http://www.javatips.net/blog/2012/12/java-persistence-jpa-2-0-tutorial-with-hibernate

public class JPAExample {

  private EntityManager entityManager = EntityManagerUtil.getEntityManager();

  public static void main(String[] args) {
    JPAExample example = new JPAExample();
    System.out.println("After Sucessfully insertion ");
    Student student1 = example.saveStudent("Sumith");
    Student student2 = example.saveStudent("Anoop");
    example.listStudent();
    System.out.println("After Sucessfully modification ");
    example.updateStudent(student1.getStudentId(), "Sumith Honai");
    example.updateStudent(student2.getStudentId(), "Anoop Pavanai");
    example.listStudent();
    System.out.println("After Sucessfully deletion ");
    //example.deleteStudent(student2.getStudentId());
    example.listStudent();
   

  }

  public Student saveStudent(String studentName) {
    Student student = new Student();
    try {
      entityManager.getTransaction().begin();
      student.setStudentName(studentName);
      student = entityManager.merge(student);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
    return student;
  }

  public void listStudent() {
    try {
      entityManager.getTransaction().begin();
      @SuppressWarnings("unchecked")
      List<Student> Students = entityManager.createQuery("from Student").getResultList();
      for (Iterator<Student> iterator = Students.iterator(); iterator.hasNext();) {
        Student student = (Student) iterator.next();
        System.out.println(student.getStudentName());
      }
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  public void updateStudent(Long studentId, String studentName) {
    try {
      entityManager.getTransaction().begin();
      Student student = (Student) entityManager.find(Student.class, studentId);
      student.setStudentName(studentName);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  public void deleteStudent(Long studentId) {
    try {
      entityManager.getTransaction().begin();
      Student student = (Student) entityManager.find(Student.class, studentId);
      entityManager.remove(student);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }
}
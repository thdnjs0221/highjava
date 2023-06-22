package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
    이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
    초기화 처리를 한다.
    
    이 Student객체는 List에 저장하여 관리한다.

  List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
    총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 
    클래스를 작성하여 정렬된 결과를 출력하시오.

    (단, 등수는 List에 전체 데이터가 추가된 후에 구해서 저장되도록 한다.)

 */

public class StudentTest {
	//static x 인스턴스메소드 객체 생성하는
	//등수를 구하는 메서드
	public void createRank(List<Student>list) {
		for(Student std1:list) { //기준 데이터를 구하기 위한 반복문
			int rank=1;  //처음에는 1등으로 설정해 놓고 시작한다.
			
			for(Student std2:list) { //비교 대상을 나타내는 반복문
				if(std1.gettotal() < std2.gettotal()) { //기준값보다 대상값이 크면
					rank++;  //rank값 증가
				}
			}
			std1.setrank(rank); //구해진 등수를 Student객체의 rank변수에 저장한다
		}
	}
	

	public static void main(String[] args) {
		      List<Student>sList=new ArrayList<Student>(); //List는 조상이라 사용가능
		      sList.add(new Student(1,"홍길동",90,95,80));
		      sList.add(new Student(3,"김길동",90,75,70));
		      sList.add(new Student(7,"강감찬",95,95,80));
		      sList.add(new Student(5,"변학도",80,95,90));
		      sList.add(new Student(2,"일지매",100,85,80));
		      sList.add(new Student(4,"이순신",60,65,70));
		      sList.add(new Student(6,"이몽룡",90,100,90));
		      
	     
		      StudentTest stdTest=new StudentTest();
		      stdTest.createRank(sList);
		      
		      System.out.println("정렬전...");
		      for(Student std:sList) {
		         System.out.println(std);
		         
		      }
		      System.out.println("------------------------------------------------------");
		      
		      //학번의 오름차순 정렬하기
		      Collections.sort(sList);
		      
		      System.out.println("학번의 오름차순 정렬후");
		      for(Student stu:sList) {
		         System.out.println(stu);
		      }
		      System.out.println("--------------------------------------------------------");
		      
		    
		      Collections.sort(sList,new SortByTotal() );
		      
		      System.out.println("총점의 내림차순 정렬후");
		      for(Student stu:sList) {
		         System.out.println(stu);
		      }
		      System.out.println("-------------------------------------------------------");
		      }
		   }





		
		class Student implements Comparable<Student>{
		   private int num; 
		   private String name;
		   private int korean ;
		   private int english;
		   private int math;
		   private int total;
		   private int rank;
		   
		   public Student (int num, String name, int korean, int english, int math) {
		      this.num=num;
		      this.name=name;
		      this.korean=korean;
		      this.english=english;
		      this.math=math;
		      this.total=korean+english+math;
		      
		   }

		   
	


		public int getNum() {
		      return num;
		   }


		   public void setNum(int num) {
		      this.num = num;
		   }


		   public String getName() {
		      return name;
		   }


		   public void setName(String name) {
		      this.name = name;
		   }


		   public int getKorean() {
		      return korean;
		   }


		   public void setKorean(int korean) {
		      this.korean = korean;
		   }


		   public int getEnglish() {
		      return english;
		   }

		   public void setEnglish(int english) {
		      this.english = english;
		   }


		   public int getMath() {
		      return math;
		   }

		   public void setMath(int math) {
		      this.math = math;
		   }

		   public int gettotal() {
		      return total;
		   }

		   public void settotal(int total) {
		      this.total = total;
		   }
		   public int getrank() {
			      return rank;
			   }

			   public void setrank(int rank) {
			      this.rank = rank;
			   }


	    @Override
			public String toString() {
				return "Student [num=" + num + ", name=" + name + ", korean=" + korean + ", english=" + english
						+ ", math=" + math + ", total=" + total + ", rank=" + rank + "]";
			}

		@Override
		   public int compareTo(Student st) {
		      return Integer.compare(this.num, st.getNum());

		}
		}
		//총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준
		
		class SortByTotal implements Comparator<Student>{

			@Override
			public int compare(Student std1, Student std2) {
				if(std1.gettotal()==std2.gettotal()) {
					return std1.getName().compareTo(std2.getName());
				}else {
					return Integer.compare(std1.gettotal(),std2.gettotal())*-1;
				}
				
			}
			
		}
	



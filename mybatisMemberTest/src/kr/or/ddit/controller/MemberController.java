package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;



public class MemberController {
	private Scanner scan; 
	private IMemberService service; //Service객체가 저장될 변수 선언
	
	//생성자
	public MemberController() {
		scan = new Scanner(System.in);
	//	service= new MemberServiceImpl();
		service= MemberServiceImpl.getInstance();
		
	}

	public static void main(String[] args) {
		new MemberController().startMember();

	}
	public void startMember() {
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				insertMember();
				break;
			case 2:
				deleteMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				displayAllMember();
				break;
				//-------------------
			case 5:
				updateMember2();
				break;
			case 0:
				System.out.println("작업을 마칩니다");
				return;
			default:
				break;
			}
		}
	}
	//회원 정보 수정2-원하는 항목 수정
	private void updateMember2() {
		
		 System.out.println();
	      System.out.println("수정할 회원 정보를 입력하세요...");
	      System.out.print("회원ID >> ");
	      String memId = scan.next();
	      
	      int count = service.getMemberCount(memId);
	      if(count==0) {
	         System.out.println(memId + "은(는) 없는 회원ID 입니다...");
	         System.out.println("수정 작업을 종료합니다...");
	          return;
	      }
	      
	      int num;   //수정할 항목 번호가 저장될 변수
	      String updateField = null;   //수정할 컬럼명이 저장될 변수
	      String updateTitle = null;   //변경할 데이터를 입력할 때 출력할 메시지가 저장될 변수
	      do {
	         System.out.println();
	         System.out.println("수정할 항목을 선택하세요...");
	         System.out.println("1.비밀번호   2.회원이름   3.전화번호   4.회원주소");
	         System.out.println("-------------------------------------");
	         System.out.print("수정 항목 선택 >> ");
	         num = scan.nextInt();
	         
	         switch(num) {
	         case 1 : updateField = "mem_pass"; updateTitle = "비밀번호"; break;
	         case 2 : updateField = "mem_name"; updateTitle = "회원이름"; break;
	         case 3 : updateField = "mem_tel"; updateTitle = "전화번호"; break;
	         case 4 : updateField = "mem_addr"; updateTitle = "회원주소"; break;
	         default : System.out.println("수정 항목을 잘못 선택했습니다...");
	               System.out.println("다시 선택하세요...");
	         }
	      }while(num<1 || num>4);
	      
	      scan.nextLine();
	      System.out.println();
	      System.out.print("새로운 "+updateTitle + " >> ");
	      String updateData =scan.nextLine();
	
	      //수정할 정보를 Map에 추가한다
	      //( Key값 정보==> 회원 ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)  )
	      Map<String, String>paramMap= new HashMap<>(); //Map 객체 샛성
	      
	      paramMap.put("memid", memId);
	      paramMap.put("field", updateField);
	      paramMap.put("data", updateData);
	      
	      int cnt= service.updateMember2(paramMap);
	      
	      if(cnt>0) {
	            System.out.println("수정 완료!!!");
	         }else {
	            System.out.println("수정 실패!!!");
	         }
	         
	}
	
	//전체 회원 출력
	private void displayAllMember() {
		System.out.println();
		
		//Servie객체를 통해서 전체 회원 목록을 가져온다 
		List<MemberVO >memList=service.getALlMember();
		
		System.out.println();
		System.out.println("=========================================");
		System.out.println("ID      이름          비밀번호        전화번호      주소");
		System.out.println("=========================================");
		
		if(memList==null || memList.size()==0) {
			System.out.println("등록된 회원 정보가 하나도 없습니다...");
		}else {
			//List에 저장된 데이터 개수만큼 반복해서 데이터를 출력한다
			for(MemberVO memVO: memList) {
				
				String id = memVO.getMem_id();
				String name = memVO.getMem_name();
				String pw = memVO.getMem_pass();
				String tel = memVO.getMem_tel();
				String addr = memVO.getMem_addr();
				
				System.out.println(id + "\t" + name + "\t" + pw + "\t" + tel + "\t" + addr);
				
			}
		}
		System.out.println("=========================================");
	}
	

	//회원 삭제 
	private void deleteMember() {
		System.out.println("");
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.println("회원 아이디: ");
		String memId = scan.next();
		
		int cnt= service.deleteMember(memId);
		
		if(cnt>0) {
			System.out.println(memId+"회원정보 삭제 성공!!");
		}else{
			System.out.println(memId+"회원정보 삭제  실패");
		}
		
	}
	
	//회원 수정 -전체 항목
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보 입력");
		System.out.println("회원 아이디: ");
		String memId = scan.next();
		
		int count = service.getMemberCount(memId);
		//회원 아이디 개수가 나옴
		
		if(count==0) {//없는 회원이면..
			System.out.println(memId+"는 없는 회원 아이디 입니다");
			return;
		}
		
		System.out.println("회원 비밀번호 ");
		String newMemPw = scan.next();
		
		System.out.println("회원 이름");
		String newMemName = scan.next();
		
		System.out.println("회원 전화번호 ");
		String newMemTel = scan.next();
		
		
		scan.nextLine();//버퍼비우기
		System.out.println("주소 ");
		String newMemAddr = scan.nextLine();
		
		//수정할 데이터를 VO객체에 저장한다.
		MemberVO memVo= new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newMemPw);
		memVo.setMem_name(newMemName);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);
		
		int cnt= service.updateMember(memVo);
		
		if(cnt>0) {
			System.out.println("수정 완료");
		}else {
			System.out.println("수정 실패");
		}

	}
	
	
	//회원 추가 
	private void insertMember() {
		int count;
		String memId = null;// 회원아이디가 저장될 변수
		do {

			System.out.println("회원 아이디>>");
			memId = scan.next();
			count = service.getMemberCount(memId);

			if (count > 0) {

				System.out.println(memId + "는 이미 등록된 회원입니다.");
				System.out.println("다른 회원 아이디를 입력하세요...");
				System.out.println();
			}

		} while (count > 0);

		System.out.println(" 비밀번호>> ");
		String memPw = scan.next();

		System.out.println("회원 이름>>");
		String memName = scan.next();

		System.out.println("전화번호 >>");
		String memTel = scan.next();

		scan.nextLine();
		System.out.println("주소 >>");
		String memAddr = scan.nextLine();
		
		//입력 받은 insert할 데이터를 VO객체에 저장한다.
		MemberVO memVo= new MemberVO();
		
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPw);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		//Service의 insert하는 메서드를 호출한다. 이때 insert할 데이터를 인수값으로 넣어준다
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println(memId+"회원정보 insert 성공");
		}else{
			System.out.println(memId+"회원정보 insert 실패");
		}
	}
	
	
	
	//메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	public int displayMenu() {
		System.out.println("");
		System.out.println("==============");
		System.out.println("1.자료추가");
		System.out.println("2.자료삭제");
		System.out.println("3.자료수정");
		System.out.println("4.전체자료출력");
		System.out.println("5.자료 수정 (2)");
		System.out.println("0.작업끝");
		System.out.println("==============");
		return scan.nextInt();

	}

}

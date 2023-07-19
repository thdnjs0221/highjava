package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class LprodMybatisTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 1. myBatis의 환경 설정 파일을 읽어와서 실행한다(mybatis-config.xml)
		Reader rd = null; // 스트림 객체 변수 선언
		SqlSessionFactory sqlSessionFactory = null; // myBatis 실행용 객체를 생성할 객체 변수 선언
		try {
			// 1-1. 환경 설정 파일을 읽어올 스트림 객체 생성
			rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");

			// 1-2 환경 설정 파일을 읽어와 환경 설정을 완성한 후 sql문을 호출해서 실행할 수 있는
			// 객체를 생성하는 SqlSessionFactory객체를 생성한다
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);

		} catch (Exception e) {
			System.out.println("초기화 실패 ");
			e.printStackTrace();
		} finally {
			if (rd != null)
				try {
					rd.close();
				} catch (IOException e) {
				}
		}
		// -----------------------------------------------------------------------

		// 2. mapper에 등록된 sql문 중 실행할 sql문을 호출해서 원하는 작업을 수행한다

		// 2-1 insert 연습
		/*
		 * System.out.println("insert 작업 시작...");
		 * 
		 * System.out.print("lprod_id 입력>> "); int lprodId = scan.nextInt();
		 * 
		 * System.out.print("lprod_gu 입력>> "); String lprodGu = scan.next();
		 * 
		 * System.out.print("lprod_nm 입력>> "); String lprodNm = scan.next();
		 * 
		 * //1) 입력한 데이터를 VO에 저장한다 LprodVO lvo= new LprodVO(); lvo.setLprod_id(lprodId);
		 * lvo.setLprod_gu(lprodGu); lvo.setLprod_nm(lprodNm);
		 * 
		 * 
		 * //작성된 sql문을 호출해서 실행하여 결과를 받아오는 객체 변수 선언 SqlSession session =null; try { //2)
		 * SqlSessionFactory객체를 이용하여 SqlSession객체를 구한다 //==> openSession()메서드를 사용한다 //
		 * 형식) SqlSessionFactory객체.openSession(논리값) // '논리값'이 true이면 AutoCommit이 활성화 되고
		 * // '논리값'이 생략되거나 false이면 AutoCommit이 비활성화 된다 session=
		 * sqlSessionFactory.openSession(); //논리값 생략한거 AutoCommit이 비활성화.
		 * 
		 * //3) sqlSession객체를 이용하여 처리할 SQL문을 호출하여 실행한다. // 형식) sqlSession객체.insert
		 * ("namespace속성값.실행할 id속성값", 파라미터클래스) //==> 반환값 : 작업에 성공한 레코드 수 int insertCnt=
		 * session.insert("lprod.insertLprod", lvo); if(insertCnt>0) {
		 * System.out.println("insert 작업 성공"); // 작업이 성공하면 AutoCommit이 비활성화된 상태이기 때문에 직접
		 * commit을 실행해야 한다 session.commit(); }else {
		 * System.out.println("insert 작업 실패 "); }
		 * 
		 * } catch (Exception e) { session.rollback(); e.printStackTrace();
		 * 
		 * }finally { if(session!=null)session.close(); }
		 */
		System.out.println("---------------------------------------------------------");
		/*
		// 2-2. update 연습
		System.out.println("update 시작...");

		System.out.print("수정할 lprod_gu 입력>>");
		String lprodGu2 = scan.next();

		System.out.print("새로운 lprod_id 입력>>");
		int lprodid2 = scan.nextInt();

		System.out.print("새로운 lprod_nm 입력>>");
		String lprodNm2 = scan.next();

		// 1) 수정할 데이터를 vo에 저장한다
		LprodVO lvo2 = new LprodVO();
		lvo2.setLprod_id(lprodid2);
		lvo2.setLprod_gu(lprodGu2);
		lvo2.setLprod_nm(lprodNm2);

		SqlSession session = null;
		try {
			//2  SqlSession객체 생성
			session = sqlSessionFactory.openSession();
			
			// 3) SqlSession객체를 이용하여 실행한다
			// 형식) SqlSession객체.update("namespace속성값.실행할id속성값", 파라미터 클래스)
			// 반환값: 성공한 레코드 수

			int updateCnt = session.update("lprod.updateLprod", lvo2);

			if (updateCnt > 0) {
				session.commit();
				System.out.println("update 성공");
			} else {
				System.out.println("update 실패 ");
			}
		} catch (Exception e) { session.rollback(); e.printStackTrace();
				
		}finally { if(session!=null)session.close(); }
		 System.out.println("---------------------------------------------------------");
		 */
		
		/*
		//2-3 delete 연습
		System.out.println("delete 작업 시작...");
		
		System.out.println("삭제할 Lprod_gu 입력>> ");
		String lprodGu3= scan.next();
		
		SqlSession session = null;
		
		try {
			//2  SqlSession객체 생성
			session = sqlSessionFactory.openSession();
			
			//SqlSession객체를 이용하여 실행한다
			//형식) SqlSession객체.delete("namespace속성값.실행할id속성값", 파라미터클래스)
			//반환값: 작업에 성공한 레코드 수 
			int deleteCnt = session.delete("lprod.deleteLprod",lprodGu3);
			
			if(deleteCnt>0) {
				session.commit();
				System.out.println("delete작업 성공");
			}else {
				System.out.println("delete작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		System.out.println("------------------------------------------");
		*/
		
		
		//2-4. select 연습
		/*
		//1) 응답 결과가 여러개인 경우 
		System.out.println("select 작업 시작 (결과가 여러개일 경우...)");
		
		SqlSession session = null;
		try {
			//Sqlsession 객체 생성 
			session= sqlSessionFactory.openSession();
			
			//Sqlsession객체를 이용하여 처리한다 
			//응답 결과가 여러개일 경우에는  selectList()메서드를 사용하는데 이 메서드는 
			//여러개의 레코드 각각을 VO객체에 저장한 후 이 VO데이터를 List에 추가해 주는 
			//작업을 자동으로 수행한다
			//형식) Sqlsession객체.selectList("namespace속성값.실행할 id속성값", 파라미터클래스)
			List<LprodVO> lprodList= session.selectList("lprod.getAllLprod");
			System.out.println();
			
			for(LprodVO lvo3: lprodList) {
				System.out.println("ID: "+lvo3.getLprod_id());
				System.out.println("GU: "+lvo3.getLprod_gu());
				System.out.println("NM: "+lvo3.getLprod_nm());
				System.out.println("----------------------------");
			}
			System.out.println("출력 끝");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		System.out.println("-----------------------------------");
		 */
		
		//1) 응답 결과가 1개인 경우 
		System.out.println("select 작업 시작 (결과가 1개일 경우...)");
		
		System.out.println("검색할 lprod_gu>>");
		String lprodGu4 = scan.next();
		
		SqlSession session = null;
		
		try {
			//SqlSession객체 생성
			session= sqlSessionFactory.openSession();
			
			//SqlSession객체를 이용하여 실행한다
			//응답 결과가 한 개일 경우에는 'selectOne()'메서드를 사용한다 
			//형식: SqlSession객체.selectOne("namespace속성값.실행할id속성값", 파라미터클래스)
			//반환값: sql문을 작성한 태그의 resultType에 지정한 객체가 반환된다 
			//		(단, select한 결과가 하나도 없으면 null이 반환된다.)
			
			LprodVO lvo4= session.selectOne("lprod.getLprod",lprodGu4);
			
			if(lvo4==null) {
				System.out.println("검색한 데이터가 하나도 없습니다 ");
			}else {
				System.out.println("검색 결과 출력");
				System.out.println("ID: "+lvo4.getLprod_id());
				System.out.println("GU: "+lvo4.getLprod_gu());
				System.out.println("NM: "+lvo4.getLprod_nm());
				System.out.println("-------------------------------");
				System.out.println("출력 끝");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
	}
	

}

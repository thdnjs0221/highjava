package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.LprodVO;

/*LPROD테이블에 새로운 데이터 추가하기

Lprod_gu Lprod_nm은 직접 입력받아서 처리하고, 
Lprod_id는 현재의 Lprod_id중에서 제일 큰 값보다 1크게 한다
 입력 받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.*/

// jdbcTest05  클래스의 기능을  Mybatis용으로 변경하시오 

//파일명: jdbc-mapper.xml
public class JdbcToMybatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
/*
		//myBatis 초기화 작업
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;

		try {

			rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");

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
		*/
		// ---------------------------------------------------------------------
		//select문
		SqlSession session = null;

		try {
			//SqlSession객체 생성
			session = MyBatisUtil.getSqlSession();  //MyBatisUtil
			
			//[ Lprod_id는 현재의 Lprod_id중에서 제일 큰 값보다 1크게 한다 ]
			int nextId= session.selectOne("jdbc.getMaxid");
			
			String gu;  //상품 분류 코드(Lprod_gu)입력한거 저장될 변수
			int count =0; //Lprod_gu의 개수가 저장될 변수 
			
			do {
				System.out.println("상품 분류 코드(Lprod_gu)입력>> ");
				gu=scan.next();
				
				count= session.selectOne("jdbc.getLprodguCount",gu);
				
				if(count>0) {
					System.out.println("입력한 상품 분류코드"+gu+"는 이미 등록된 코드입니다");
					System.out.println("다시 입력하세요...");
					System.out.println();
				}
				
			} while (count>0);
			
			System.out.println("상품 분류명(Lprod_nm)입력>> ");
			String nm= scan.next();
			
			//insert할 자료들을 VO객체에 저장한다
			LprodVO lvo= new LprodVO();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod",lvo);
			
			if(cnt>0) {
				session.commit();
				System.out.println("등록 성공");
			}else {
				System.out.println("등록 실패");
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		
		//----------------------------------------------------

	}

}

package kr.or.ddit.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.MemberVO;

public class MybatisMemberTest {
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
		SqlSession session= null;
		
		try {
			session= sqlSessionFactory.openSession();
			
			List<MemberVO> memList = session.selectList("jdbc.insertmem");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

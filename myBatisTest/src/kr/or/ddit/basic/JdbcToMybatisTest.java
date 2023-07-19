package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

// jdbcTest05  클래스의 기능을  Mybatis용으로 변경하시오 

//파일명: jdbc-mapper.xml
public class JdbcToMybatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Reader rd= null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			
			rd= Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
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
		//---------------------------------------------------------------------
		SqlSession session = null;
		String lprodGu4 = scan.next();
		
		try {
			session= sqlSessionFactory.openSession();
			LprodVO lvo4= session.selectOne("lprod.getLprod4",lprodGu4);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

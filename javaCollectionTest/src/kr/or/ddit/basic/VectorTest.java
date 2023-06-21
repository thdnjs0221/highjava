package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		//객체 생성
		//vector 동기화 처리, 자동 데이터 손상되는것을 방지, 데이터 보관 목적, 크기조절 가능
		Vector v1=new Vector(); //아무거나 저장하기 위해 object를 받는다 자동형변환으로 저장함
		
		System.out.println("처음크기: "+v1.size());
		
		//데이터 추가하기1: add(추가할데이터)
		//==>반환값: 추가 성공(true),추가 실패(false)
		
		v1.add("AAA");
		v1.add(new Integer(111)); 
		v1.add(123);// 일반 데이터==> 객체화시키기(박싱)객체형태로 포장한다 ==> 오토박싱 기능이 있다.
					//오토 언박싱 기능도 있다. 
					//객체가 아닌데 가능한 이유? 일반데이터를 주면 객체화 시켜준다
		v1.add('a');
		v1.add(true);
		boolean r= v1.add(3.14);
		System.out.println("현재크기: "+v1.size());
		System.out.println("반환값 r=>"+r);
		
		//데이터 추가하기2: addElemet(추가할데이터) ==>백터의 초기 버전 추가용 메서드
		v1.addElement("CCC");
		
		System.out.println("v1=>"+v1);//백터에 있는 모든 데이터 toString()출력할때는 생ㄱ략
		//System.out.println("v1=>"+v1.toString());
		
		
		//데이터 추가하기3: add(index, 데이터)
		//    ==> 'index'번째에 '데이터'를 끼워 넣는다.
		//    ==>'index'는 0부터 시작한다
		v1.add(1,"KKKK");  //1번째에 데이터를 넣겠다
		System.out.println("v1=>"+v1);
		System.out.println("------------------------------------");
		
		//데이터 꺼내오기: get(index)
		//==> 'index'번째의 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터: "+v1.get(0));
		
		int iTemp = (int)v1.get(2);//object를 꺼내서 자식쪽에 저장하기 위해 강제 형변환
		System.out.println("2번째 데이터: "+iTemp);
		
		//데이터 수정하기: set(index, 새로운데이터)
		//==> 'index'번째의 데이터를 '새로운데이터'로 변경한다
		//==> 반환값: 변경되기 전 데이터 (원래의 데이터)
		String sTemp= (String)v1.set(0, "ZZZ");
		System.out.println("v1 => "+v1);
		System.out.println("반환값 sTemp => "+sTemp);
		System.out.println("------------------------------------");
		
		//데이터 삭제하기:remove(index)
		//==> 'index'번째의 데이터를 삭제한다.
		//==> 반환값: 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제 후 v1=>"+v1);
		
		sTemp=(String)v1.remove(0);
		System.out.println("삭제 후 v1=>"+v1);
		System.out.println("삭제된 데이터=>"+sTemp);
		
		//데이터 삭제하기2: remove(삭제할데이터)
		// ==> '삭제할데이터'를 찾아서 삭제한다.
		// ==> '삭제할데이터'가 여러개이면 이 중에 제일 첫번째 자료가 삭제된다.
		// ==> 반환값:삭제성공(true) 삭제실패(false)
		// ==> 삭제할 데이터가 '정수형'이거나 'char형'일 경우에는 반드시 객체로 변환해서 사용해아함
		v1.remove("CCC");
		System.out.println("CCC 삭제 후 v1=> "+v1);
		
		//v1.remove(123); // integer객체 123//사용불가
		//v1.remove(new Integer(123)); //자바 버전 1.9이전에서 가능
		v1.remove(Integer.valueOf(123)); //자바 버전 1.9이상에서 가능
		
		System.out.println("123 삭제 후 v1=> "+v1); 
		
		//v1.remove('a); //사용불가
		v1.remove(new Character('a'));
		System.out.println("a 삭제 후 v1=> "+v1);
		
		v1.remove(3.14);
		System.out.println("삭제 후 v1=> "+v1);
		
		v1.remove(true);
		System.out.println("삭제 후 v1=>"+v1);
		
		//전체 데이터 삭제하기: clear();
		v1.clear();
		System.out.println("clear  삭제 후 v1=>"+v1);
		System.out.println("------------------------------------");
		
		
		
		
		/*제네릭타입(Generic Type)==> 클래스 내부에서 사용할 데이터 타입을 객체 생성할때 
		 * 외부에서 지정해주는 기법으로 객체를 선언할때 <>괄호 안에 그 객체의 내부에서 
		 * 사용할 데이터의 타입을 지정해 주는 것을 말한다.
		 * 
		 * -이런 식으로 선언하게 되면 그 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 * -제네릭으로 선언 될 수 있는 데이터 타입은 클래스형으로 지정해 주어야 한다.
		 * (예: int==> Integer, boolean==>Boolean, char==>Character 등..
		 * -제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 */
		
		Vector<Integer> v2 = new Vector<>(); //int형 자료만 저장할 수 있는 벡터
		Vector<String> v3= new Vector<String>();//String형 자료만 저장할 수 있는 벡터
		
		v3.add("안녕하세요");
		//v3.add(100);  //오류: 제네릭 타입에서 지정한 자료형과 다른 종류의 자료형은 저장할 수 없다.
		
		String sTemp2= v3.get(0);//형변환없이 사용할 수 있다
		
		Vector<Vector> vv= new Vector<Vector>();
		Vector<Vector<Vector>> vvv= new Vector<Vector<Vector>>();
		System.out.println("--------------------------------------");
		
		//--------------------------------------------------------------
		
		v3.clear();
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String>v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v3=> "+v3);
		System.out.println("v4=> "+v4);
		
		//데이터 삭제하기3: removeAll(collection 객체) 
		//괄호속에 있는 데이터를 삭제해라
		//==> 전체 데이터 중에서 'collection객체'가 가지고 있는 모든 데이터를 삭제한다.
		//==> 반환값: 작업성공(true), 작업실패(false)
		v3.removeAll(v4); //v3전체 데이터 중에 v4가 가지고 있는 데이터를 삭제해라 
		System.out.println("v3=>"+v3);
		
		
		
		
		
		
		
		
	}

}

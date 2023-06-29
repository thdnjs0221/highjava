package kr.or.ddit.basic;

// yield()메서드 연스용 예제

public class ThreadTest10 {

   public static void main(String[] args) {
      YieldThread th1 = new YieldThread("1번쓰레드");
      YieldThread th2 = new YieldThread("2번쓰레드");
      
      th1.start();
      th2.start();
      
      try {
         Thread.sleep(5);
      } catch (InterruptedException e) {
         // TODO: handle exception
      }
      System.out.println("---------------1111");
      th1.setWork(false);
      
      try {
         Thread.sleep(5);
      } catch (InterruptedException e) {
         // TODO: handle exception
      }
      System.out.println("---------------2222");
      th1.setWork(true);
      
      try {
         Thread.sleep(5);
      } catch (InterruptedException e) {
         // TODO: handle exception
      }
      System.out.println("---------------3333");
      th1.setStop(true);
      th2.setStop(true);
   }

}

//yield()메서드 연습용 쓰레드
class YieldThread extends Thread {
   private boolean stop = false;
   private boolean work = true;
   
   public void setWork(boolean work) {
      this.work=work;
   }
   
   public void setStop(boolean stop) {
      this.stop=stop;
   }
   
   //생성자
   public YieldThread(String name) {
      super(name); // 쓰레드의 이름 설정하기
   }
   
   @Override
   public void run() {
      while(!stop) {
         if(work) {
            System.out.println(getName() +"작업중 ...");
         }else {
            System.out.println(getName() +"양보...");
            Thread.yield();
         }
      }
   
   }
   
   
}
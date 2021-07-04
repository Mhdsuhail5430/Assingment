package hit.assingment1;

import java.util.Date;

     //implemented Lambda
public class ThreadVaccination2 {
	public static void main(String[] args)throws Exception {
		VaccinationCenter2 vc2=new VaccinationCenter2();
		Thread t=Thread.currentThread();
		t.setName("sohaib");
		System.out.println(new Date());
		
		System.out.println(t.getName()+ "  before coming to class ");
		Thread kala1=new Thread(new JobToKala2(vc2),"kala");
		kala1.start();
		//vc.getToken();//without doin the job by the same person we give the job to kala.start();
		                //so in output the class started before the token collected by kala
		
		Thread kala1=new Thread(()->{
			System.out.println("the job done by kala from lambda");
			try {
				vc2.getToken();
			}catch (Exception e) {
				e.printStackTrace();
			}
		},"kala");
		System.out.println(t.getName()+ " started  class ..for 7-9 Golden batch.."+new Date());
	}

}
class JobToKala2 implements Runnable{
	
	VaccinationCenter2 vc2;
		public JobToKala2(VaccinationCenter2 vc2) {
		
		this.vc2 = vc2;
		
	}


		@Override
	public void run() {
		// TODO Auto-generated method stub
			System.out.println("job given to kala is executed from this method");
			try {
				vc2.getToken();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		
	}
}
class VaccinationCenter2{
	
	public void getToken()throws Exception{
		Thread t=Thread.currentThread();
		
		String name=t.getName();
		
		
		System.out.println(name+"..standing in queue for token");
		Thread.sleep(5000);
		System.out.println("token received.."+new Date());
		
		
	}
	
}



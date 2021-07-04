package hit.assingment1;

import java.util.Date;
   //implemented Anonymous and Method expression.
public class ThreadVaccination {
	static VaccinationCenter vc;
	private  static void jobkala(){
try {
			
			
			vc.getToken();
		}catch(Exception e)
{
			e.printStackTrace();
			
			
			
		}
		
	}
	
	public static void main(String[] args)throws Exception {
	    vc=new VaccinationCenter();
		Thread t=Thread.currentThread();
		t.setName("sohaib");
		System.out.println(new Date());
		
		System.out.println(t.getName()+ "  before coming to calss ");
		
		    //Anonymous class
				Thread kala=new Thread (
		  new Runnable() {
			  
	    	  @Override
		public void run() {
			// TODO Auto-generated method stub
				System.out.println("job given to kala is executed from the  anonymous class");
				try {
					vc.getToken();
				}catch(Exception e){
					e.printStackTrace();
					
				}
		}
	    	  
	    },"kala");
		kala.start();
		
		 
		
		//Method expression
		
		Thread kala1=new Thread(ThreadVaccination::jobkala,"kala");
		kala1.start();
        System.out.println("job kala is called from method expression");
		
		//Lambda function
        
		
		
	
		
		
		System.out.println(t.getName()+ " started  class ..for 7-9 Golden batch.."+new Date());
	}
}


class JobToKala implements Runnable {
	
	
	VaccinationCenter vc;
		public JobToKala(VaccinationCenter vc) {
		
		this.vc = vc;
		}
		@Override//for lambda
		public void run() {
			// TODO Auto-generated method stub
			
			System.out.println("job given to kala is executed from the  anonymous class");
			try {
				vc.getToken();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
}
class VaccinationCenter{
	
	public void getToken()throws Exception{
		Thread t=Thread.currentThread();
		
		String name=t.getName();
		
		
		System.out.println(name+"..standing in queue for token");
		Thread.sleep(5000);
		System.out.println("token received.."+new Date());
		
		
	}
	
}	




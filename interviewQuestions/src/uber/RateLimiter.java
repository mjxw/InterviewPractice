package uber;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/*
# This function is only called from `invoke_outgoing()` function
def outgoing():
  # make an HTTP call to a third party service
  pass

# This function is being called by the rest of the service.
# It suppose to prevent `outgoing()` from being called more than 100 times in any 1 second window
def invoke_outgoing():

    ->>> outgoing()
*/ 


public class RateLimiter {
	
	private int activeCalls;
	private int maxCalls;
	private Timer timer; 
	private Queue<Integer> q; 
	
	
	public static void main (String[] args) {
		RateLimiter limiter = new RateLimiter(10);
	}   
	
	public RateLimiter(int maxCalls) {
		this.activeCalls = 0;
		this.maxCalls = maxCalls;
		this.q = new LinkedList<>();
		
		this.timer = new Timer();
		
		TimerTask invokeTask = new invokeHelper();
		timer.schedule(invokeTask, 0, 10);
		
		TimerTask resetTask = new resetHelper();
		timer.schedule(resetTask, 1000);
	}

	private void reset() {
		this.activeCalls = 0;
	}
	
	private void outgoing(int task) {
		System.out.println("outgoing: " + task);
	}
	
	
	public void invoke_outgoing(int task) {
		q.add(task);
		if (this.activeCalls > this.maxCalls) {
			delay();
		} else { 
			if (!q.isEmpty()) {
				this.activeCalls++;
				outgoing(task);
			}
		}
		
		if (this.activeCalls < this.maxCalls) {
			q.poll(); 
			this.activeCalls--;	
		}
	}

	private void delay() {
		System.out.println("delay");
	}
	

	private class resetHelper extends TimerTask {	
		@Override
	    public void run() {
	       reset();
	    }
	}
	
	private class invokeHelper extends TimerTask {	
		public int task = 0;
		
		@Override
	    public void run() {
	       invoke_outgoing(task++);
	    }
	}
}

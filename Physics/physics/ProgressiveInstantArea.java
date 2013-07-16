package physics;

public class ProgressiveInstantArea extends Thread {

	private Physix plugin;
	
	protected ProgressiveInstantArea(Physix instance)
	{
		plugin=instance;
	}
		
	public void run() {
		plugin.progressiveInstantArea();
	}

}

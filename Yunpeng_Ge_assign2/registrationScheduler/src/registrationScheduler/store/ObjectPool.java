package registrationScheduler.store;

public interface ObjectPool {
	public void borrowObject();
	public void returnObject();
	public int getNumActive();
	public int getNumIdle();
	public void addObject();
}

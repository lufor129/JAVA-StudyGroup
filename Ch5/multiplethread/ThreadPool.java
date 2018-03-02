package multiplethread;

import java.util.LinkedList;

public class ThreadPool {
//	共十個任務
	int threadPoolSize = 10;

	LinkedList<Runnable> tasks = new LinkedList<Runnable>();

	public ThreadPool() {
		synchronized (tasks) {
			for (int i = 0; i < threadPoolSize; i++) {
				new TaskConsumeThread("任務消費者線程 " + i).start();
			}
		}
	}

	public void add(Runnable r) {
		synchronized (tasks) {
			tasks.add(r);
			tasks.notifyAll();
		}
	}

	class TaskConsumeThread extends Thread {
		public TaskConsumeThread(String name) {
			super(name);
		}

		Runnable task;

		public void run() {
			System.out.println("啟動  " + this.getName());
			while (true) {
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
						}
					}
					task = tasks.removeLast();
					tasks.notifyAll();
				}
				System.out.println(this.getName() + " 獲取到任務，並執行");
				task.run();
			}
		}
	}
}

package com.latico.commons.common.util.thread.thread;

import com.latico.commons.common.util.logging.Logger;
import com.latico.commons.common.util.logging.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <PRE>
 * 我们自己的线程类，子类实现dealProcess()方法进行业务处理
 * </PRE>
 * <B>项	       目：</B>
 * <B>技术支持：</B>
 * @version   <B>V1.0 2017年10月31日</B>
 * @author    <B><a href="mailto:latico@qq.com"> latico </a></B>
 * @since     <B>JDK1.6</B>
 */
public abstract class AbstractRunnable implements Runnable {

	/** LOG 日志工具 */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractRunnable.class);

	/** threadName 自定义线程名称 */
	protected String threadName;

	/** isRunning 是否运行中 */
	protected boolean runStatus;
	
	/** appRunStatus APP运行状态，此值由外界调用startMonitor启动方式传入，一旦监控到APP关闭，此监控器也同时关闭自身，如果不传入，默认此状态一直为true */
	protected AtomicBoolean appRunStatus;

	public AbstractRunnable(String threadName, AtomicBoolean appRunStatus) {
		if (threadName == null || "".equals(threadName)) {
			threadName = UUID.randomUUID().toString();
		}
		
		this.appRunStatus = appRunStatus;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		runStatus = true;
		LOG.info("线程:[{}] 启动", threadName);
		try {
			dealProcess();
		} catch (Throwable e) {
			runStatus = false;
			LOG.error("线程:[" + threadName + "] 执行任务发生异常", e);
		}
		LOG.info("线程:[{}] 关闭", threadName);
	}
	
	
	/**
	 * 子类处理流程方法
	 * @throws Exception 子方法可以抛异常
	 */
	protected abstract void dealProcess() throws Exception;

	/**
	 * 启动线程
	 *
	 * @return
	 */
	public boolean startThread() {
		if (runStatus) {
			LOG.warn("线程:[{}] 已经启动", threadName);
			return false;
		} else {
			new Thread(this).start();
			return true;
		}
	}

	/**
	 * 关闭线程
	 */
	public void stopThread() {
		LOG.warn("线程:[{}] 触发了线程:[{}]的停止信号", Thread.currentThread().getName(), threadName);
		runStatus = false;
	}
	
	/**
	 * 获取线程名称
	 * @return
	 */
	public String getThreadName(){
		return threadName;
	}
	
	/**
	 * 是否还在运行
	 * @return
	 */
	public boolean isRunning(){
		if(appRunStatus == null){
			return runStatus;
		}else{
			return runStatus && appRunStatus.get();
		}
	}

}

package chapter11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank
{
	private final double[] accounts;
	private Lock bankLock;
	private Condition suffcientFunds;

	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for (int i = 0; i < n; i++)
		{
			accounts[i] = initialBalance;

		}
		bankLock = new ReentrantLock();
		suffcientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amounts)
			throws InterruptedException
	{
		bankLock.lock();
		try
		{
			while (accounts[from] < amounts)
			{
				suffcientFunds.await();
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amounts;
			System.out.printf("%10.2f from %d to %d", from, to);
			accounts[to] += amounts;
			System.out.printf("total balance : 10.2f %n", getTotalBalance());
			suffcientFunds.signalAll();

		} catch (Exception e)
		{
			// TODO: handle exception
			bankLock.unlock();
		}

	}

	public double getTotalBalance()
	{
		bankLock.lock();
		try
		{
			double sum = 0;
			for (double a : accounts)
			{
				sum += a;
			}
			return sum;
		} catch (Exception e)
		{
			// TODO: handle exception
			bankLock.unlock();
		}
		return 0;
	}

	public int size()
	{
		return accounts.length;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

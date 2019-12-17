package yc.user;

import yc.lottery.Lottery;

public class User implements Runnable{
	@Override
	public void run() {
		for (int k = 0; k < 6; k++) {
			Lottery L = new Lottery();
			int [] mylottery = new int[6];
			for (int i = 0; i < mylottery.length; i++) {
				if (i < mylottery.length && i>0) {
					mylottery [i] = (int) (Math.random() * 15 + 1);
				}else {
					mylottery [0] = (int)(Math.random()*31 + 1);
				}
			}
			L.setMyLotter(mylottery);
			System.out.print("用户定期随机下注：{");
			for (int i = 0; i < mylottery.length; i++) {
				int j = mylottery[i];
				System.out.print(j+",");
			}
			System.out.println("}");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		User zhangsan = new User();
		Thread t1 = new Thread(zhangsan);
		t1.start();
	}
}
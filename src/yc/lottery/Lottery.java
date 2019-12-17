package yc.lottery;

import java.util.Scanner;

public class Lottery { 
	
	public static int num;//投注数目
	public static int num1;//一等奖的数目
	public static int num2;//二等奖的数目
	public static int num3;//三等奖的数目
	public static int num4;//四等奖的数目
	public static int num5;//五等奖的数目
	public static int num6;//六等奖的数目
	//红球号码
	public int red;
	//蓝球号码
	public int[] blue;

	//中奖强度
	static int level = 0;
	//客户的彩票号码
	public static int [] myLotter;
	//自定义中奖号码为winningLottery
	protected static int [] winningLottery = {9,5,2,1,10,3};
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = myLotter[0];
	}
	public int[] getBlue() {
		return blue;
	}
	public void setBlue(int[] blue) {
		System.arraycopy(myLotter, 1, blue, 0, 5);
	}
	public static int[] getMyLotter() {
		return myLotter;
	}
	public void setMyLotter(int[] myLotter) {
		Lottery.myLotter = myLotter;
	}
	
	public int[] getWinningLottery() {
		return winningLottery;
	}
	public void setWinningLottery(int[] winningLottery) {
		Lottery.winningLottery = winningLottery;
	}
	//构造函数
	public Lottery() {
		
	}
	//核对用户号码与中奖号码
	public int compare() {
		/**全部号码猜中，且位置一致，强度level = 6,对应一等奖
		 *红球猜中，蓝球四个一致，强度level = 5,   对应二等奖
		 *红球未中，蓝球五个一致，强度level = 5，对应二等奖
		 *红球猜中，蓝球三个一致，强度level = 4，对应三等奖
		 *红球未中，蓝球四个一致，强度level = 4，对应三等奖
		 *红球猜中，蓝球两个一致，强度level = 3，对应四等奖
		 *红球未中，蓝球三个一致，强度level = 3，对应四等奖
		 *红球猜中，蓝球一个一致，强度level = 2，对应五等奖
		 *红球未中，蓝球两个一致，强度level = 2，对应五等奖
		*/
		for (int i = 0; i < myLotter.length; i++) {
			if (myLotter[i] == winningLottery[i]) {
				level++;
			}
		}
		return level-1;
		
	}
	public static int isWinning(Lottery myLottery) {
		myLottery.compare();
		if(level == 6) {
			System.out.println("恭喜您获得一等奖！");
			num1++;
			return 1;//一等奖
		}
		else if(level == 5) {
			System.out.println("恭喜您获得二等奖！");
			num2++;
			return 2;
		}
		else if (level == 4) {
			num3++;
			System.out.println("恭喜您获得三等奖！");
			return 3;
		}else if (level == 3) {
			num4++;
			System.out.println("恭喜您获得四等奖！");
			return 4;
		}else if (level == 2) {
			num5++;
			System.out.println("恭喜您获得五等奖！");
			return 5;
		}else {
			System.out.println("祝您下次中奖！");
			return 0;
		}
		
	}
	public static void main(String[] args) {
		/**
		 * 测试Lottery
		 * 
		 */
		System.out.println("现在有：\n红球：1~32号；蓝球：1~16号");
		Lottery L =new Lottery();
		int [] mylottery = new int[6];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入你想要购买的彩票号码（首位是红球号码，其余五位是蓝球号码）：\n温馨提示：为提高中奖率请购买在范围内的号码（每一位都需按enter进行确认，共输入6位）");
		for (int i = 0; i < mylottery.length; i++) {
			mylottery[i] = sc.nextInt();
		}
		L.setMyLotter(mylottery);
		L.isWinning(L);
	}
}
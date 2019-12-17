package yc.lotterymanager;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import yc.lottery.Lottery;

public class LotteryManager extends Lottery{
	//每注的价格
	private static final int price = 2;
	//下注的数目
	private static int num;
	//奖池
	private static double pool ;
	//本期中奖号码
	//所有投注彩票，以map形式存储
	private static Map<String, int[]> lotteries = new HashMap<String, int[]>();
	
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		LotteryManager.num = num;
	}
	public double getPool() {
		return pool;
	}
	public void setPool(int pool) {
		LotteryManager.pool = pool;
	}
	//进行投注
	public static void bet(Lottery lottery) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入想购买的彩票数量：");
		num = sc.nextInt();
		int [] mylottery = new int[6];
		for (int i = 1; i <= num; i++) {
			System.out.println("请输入你想要购买的彩票号码（按回车确认）：");
			for (int j = 0; j < mylottery.length; j++) {
				mylottery[j] = sc.nextInt();
			}
			lottery.setMyLotter(mylottery);
			announce();
			lottery.setWinningLottery(winningLottery);
			lottery.isWinning(lottery);
		}
	}
	//将所有的彩票放入lotteries中存储
	private static void lotteries() {
		for (int i = 1; i <= num; i++) {
			lotteries.put("第"+i+"张", myLotter);
		}
		System.out.println("共出售"+lotteries.size()+"张彩票");
	}
	//开奖方法
	private static void announce() {
	//随机产生一个新的中奖号码newWinning
		int [] newWinning = new int[6];
		for (int i = 0; i < newWinning.length; i++) {
			if (i < newWinning.length && i>0) {
				newWinning [i] = (int) (Math.random() * 15 + 1);
			}else {
				newWinning [0] = (int)(Math.random()*31 + 1);
			}
		}
		winningLottery = newWinning;
		System.out.println("新的中奖号码为："+Arrays.toString(winningLottery));
		award();
	}
	//发放奖金的方法，同时从奖池pool中扣除奖金
	public static void award() {
		pool = price * num * 0.8;
		double firstprize = pool * 0.5;   //一等奖
		double secondprize = pool * 0.1;  //二等奖     
		double thirdprize = pool * 0.02;  //三等奖     
		double forthprize = pool * 0.004; //四等奖     
		double fiveprize = pool * 0.0001; //五等奖     
		pool = pool - firstprize * num1 - secondprize * num2 - thirdprize *num3 - forthprize * num4- fiveprize*num5;
		System.out.println("剩余奖金："+pool);
		lotteries();
		}
		
	//将投注情况，中奖号码，开奖情况记录到D:\lottery.txt
	public static void write() throws Exception {
		File file =new File("D:\\lottery.txt");
		Writer out =new FileWriter(file);
		String data = "";
		for (int i= 0;i < winningLottery.length;i++) {
			data += winningLottery[i]+",";
		}
		out.write("本期中奖号码："+data+"\n本期共投了"+num+"注"+"其中一等奖"+num1+"注\n剩余奖金："+pool);
		out.close();
	}
	public static void main(String[] args) {
		Lottery L = new Lottery();
		LotteryManager.bet(L);
		try {
			LotteryManager.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

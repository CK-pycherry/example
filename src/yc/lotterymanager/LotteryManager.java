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
	//ÿע�ļ۸�
	private static final int price = 2;
	//��ע����Ŀ
	private static int num;
	//����
	private static double pool ;
	//�����н�����
	//����Ͷע��Ʊ����map��ʽ�洢
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
	//����Ͷע
	public static void bet(Lottery lottery) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������빺��Ĳ�Ʊ������");
		num = sc.nextInt();
		int [] mylottery = new int[6];
		for (int i = 1; i <= num; i++) {
			System.out.println("����������Ҫ����Ĳ�Ʊ���루���س�ȷ�ϣ���");
			for (int j = 0; j < mylottery.length; j++) {
				mylottery[j] = sc.nextInt();
			}
			lottery.setMyLotter(mylottery);
			announce();
			lottery.setWinningLottery(winningLottery);
			lottery.isWinning(lottery);
		}
	}
	//�����еĲ�Ʊ����lotteries�д洢
	private static void lotteries() {
		for (int i = 1; i <= num; i++) {
			lotteries.put("��"+i+"��", myLotter);
		}
		System.out.println("������"+lotteries.size()+"�Ų�Ʊ");
	}
	//��������
	private static void announce() {
	//�������һ���µ��н�����newWinning
		int [] newWinning = new int[6];
		for (int i = 0; i < newWinning.length; i++) {
			if (i < newWinning.length && i>0) {
				newWinning [i] = (int) (Math.random() * 15 + 1);
			}else {
				newWinning [0] = (int)(Math.random()*31 + 1);
			}
		}
		winningLottery = newWinning;
		System.out.println("�µ��н�����Ϊ��"+Arrays.toString(winningLottery));
		award();
	}
	//���Ž���ķ�����ͬʱ�ӽ���pool�п۳�����
	public static void award() {
		pool = price * num * 0.8;
		double firstprize = pool * 0.5;   //һ�Ƚ�
		double secondprize = pool * 0.1;  //���Ƚ�     
		double thirdprize = pool * 0.02;  //���Ƚ�     
		double forthprize = pool * 0.004; //�ĵȽ�     
		double fiveprize = pool * 0.0001; //��Ƚ�     
		pool = pool - firstprize * num1 - secondprize * num2 - thirdprize *num3 - forthprize * num4- fiveprize*num5;
		System.out.println("ʣ�ཱ��"+pool);
		lotteries();
		}
		
	//��Ͷע������н����룬���������¼��D:\lottery.txt
	public static void write() throws Exception {
		File file =new File("D:\\lottery.txt");
		Writer out =new FileWriter(file);
		String data = "";
		for (int i= 0;i < winningLottery.length;i++) {
			data += winningLottery[i]+",";
		}
		out.write("�����н����룺"+data+"\n���ڹ�Ͷ��"+num+"ע"+"����һ�Ƚ�"+num1+"ע\nʣ�ཱ��"+pool);
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

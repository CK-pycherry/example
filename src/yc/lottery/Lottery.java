package yc.lottery;

import java.util.Scanner;

public class Lottery { 
	
	public static int num;//Ͷע��Ŀ
	public static int num1;//һ�Ƚ�����Ŀ
	public static int num2;//���Ƚ�����Ŀ
	public static int num3;//���Ƚ�����Ŀ
	public static int num4;//�ĵȽ�����Ŀ
	public static int num5;//��Ƚ�����Ŀ
	public static int num6;//���Ƚ�����Ŀ
	//�������
	public int red;
	//�������
	public int[] blue;

	//�н�ǿ��
	static int level = 0;
	//�ͻ��Ĳ�Ʊ����
	public static int [] myLotter;
	//�Զ����н�����ΪwinningLottery
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
	//���캯��
	public Lottery() {
		
	}
	//�˶��û��������н�����
	public int compare() {
		/**ȫ��������У���λ��һ�£�ǿ��level = 6,��Ӧһ�Ƚ�
		 *������У������ĸ�һ�£�ǿ��level = 5,   ��Ӧ���Ƚ�
		 *����δ�У��������һ�£�ǿ��level = 5����Ӧ���Ƚ�
		 *������У���������һ�£�ǿ��level = 4����Ӧ���Ƚ�
		 *����δ�У������ĸ�һ�£�ǿ��level = 4����Ӧ���Ƚ�
		 *������У���������һ�£�ǿ��level = 3����Ӧ�ĵȽ�
		 *����δ�У���������һ�£�ǿ��level = 3����Ӧ�ĵȽ�
		 *������У�����һ��һ�£�ǿ��level = 2����Ӧ��Ƚ�
		 *����δ�У���������һ�£�ǿ��level = 2����Ӧ��Ƚ�
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
			System.out.println("��ϲ�����һ�Ƚ���");
			num1++;
			return 1;//һ�Ƚ�
		}
		else if(level == 5) {
			System.out.println("��ϲ����ö��Ƚ���");
			num2++;
			return 2;
		}
		else if (level == 4) {
			num3++;
			System.out.println("��ϲ��������Ƚ���");
			return 3;
		}else if (level == 3) {
			num4++;
			System.out.println("��ϲ������ĵȽ���");
			return 4;
		}else if (level == 2) {
			num5++;
			System.out.println("��ϲ�������Ƚ���");
			return 5;
		}else {
			System.out.println("ף���´��н���");
			return 0;
		}
		
	}
	public static void main(String[] args) {
		/**
		 * ����Lottery
		 * 
		 */
		System.out.println("�����У�\n����1~32�ţ�����1~16��");
		Lottery L =new Lottery();
		int [] mylottery = new int[6];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����������Ҫ����Ĳ�Ʊ���루��λ�Ǻ�����룬������λ��������룩��\n��ܰ��ʾ��Ϊ����н����빺���ڷ�Χ�ڵĺ��루ÿһλ���谴enter����ȷ�ϣ�������6λ��");
		for (int i = 0; i < mylottery.length; i++) {
			mylottery[i] = sc.nextInt();
		}
		L.setMyLotter(mylottery);
		L.isWinning(L);
	}
}
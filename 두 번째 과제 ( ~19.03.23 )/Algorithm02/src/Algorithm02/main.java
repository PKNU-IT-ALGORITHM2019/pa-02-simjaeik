package Algorithm02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

	public static int bufferSize = 20;
	public static PointXY [] buffer = new PointXY [bufferSize];
	public static handleMinimum minis ;
	public static Scanner kb ;
	
	public static void main(String[] args) {
	
		command();
	}

	private static void command() {
		
		while(true) {
			long start = System.currentTimeMillis();			//�ð� ����
			
			kb = new Scanner(System.in);						// ���ϸ� �Է¹ޱ�
			
			System.out.print("���ϸ��� �Է��ϼ��� : ");
		
			String fileName = kb.nextLine();
			try {
				kb = new Scanner(new File(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				continue;
			}

			
			int N = Integer.parseInt(kb.nextLine());			// N�� �ޱ�
			
			getXY( N, kb);										// N���� (x, y)�� �Է¹޾� buffer�� ����
			minis = new handleMinimum(N, buffer);				// minis��� ��ü�� �����͸� ����
			
			minis.getMinDis(buffer, 1, N, 0);					// tsp�� �о���� ���� �Ÿ��� ���� �ּڰ��� ���Ѵ�.
			
			long end = System.currentTimeMillis();				// �ð� ����
			
			System.out.println( "�ɸ� �ð� : "+ (end - start)/1000.0 + " ��");

			printMinArray(N);
		}
		
	}

	private static void printMinArray(int N) {
		
		System.out.println("answer:");
		minis.getMinDis();
		System.out.print("[");
		for(int i = 0; i < N; i++) {
			if(i == N-1){
				System.out.println(minis.getMinArray(i)+"]");
				break;
			}
			System.out.print(minis.getMinArray(i) + ", ");
		}
		
	}

	private static void getXY(int n, Scanner kb) {

		for(int i=0; i<n ; i++) {
			String line = kb.nextLine();
			buffer[i] = new PointXY(i,line);
		}
		
		System.out.println("�����...");
	}

}
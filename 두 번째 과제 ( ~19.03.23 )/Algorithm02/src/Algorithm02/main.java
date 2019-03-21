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
			long start = System.currentTimeMillis();			//시간 측정
			
			kb = new Scanner(System.in);						// 파일명 입력받기
			
			System.out.print("파일명을 입력하세요 : ");
		
			String fileName = kb.nextLine();
			try {
				kb = new Scanner(new File(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				continue;
			}

			
			int N = Integer.parseInt(kb.nextLine());			// N값 받기
			
			getXY( N, kb);										// N줄의 (x, y)를 입력받아 buffer에 저장
			minis = new handleMinimum(N, buffer);				// minis라는 객체에 데이터를 관리
			
			minis.getMinDis(buffer, 1, N, 0);					// tsp로 읽어들인 점들 거리의 합의 최솟값을 구한다.
			
			long end = System.currentTimeMillis();				// 시간 측정
			
			System.out.println( "걸린 시간 : "+ (end - start)/1000.0 + " 초");

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
		
		System.out.println("계산중...");
	}

}
package Algorithm02;

public class handleMinimum {

	public static double minDis;
	public static int [] minArray;

	public handleMinimum(int N, PointXY buffer[]) {			// 생성자
		minArray = new int [N];

		for (int i=0; i<N; i++){	
			if (i == N-1) {
				minDis += getDis(buffer,i,0);
				break;
			}

			minDis += getDis(buffer, i,i+1);
			minArray[i]=i;
		}
	}
	
	public void getMinDis(PointXY buffer[], int k, int N, double currentDis) {		// 최솟값 구하는 tsp 함수

		if (currentDis > minDis)	//만약 currentDistance가 minimumDistance보다 크면 가지치기
			return;

		if(k == N) {
			currentDis += getDis(buffer,k-1,0);

			if(minDis > currentDis) {		// currentDistance가 minimumDistance보다 작다면 minDis로 대입
				minDis = currentDis;
				for(int i=0; i < N; i++)
					minArray[i] = buffer[i].i;
			}
			return;
		}
		
		else {
			for (int i = k; i < N; i++){
				swap(buffer, k, i);
				getMinDis(buffer, k+1, N, currentDis + getDis(buffer, k-1, k));
				swap(buffer, k, i);
			}
		}
	}

	private static void swap(PointXY buffer[], int k, int i) {		//swap함수
		PointXY tmp = new PointXY(0, 0, 0);

		tmp = buffer[k];
		buffer[k]=buffer[i];
		buffer[i]=tmp;

	}

	private static double getDis(PointXY buffer[], int i, int j) {		// 두 점간 거리 구하는 함수		( 1. sqrt는 루트를 구하는 함수, 2. pow(a,b)는 a^b를 구하는 함수, 3. abs는 절댓값 )
		return Math.sqrt(Math.pow(Math.abs(buffer[i].x-buffer[j].x),2 ) + Math.pow(Math.abs(buffer[i].y-buffer[j].y),2));
	}

	public void getMinDis() {		//minDis를 출력
		System.out.println(minDis);
	}

	public int getMinArray(int i) {		//minArray를 출력
		return minArray[i];
	}


}

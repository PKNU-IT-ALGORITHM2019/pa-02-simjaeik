package Algorithm02;

public class handleMinimum {

	public static double minDis;
	public static int [] minArray;

	public handleMinimum(int N, PointXY buffer[]) {			// ������
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
	
	public void getMinDis(PointXY buffer[], int k, int N, double currentDis) {		// �ּڰ� ���ϴ� tsp �Լ�

		if (currentDis > minDis)	//���� currentDistance�� minimumDistance���� ũ�� ����ġ��
			return;

		if(k == N) {
			currentDis += getDis(buffer,k-1,0);

			if(minDis > currentDis) {		// currentDistance�� minimumDistance���� �۴ٸ� minDis�� ����
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

	private static void swap(PointXY buffer[], int k, int i) {		//swap�Լ�
		PointXY tmp = new PointXY(0, 0, 0);

		tmp = buffer[k];
		buffer[k]=buffer[i];
		buffer[i]=tmp;

	}

	private static double getDis(PointXY buffer[], int i, int j) {		// �� ���� �Ÿ� ���ϴ� �Լ�		( 1. sqrt�� ��Ʈ�� ���ϴ� �Լ�, 2. pow(a,b)�� a^b�� ���ϴ� �Լ�, 3. abs�� ���� )
		return Math.sqrt(Math.pow(Math.abs(buffer[i].x-buffer[j].x),2 ) + Math.pow(Math.abs(buffer[i].y-buffer[j].y),2));
	}

	public void getMinDis() {		//minDis�� ���
		System.out.println(minDis);
	}

	public int getMinArray(int i) {		//minArray�� ���
		return minArray[i];
	}


}

package Algorithm02;

public class PointXY {
	public int i;		// i ��° �迭�� ��ġ���� �ǹ�
	public int x,y;		// ��ǥ
	
	public PointXY(int i,String line) {
		this.i =i;
		x = Integer.parseInt(line.split(" ")[0]);	// line���� �պκ��� x
		y = Integer.parseInt(line.split(" ")[1]);	// line���� �޺κ��� y
	}
	
	public PointXY(int i,int x,int y) {				// ������
		this.i = i;
		this.x = x;
		this.y = y;
	}
	
}

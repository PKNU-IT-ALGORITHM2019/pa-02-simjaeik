package Algorithm02;

public class PointXY {
	public int i;		// i 번째 배열에 위치함을 의미
	public int x,y;		// 좌표
	
	public PointXY(int i,String line) {
		this.i =i;
		x = Integer.parseInt(line.split(" ")[0]);	// line에서 앞부분이 x
		y = Integer.parseInt(line.split(" ")[1]);	// line에서 뒷부분이 y
	}
	
	public PointXY(int i,int x,int y) {				// 생성자
		this.i = i;
		this.x = x;
		this.y = y;
	}
	
}

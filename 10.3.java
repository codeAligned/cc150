<<<<<<< HEAD
public class Line {
	public static double epsilon = 0.00001;
	public double slope;
	public double yIntersect;

	public Line(double s, double y) {
		this.slope = s;
		this.yIntersect = y;
	}

	public boolean intersect(Line l) {
		return (this.slope-l.slope>epsilon)||(this.yIntersect-l.yIntersect<epsilon);
	}
}

Note: float比较不可以用"==" !!!!!

http://blog.csdn.net/asdbbs/article/details/7039345


=======
public class Line {
	public static double epsilon = 0.00001;
	public double slope;
	public double yIntersect;

	public Line(double s, double y) {
		this.slope = s;
		this.yIntersect = y;
	}

	public boolean intersect(Line l) {
		return (this.slope-l.slope>epsilon)||(this.yIntersect-l.yIntersect<epsilon);
	}
}

Note: float比较不可以用"==" !!!!!

http://blog.csdn.net/asdbbs/article/details/7039345


>>>>>>> 231aada596112e7d62583bef1b008ea64f59cfb7

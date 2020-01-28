import java.awt.Graphics;

class Polygon extends Deq implements Figure {
	private double s, p;
	protected double count;
	private void grow(R2Point a, R2Point b, R2Point t) {
		p -= R2Point.dist(a, b);
		s += Math.abs(R2Point.area(a, b, t));
	}
	public Polygon(R2Point a, R2Point b, R2Point c) {
		pushFront(b);
		
		if (b.light(a, c)) {
			pushFront(a); pushBack(c);
		} else {
			pushFront(c); pushBack(a);
		}
		p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
		s = Math.abs(R2Point.area(a, b, c));
	}
	public double perimeter() {
		return p;
	}
	public double area() {
		return s;
	}
	public Figure add(R2Point t) {
		int i;
		// Ищем освещенные ребра, просматривая их одно за другим.
		for (i=length(); i>0 && !t.light(back(),front()); i--)
		pushBack(popFront());
		// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
		// либо освещенных ребер нет совсем.
		if (i>0) {
			R2Point x;
			grow(back(), front(), t);
			// Удаляем все освещенные ребра из начала дека.
			for (x = popFront(); t.light(x, front()); x = popFront())
			grow(x, front(), t );
			pushFront(x);
			// Удаляем все освещенные ребра из конца дека.
			for (x = popBack(); t.light(back(), x); x = popBack())
			grow(back(), x, t);
			pushBack(x);
			// Завершаем обработку добавляемой точки.
			p += R2Point.dist(back(), t) + R2Point.dist(t, front());
			count(t);
			pushFront(t);
		}
		if (i <= 0) System.out.println("Точка не попала в множество вершин выпуклой оболочки.");
		return this;
	}
	public void count(R2Point t) {
		double Rast1, Rast2;
		Rast1 = Math.abs(t.x * front().y - t.y * front().x) / Math.sqrt(Math.pow(t.y - front().y, 2) + Math.pow(t.x - front().x, 2));
		Rast2 = Math.abs(t.x * back().y - t.y * back().x) / Math.sqrt(Math.pow(t.y - back().y, 2) + Math.pow(t.x - back().x, 2));
		if (Rast1 == MyFrame.Rad) count += 1;
		if (Rast1 < MyFrame.Rad) count += 2;
		if (Rast2 == MyFrame.Rad) count += 1;
		if (Rast2 < MyFrame.Rad) count += 2;
	}
	public void draw(Graphics g) {
		for(int i = length(); i > 0; i--) {
			g.fillOval((int)(front().x - 5), (int)(-front().y -5), 10, 10);
			g.drawLine((int)front().x, (int)-front().y, (int)back().x, (int)-back().y);
			pushFront(popBack());
		}
		
	}
}
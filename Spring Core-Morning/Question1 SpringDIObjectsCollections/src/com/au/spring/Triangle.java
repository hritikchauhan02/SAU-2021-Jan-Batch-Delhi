package com.au.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Triangle {

	public Map<String, Point> points;

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}

	public Map<String, Point> getPoints() {
		return points;
	}


	public void draw() {
		Iterator<Map.Entry<String, Point>> itr = this.points.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Point>  mp = itr.next();
			System.out.println(mp.getKey()+" "+ mp.getValue().getX() +","+mp.getValue().getY());
		}
	}

}
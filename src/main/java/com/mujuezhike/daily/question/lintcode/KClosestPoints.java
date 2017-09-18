package com.mujuezhike.daily.question.lintcode;

import java.util.LinkedList;

public class KClosestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		KClosestPoints kcp = new KClosestPoints();
//		MPoint ppo = new MPoint(0,0);
//		MPoint pp1 = new MPoint(3,3);
//		MPoint pp2 = new MPoint(2,4);
//		int rr = kcp.near(ppo,pp1,pp2);
//		System.out.println(rr);
		
		KClosestPoints ma = new KClosestPoints();
		Point origin = new Point(0,0);
		Point p1 = new Point(15,10);
		Point p2 = new Point(23,10);
		Point p3 = new Point(23,13);
		Point p4 = new Point(21,15);
		Point p5 = new Point(13,22);
		Point p6 = new Point(12,25);
		Point p7 = new Point(22,12);
		Point p8 = new Point(21,21);
		Point p9 = new Point(14,14);
		Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9};
		
//		MPoint pp1 = new MPoint(3,3);
//		MPoint pp2 = new MPoint(2,4);
		Point[] pp = ma.kClosest(points, origin, 9);
		System.out.println(pp[0].x + ":" + pp[0].y);
		System.out.println(pp[1].x + ":" + pp[1].y);
		System.out.println(pp[2].x + ":" + pp[2].y);
		System.out.println(pp[3].x + ":" + pp[3].y);
		System.out.println(pp[4].x + ":" + pp[4].y);
		System.out.println(pp[5].x + ":" + pp[5].y);
		System.out.println(pp[6].x + ":" + pp[6].y);
		System.out.println(pp[7].x + ":" + pp[7].y);
		System.out.println(pp[8].x + ":" + pp[8].y);
	}
	
	 /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
    	
    	KClosestPoints kcp = new KClosestPoints();
		
    	LinkedList<MPoint> list = new LinkedList<MPoint>();
    	MPoint mo = new MPoint(origin);
		
        // Write your code here
    	for(int i=0;i<points.length;i++){
    		
    		MPoint pt = new MPoint(points[i]);
    		int flag = 0;
    		
    		for(int m=0;m<list.size();m++){
    			
    			if(m>k){
    				break;
    			}
    			
    			int s = kcp.near(mo,pt,list.get(m));
    			
    			if(s == 1){
    				
    				flag = 1;
    				
    			}else if(s == 2){
    				
    				if(m>0){
    					list.add(m,pt);
    					flag = 2;
    				}
    				
    				break;
    			}
    			
    		}
    		
    		if(flag==0 && list.size()<k){
    			
    			list.addFirst(pt);
    			
    		}else if(flag == 1 && list.size() >= k){
    			
    			list.addLast(pt);
    			list.removeFirst();
    			
    		}else if(flag == 1){
    			list.addLast(pt);
    		}
    		
    	}
    	Point[] s = new Point[list.size()];
    	for(int i=0;i<list.size();i++){
    		
    		s[i] = list.get(list.size()-1-i);
    		
    	}
    	return s;
    }
    
    public int almostnear(Point origin,Point p1,Point p2){
		
    	int lx1 = p1.x - origin.x;
    	lx1 = lx1>0?lx1:lx1*-1;
    	int lx2 = p2.x - origin.x;
    	lx2 = lx2>0?lx2:lx2*-1;
    	
    	int ly1 = p1.y - origin.y;
    	ly1 = ly1>0?ly1:ly1*-1;
    	int ly2 = p2.y - origin.y;
    	ly2 = ly2>0?ly2:ly2*-1;
    	
    	if((lx1>=lx2)&&(ly1>=ly2))
    	return 2;
    	if((lx1<=lx2)&&(ly1<=ly2))
    	return 1;	
    	
    	return 0;
    }
    
    public int near(MPoint origin,MPoint p1,MPoint p2){
		
    	int e =  almostnear(origin,p1,p2);
    	if(e == 0){
    		e = p1.getM(origin) - p2.getM(origin)>0?2:1;
    	}
    	
    	return e;
    }

}

class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
}

class MPoint extends Point{
    int x;
    int y;
    long m = -1;
    MPoint() { x = 0; y = 0; }
    MPoint(int a, int b) { super.x = a;super.y = b; x = a; y = b; }
    MPoint(Point p){super.x = x = p.x;super.y = y = p.y;}
    long getM(Point o){
    	if(m==-1){
    		m = (x-o.x)*(x-o.x) + (y-o.y)*(y-o.y);
    	}
		return m;
    }
}
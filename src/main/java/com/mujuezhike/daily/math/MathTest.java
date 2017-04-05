package com.mujuezhike.daily.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MathTest {
	
	static Map<Integer,Point> map = new HashMap<Integer,Point>();
	
	public static void main(String[] args){
		
		List<Point> plist = new ArrayList<Point>();
		
		Point p1 =new Point();
		p1.setId(1);
		p1.setX(1);
		p1.setY(2);
		
		Point p2 =new Point();
		p2.setId(2);
		p2.setX(2);
		p2.setY(3);
		
		Point p3 =new Point();
		p3.setId(3);
		p3.setX(1);
		p3.setY(3);
		
		Point p4 =new Point();
		p4.setId(4);
		p4.setX(4);
		p4.setY(4);
		
		Point p5 =new Point();
		p5.setId(5);
		p5.setX(5);
		p5.setY(7);
		
		map.put(1,p1);
		map.put(2,p2);
		map.put(3,p3);
		map.put(4,p4);
		map.put(5,p5);
		
		List<List<Integer>> list = MathTest.generatelist(5);
		
		for(int li=0;li<list.size();li++){
			List<Integer> ilist = list.get(li);
			int ser = isSeries(ilist);
			
			for(int j=0;j<ilist.size();j++){
				
				System.out.print(ilist.get(j) + "|");
				
			}
			
			System.out.print("|| "+ser);
			System.out.println();
			
		}
		
	}
	
	static int isSeries(List<Integer> orderlist){
		
		int ser = 0;
		
		for(int i=0;i<orderlist.size();i++){
			
			Integer inti = orderlist.get(i);
			Point pi = map.get(inti);
			
			double mlength = 0;
			double nlength = 0;
			
			for(int j=i;j<orderlist.size();j++){
				
				Integer intj = orderlist.get(j);
				Point pj = map.get(intj);
				
				double max = ((pj.getX() - pi.getX())*(pj.getX() - pi.getX())) 
						   + ((pj.getY() - pi.getY())*(pj.getY() - pi.getY()));
				
				if(max<mlength){
					ser++;
				}else{
					mlength = max;
				}
				
			}
			
			for(int j=i;j>1;j--){
				
				Integer intj = orderlist.get(j);
				Point pj = map.get(intj);
				
				double max = ((pj.getX() - pi.getX())*(pj.getX() - pi.getX())) 
						   + ((pj.getY() - pi.getY())*(pj.getY() - pi.getY()));
				
				if(max<nlength){
					ser++;
				}else{
					nlength = max;
				}
				
			}
			
		}
		
		return ser;
		
	}
	
	
	
	public static List<List<Integer>> generatelist(int o){
		
		LinkedList<Integer> elist = new LinkedList<Integer>();
		
		if(o==1){
			
			List<List<Integer>> onelist = new ArrayList<List<Integer>>();
			ArrayList<Integer> oolist = new ArrayList<Integer>();
			oolist.add(1);
			onelist.add(oolist);
			return onelist;
					
		}
		
		List<List<Integer>> list = generatelist(o-1);
		
		List<List<Integer>> newlist = new ArrayList<List<Integer>>();
		
		for(int i=0; i<list.size(); i++){
			
			List<Integer> uslist = list.get(i);
			
			for(int io=0;io<o;io++){
				
				elist.clear();
				
				elist.addAll(uslist);
				
				elist.add(io, o);
				
				newlist.add(elist);
			}
			
		}
		
		
		return newlist;
		
	}

}

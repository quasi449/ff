package pack1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	private String name;
	private String team;
	private String pos;
	private int rank;
	private int bye;
	
	//HashMap<String,Player> players=new HashMap<String,Player>();
	
	
	
	
	
	public Player(String name, String team, String pos, int rank,int bye) {
		this.bye=bye;
		this.name = name;
		this.team = team;
		this.pos = pos;
		this.rank = rank;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getTeam() {
		return team;
	}




	public void setTeam(String team) {
		this.team = team;
	}




	public String getPos() {
		return pos;
	}




	public void setPos(String pos) {
		this.pos = pos;
	}




	public double getRank() {
		return rank;
	}




	public void setRank(int rank) {
		this.rank = rank;
	}




	@Override
	public String toString() {
		
		return rank  +" " + name + " " + team + " " + pos+  " " + bye;
		
		//return "Player ["+"rank=" + rank  +", name=" + name + ", team=" + team + ", pos=" + pos
			//	+  ", bye=" + bye + "]";
	}

	
	
	public static void parseFile(String filename){
		
		
		try {
			FileInputStream fstream = new FileInputStream(filename);
			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strline;
			
			 while ((strline = br.readLine()) != null)   {
				 	
				 
				 	//	String s1= strline.substring(strline.indexOf(' '));
				 		int index= strline.indexOf(',');
				 		
				 		String rank=strline.substring(0,index);
				 		
				 		String str2= strline.substring(index+1);
				 		
				 		rank=strline.substring(0,index);
				 		
				 		int index2= str2.indexOf(',');
				 		
				 		String name=str2.substring(0,index2);
				 		
				 		
				 		String str3= str2.substring(index2+1);
				 		
				 		int index3= str3.indexOf(',');
				 		
				 		String pos= str3.substring(0,index3);
				 		
				 		String str4= str3.substring(index3+1);
				 		
				 		int index4= str4.indexOf(',');
				 		
				 		String team= str4.substring(0,index4);
				 		 
				 		String bye= str4.substring(index4+1);
				 		
				 		int ibye= Integer.parseInt(bye);
				 		
				 		int irank= Integer.parseInt(rank);
				 		
				 		//System.out.println (irank+" "+name+ " "+ pos+" "+ team+ " "+ ibye);
				 		
				 		Player p = new Player(name,team,pos,irank,ibye);
				 		
				 		//System.out.println(p);
				 		
				 		Frame.al.add(p);
				 		
				 		
				 		
				 		
				 		
				  }
			 
			 br.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}	
		
		
		
		
	}
	
	
	public static ArrayList<String> sort(ArrayList<Player> pl,String type){
		
		 ArrayList<String> output=new  ArrayList<String>();
		
		for(int n=0; n<pl.size();n++){
			
			Player p = pl.get(n);
			
			if(p.getPos().equalsIgnoreCase(type)){
				
				output.add(p.toString());
				
				//System.out.println(p);
			}
			
				
			
		}
		
		return output;
		
	}
	
	
	
	public static void main(String[] args){
		
		
		parseFile("file.txt");
		
		
		
		ArrayList<String> arr= sort(Frame.al,"wr");
		
		Object[] a=arr.toArray();
		
		for(int n=0; n<arr.size();n++){
			
			System.out.println(arr.get(n));
			
		}
		
		
	}








	public int getBye() {
		return bye;
	}




	public void setBye(int bye) {
		this.bye = bye;
	}
	

}

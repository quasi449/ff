package pack1;


import java.util.ArrayList;



public class Parser {






	private String line;

	private boolean end=false;








public Parser(String line) {

	this.line = line;

}




public String getLine() {

	return line;

}





public boolean getEnd(){

	return end;

}









public void setLine(String line) {

	this.line = line;

}





public String getNext(){



	int index=line.indexOf(',');

	String temp=line;


	//System.out.println(temp);


	if(index>0){
	
			line=line.substring(index+1);

			return temp.substring(0,index);

	}



	else{

			this.end=true;

			return line;

	}



}









@Override

public String toString() {


	return line;

	//return "Parser [line=" + line + "]";

}





public ArrayList<String>toList(){



	ArrayList<String> al= new ArrayList<String> ();


	boolean b=false;


	while(b==false){


		String str= this.getNext();

		//System.out.println(str);

		b=this.getEnd();

		al.add(str);


}


		return al;

}









public static void main(String[] args) {


	String input = "this,is,a,sample,input,line";

 



	Parser pp= new Parser(input);

	String s1=pp.getNext();




	Parser p= new Parser(input);

	ArrayList<String> al= new ArrayList<String>();


	al=p.toList();



	for(int n=0;n<al.size();n++){


		System.out.println(al.get(n));


	}








}



}
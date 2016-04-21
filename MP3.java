import java.util.*;

class MP3{
	public static void main(String[] args) {

		int length;
		int height;
		Scanner scan = new Scanner(System.in);
		String inState="";

		System.out.println("Length: ");
		length = scan.nextInt();
		System.out.println("Height: ");
		height = scan.nextInt();

		do{
			System.out.println("Enter Initial State (must be equal to length): ");
			inState = scan.next();
		}while(inState.length() !=length);
		

		char rule30[][] = new char [height][length+2];

		rule30[0][0] = '0';
		rule30[0][length+1] ='0';

		for(int c=0; c < length; c++){
			rule30[0][c+1] = inState.charAt(c);
		}

		for(int i=0 ; i < height-1 ; i++){
			rule30[i][0] = '0';
			rule30[i][length+1] = '0';

			for(int j=0; j < length;j++){
				rule30[i+1][j+1] = nextColor(rule30[i][j],rule30[i][j+1],rule30[i][j+2]);
			}
		}

		System.out.println("******* RULE 30 *******");

		for(int i=0 ; i < height ; i++){
			for(int j=1; j < length+1; j++){
				System.out.print(rule30[i][j]);
			}
			System.out.println("");
		}


	}


	static char nextColor(char x, char y, char z){
		if(x=='1' && y=='1' && z=='1')
			return '0';
		else if(x=='1' && y=='1' && z=='0')
			return '0';
		else if(x=='1' && y=='0' && z=='1')
			return '0';
		else if(x=='1' && y=='0' && z=='0')
			return '1';
		else if(x=='0' && y=='1' && z=='1')
			return '1';
		else if(x=='0' && y=='1' && z=='0')
			return '1';
		else if(x=='0' && y=='0' && z=='1')
			return '1';
		else
			return '0';
	}
}
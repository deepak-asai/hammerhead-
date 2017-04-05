/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

/**
 *
 * @author deepak
 */
import java.io.*;
import java.util.*;
public class Life {

    
	private int m,n;
	private int x[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	private int y[] = {0, 1, 1, 1, 0, -1, -1, -1};
       
	public char getDirec(char inp[][], int i, int j, int z){
		//return inp[i][j];
		if(i+x[z] >=0 && i+x[z] < m && j+y[z] >=0 && j+y[z] < n ){
			return inp[i+x[z]][j+y[z]];
		}
		else
			return 'z';
	}

	public void print(){
		Scanner s = new Scanner(System.in);
		int na;
                                   
                System.out.println("Enter the number of rows and columns");
		m = s.nextInt();
		n= s.nextInt();
		
                System.out.println("Enter the cells with space in between them");
		char inp[][] = new char [m][n];
		char op[][] = new char [m+2][n+2];
		for(int i =0; i<m; i++){
			for(int j=0; j<n; j++){
				inp[i][j] = s.next().charAt(0);
                                inp[i][j] = Character.toUpperCase(inp[i][j]);
			}
		}
	
                for(int i =0; i<m+2; i++){
			for(int j=0; j<n+2; j++){
				op[i][j] = 'O';
			}
			
		}
		//System.out.println(""+ getDirec(inp, 0,1) );
		int i_min = 1, i_max = m , j_min = 1, j_max =n;
		int cntt=0, cntb=0,cntr=0, cntl=0;
		int flag_i_max = 0, flag_i_min = 0,  flag_j_max = 0, flag_j_min = 0 ;
		for(int i =0; i<m; i++){
			for(int j=0; j<n; j++){

				na = 0;
				for(int z = 0; z<8; z++){
					char c = getDirec(inp, i, j, z);
					if(c == 'X'){
						na++;
					}
					
				}
				op[i+1][j+1] = inp[i][j];
				if(na < 2){
					op[i+1][j+1] = 'O';
				}
				else if(na > 3){
					op[i+1][j+1] = 'O';
				}
				else if(inp[i][j] == 'O' && na == 3){
					op[i+1][j+1] = 'X';
				}

				//Checking top and bottom boundary for toad pattern
				if(i == 0){
					if(inp[0][j] == 'X'){
						cntt++;
						//System.out.println(""+cntt);
					}
					else{	
						cntt=0;
					}

					if(cntt == 3){
						flag_i_min = 1;
						op[i_min-1][j] = 'X';
						cntt--;
					}
				}
				if(i == m-1){
					if(inp[m-1][j] == 'X'){
						cntb++;
					}
					else{
						cntb=0;
					}
				}
				if(cntb == 3){
					flag_i_max = 1;
					op[i_max+1][j] = 'X';
					cntb--;
				}
                                //End of checking top and bottom boundary for toad pattern

				//Checking left and right boundary for toad pattern
				if(j == 0){
					if(inp[i][j] == 'X'){
						cntl++;
						//System.out.println(""+cntl);
					}
					else{
						cntl=0;
					}
					if(cntl == 3){
						//System.out.println("Entered");
						flag_j_min = 1;
						op[i][j_min-1] = 'X';
						cntl--;
					}
				}
				if(j == n-1){
					if(inp[i][j] == 'X'){
						cntr++;
					}
					else{
						cntr=0;
					}
					if(cntr == 3){
						flag_j_max = 1;
						op[i][j_max+1] = 'X';
						cntr--;
					}

				}
                                //End of checking left and right boundary for toad pattern
			}
			
		}
		if(flag_i_min ==1 ){
			i_min--;
		}
		if(flag_i_max ==1){
			i_max++;
		}
		if(flag_j_min ==1 ){
			j_min--;
		}
		if(flag_j_max ==1){
			j_max++;
		}
                
                System.out.println("");
		for(int i = i_min; i<=i_max; i++){
			for(int j = j_min; j<=j_max; j++){
				System.out.print(op[i][j]+ " ");
			}
			System.out.println("");
		}
		

	}
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner s =new Scanner(System.in);
       Life l = new Life();
       char op;
       
       System.out.println("Sample input: ");
       System.out.println("X X X");
       System.out.println("O O O");
       System.out.println("X O X");
       
       do{
            l.print();
            System.out.println("Want to continue? (y/n)");
            op = s.next().charAt(0);
            op = Character.toLowerCase(op);
       }while(op == 'y');
    }

}

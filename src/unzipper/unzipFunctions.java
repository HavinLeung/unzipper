/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unzipper;

/**
 *
 * @author havinleung
 */
public class unzipFunctions {
    /**Changes file path to folder path*/
    public static String fileToFolder(String file) {
        StringBuilder folder = new StringBuilder(file);
        int end = file.length()-1;
        int loop=1;
        int start=end;
        //find directory
        for(int i = end;i>=0&&loop==1;i--){ 
        	if(file.charAt(i)=='/'){
        		start = i;
        		loop = 0;
        	}
        }
        folder.delete(start+1,end+1);
        return folder.toString();
    }
    
    public static int nextpw(char[] pw, int last, int max){//generates next possible password
        while(pw[0]<=126){
            if(pw[last]==126){ //if current character is maxed out, move back to next character
                if(last==0){ //if first character is maxed out, all possibilities exhausted
                    return 0;
                }
                last--;
            }
            if(pw[last]<126){
                pw[last]+=1;
                for(int i = last+1; i<=max;i++){ //reset all characters past "last"
                    pw[i]=33; 
                }
                return 1; 
            }
        }
        return 0;
    }
}

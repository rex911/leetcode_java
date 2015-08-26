/**
 * 
 */
package leetcode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * @author rexliu
 *
 */
public class ValidSudoku {
	
	/**
	 * helper method; check if a nine-element part is valid
	 * 
	 * @param part
	 * @return
	 */
	private boolean isValidPart(char[] part){
		
		HashSet<Character> ex = new HashSet<Character>();
		for (char c: part){
			if (c == '.') continue;
			if (ex.contains(c)) return false;
			ex.add(c);
		}
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
		// handle special cases
		if (board.length != 9 ) return false;
		for (int i = 0;i<9;i++){
			if (board[i].length != 9) return false;
		}
		
		
        for (int i =0; i<9; i++){
        	// check rows
        	if (!isValidPart(board[i])) return false;
        	// check columns
        	if (!isValidPart(new char[] {board[0][i], board[1][i], board[2][i],
        			board[3][i], board[4][i], board[5][i],
        			board[6][i], board[7][i], board[8][i]})) return false;
        }
        //check sub-boxes
        for (int i =0;i<3;i++)
        	for (int j=0;j<3;j++){
        		if (!isValidPart(new char[] {board[i*3][j*3], board[i*3][j*3+1], board[i*3][j*3+2],
            			board[i*3+1][j*3], board[i*3+1][j*3+1], board[i*3+1][j*3+2],
            			board[i*3+2][j*3], board[i*3+2][j*3+1], board[i*3+2][j*3+2]})) return false;
        	}
        return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

package kr.go.gp.util;

public class WordFilter {
	private String[] list = {"새끼", "새꺄", "시발"};
	
	public boolean compare(String keyword){
		boolean k = false;
		for(String w : list){
			if(keyword.contains(w)){
				k = true;
			}
		}
		return k;
	}
}

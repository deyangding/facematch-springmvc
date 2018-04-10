package demo.model;

import java.io.Serializable;

public class Result implements Serializable{
	private static final long serialVersionUID = -1;
	
    private String index_i;
    private String index_j;
    private double score;
    
	public String getIndex_i() {
		return index_i;
	}
	public void setIndex_i(String index_i) {
		this.index_i = index_i;
	}
	public String getIndex_j() {
		return index_j;
	}
	public void setIndex_j(String index_j) {
		this.index_j = index_j;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}

package demo.model;

import java.io.Serializable;
import java.util.List;

public class Match implements Serializable{
	private static final long serialVersionUID = -1;
	

    private String result_num;
    private String log_id;
    private List<Result> result;
    
	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}
	public String getResult_num() {
		return result_num;
	}
	public void setResult_num(String result_num) {
		this.result_num = result_num;
	}
	public String getLog_id() {
		return log_id;
	}
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}
}

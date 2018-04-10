package demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.framework.security.AllowAll;

import demo.model.Match;
import demo.model.Result;
import demo.test.FaceMatch;

@Controller
public class FaceLoginController {
	
	@AllowAll
	@RequestMapping("/login.do")
	public String login(){
		return "face/login";
	}
	
	@AllowAll
	@ResponseBody
	@RequestMapping("/loginUser.do")
	public String loginUser(HttpServletRequest request, String name){
		String reString= FaceMatch.match(name);
		    
		 JSONObject json = JSONObject.parseObject(reString);
	      Match match = JSON.toJavaObject(json, Match.class);
	      Result result= match.getResult().get(0);
	      
	      if (result.getScore()>=90) {
	    	  request.getSession().setAttribute("name", "userName");
		 }
	      
		return json.toString();
	}
}

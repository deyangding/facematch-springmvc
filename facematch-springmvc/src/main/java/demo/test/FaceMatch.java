package demo.test;


import java.net.URLEncoder;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.utils.FileUtil;
import com.baidu.aip.utils.HttpUtil;

import demo.model.Match;
import demo.model.Result;
import demo.service.AuthService;

/**
* 人脸对比
*/
public class FaceMatch {
	
	
	private static String accessToken = AuthService.getAuth();

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
	/**
	 * 
	 * @param name 图片名称
	 * @return
	 */
    public static String match(String name) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/match";
        try {
            // 本地文件路径
            String filePath =  "C:\\temp\\img\\cover.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            
            //摄像头拍照图片路径
            // String filePath2 =  "C:\\temp\\cover.png";
            String filePath2 =  "C:\\temp\\"+name+".jpg";
            byte[] imgData2 = FileUtil.readFileByBytes(filePath2);
            String imgStr2 = Base64Util.encode(imgData2);
            String imgParam2 = URLEncoder.encode(imgStr2, "UTF-8");
            
            String param = "images=" + imgParam + "," + imgParam2;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //自己生成的access_token
           // String accessToken = AuthService.getAuth();
            //String accessToken ="";
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
     String aaaaString= "{\"result\":[{\"index_i\":\"0\",\"index_j\":\"1\",\"score\":11.928344726562}],\"result_num\":1,\"log_id\":4067728568040314}";
      
      JSONObject json = JSONObject.parseObject(aaaaString);
      Match match = json.toJavaObject(json, Match.class);
      Result result= match.getResult().get(0);
      String aa = null;
      
    }
}
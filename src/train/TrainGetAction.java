package train;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonValue;

import common.Action;
import common.JsonConverter;

import org.json.simple.JSONValue;
public class TrainGetAction implements Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			String start_code = request.getParameter("depPlaceId");
			String end_code = request.getParameter("arrPlaceId");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar c1 = Calendar.getInstance();
			String strToday = sdf.format(c1.getTime());

			String key = "JXL40bCK2WGOu/E1WOGjuALpADt64Wb2mQVwNpxiA0bre/V8GozZggM2O01/PaTTyNm0A2JahebDf/PGwW8jbg==";
			URL url=new URL("http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo?"
					+ "serviceKey=DrVFgkqXkuQbgQfBPCyTkqsUDXXukiY3pGLkMGgXwCA%2BMZ2XCGAmvQdQtDm8QlqKejostGbcJSHKR0Ru8n8Weg%3D%3D"
					+ "&numOfRows=100"
					+ "&pageNo=1"
					+ "&depPlaceId="+start_code
					+ "&arrPlaceId="+end_code
					+ "&depPlandTime="+strToday
					+ "&trainGradeCode=00"
					+ "&_type=json");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));

			JSONObject jObject = new JSONObject(br.readLine());

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jObject);
		}catch(Exception e) {
			System.out.println("getTrainTime ERROR : "+e);
		}
	}

}

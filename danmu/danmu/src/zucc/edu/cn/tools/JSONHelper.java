package zucc.edu.cn.tools;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zucc.edu.cn.model.ClassBean;
import zucc.edu.cn.model.DanmuBean;

public class JSONHelper {
	
	public static JSONObject classListToJSON(List<ClassBean> list) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		for (ClassBean classBean : list) {
			JSONObject object = new JSONObject();
			object = JSONObject.fromObject(classBean);
			jsonArray.add(object);
		}
		jsonObject.put("class", jsonArray);
		return jsonObject;
	}
	public static JSONObject danmuListToJSON(List<DanmuBean> list) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		for (DanmuBean danmuBean : list) {
			JSONObject object = new JSONObject();
			object = JSONObject.fromObject(danmuBean);
			jsonArray.add(object);
		}
		jsonObject.put("danmu", jsonArray);
		return jsonObject;
	}

	
}

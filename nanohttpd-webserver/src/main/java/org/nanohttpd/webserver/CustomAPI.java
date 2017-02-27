package org.nanohttpd.webserver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;

public class CustomAPI {

	public Response doApi(String apiName) {
		return doApi(apiName, null);
	}
	
	public Response doApi(String apiName, JSONObject bodyParam) {
		Response res = null;
		
		System.out.println("===================== CustomAPI START ===========================");
		System.out.println("apiName :: " + apiName);
		if (null != bodyParam) {
			System.out.println("bodyParam :: " +  bodyParam.toJSONString());
		}
		System.out.println("===================== CustomAPI END   ===========================");
		
		if (apiName.equals("folderList.do")) {
			JSONObject obj = new JSONObject();
			// obj.put status
			obj.put("status", Status.OK);
		
			JSONArray folders = new JSONArray();
			JSONObject folder = new JSONObject();
			folder.put("name", "2016-12-12");
			folders.add(folder);
			folders.add(folder);
			folders.add(folder);
			
			// obj.put folderlist
			obj.put("folderlist", folders);
			res = Response.newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_HTML, obj.toJSONString());
		}
		
		return res;
	}
}

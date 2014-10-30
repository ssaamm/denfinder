package template.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebApiService {
	public static JSONObject getResponseObj(URI url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response;
		JSONObject result = null;

		try {
			response = client.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				InputStream in = entity.getContent();
				result = new JSONObject(getStringFromStream(in));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			result = new JSONObject();
		}

		return result;
	}

	public static JSONArray getResponseArr(URI url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response;
		JSONArray result = null;

		try {
			response = client.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				InputStream in = entity.getContent();
				result = new JSONArray(getStringFromStream(in));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			result = new JSONArray();
		}

		return result;
	}

	public static URI encodeUrl(String base, Map<String, String> params, boolean encodeParams)
			throws URISyntaxException {
		String url = base + "?";
		boolean first = true;
		try {
			for (Map.Entry<String, String> kvp : params.entrySet()) {
				url += (first ? "" : "&")
						+ (encodeParams ? URLEncoder.encode(kvp.getKey(), "UTF-8") : kvp.getKey())
						+ "="
						+ (encodeParams ? URLEncoder.encode(kvp.getValue(), "UTF-8") : kvp
								.getValue());
				if (first)
					first = false;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new URI(url);
	}

	public static URI encodeUrl(String base, Map<String, String> params) throws URISyntaxException {
		return encodeUrl(base, params, true);
	}

	// TODO: This probably shouldn't be here
	private static String getStringFromStream(InputStream in) {
		java.util.Scanner s = new java.util.Scanner(in);
		java.util.Scanner s2 = s.useDelimiter("\\A");
		String result = s2.hasNext() ? s2.next() : "";
		s.close();
		s2.close();
		return result;
	}
}

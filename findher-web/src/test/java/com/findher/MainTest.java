package com.findher;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MainTest {
	public static void main(String[] ar) throws Exception {
		for (int i = 0; i < 1; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					doRequestByJdk();
				}
			});
			t.start();
			Thread.sleep(2000);
		}
//		doRequestByJdk();
	}

	private static void doRequestByJdk() {
		System.out.println("开始时间："+System.currentTimeMillis());
		try {
			for(int i=0;i<100;i++){
//				System.out.println("========>>>"+i);
				URL a = new URL("http://localhost/findher/keepAlive.do");
				HttpURLConnection conn = (HttpURLConnection)a.openConnection();
	
//				System.out.println("默认request1 properties："+conn.getRequestProperties());
				conn.addRequestProperty("Connection", "keep-alive");
//				System.out.println("新request1 properties："+conn.getRequestProperties());
				conn.connect();
	
				Map<String, List<String>> map = conn.getHeaderFields();
//				System.out.println(map.toString());
				InputStream is = conn.getInputStream();
				int ret = 0;
				byte[] buf = new byte[conn.getContentLength()];
				while ((ret = is.read(buf)) > 0) {
//					System.out.println(new String(buf));
				}
				is.close();
//				System.out.println("========<<<<"+i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("结束时间："+System.currentTimeMillis());
	}
	
	private void doRequestByClient() throws Exception{
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://localhost/findher/keepAlive.do");
		httpGet.setHeader("Connection", "Keep-Alive");
		// httpGet.setHeader("Connection","close");
		HttpResponse response1 = httpclient.execute(httpGet);

		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the
		// network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST either fully consume the response content or abort
		// request
		// execution by calling HttpGet#releaseConnection().

		try {
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			BufferedInputStream inputStream = new BufferedInputStream(entity1.getContent());
			byte[] bs = new byte[100];
			inputStream.read(bs);
			// System.out.println("================="+new String(bs));
			// do something useful with the response body
			// and ensure it is fully consumed
			// EntityUtils.consume(entity1);
		} finally {
			httpGet.releaseConnection();
		}

		// HttpPost httpPost = new HttpPost("http://targethost/login");
		// List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// nvps.add(new BasicNameValuePair("username", "vip"));
		// nvps.add(new BasicNameValuePair("password", "secret"));
		// httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		// HttpResponse response2 = httpclient.execute(httpPost);
		//
		// try {
		// System.out.println(response2.getStatusLine());
		// HttpEntity entity2 = response2.getEntity();
		// // do something useful with the response body
		// // and ensure it is fully consumed
		// EntityUtils.consume(entity2);
		// } finally {
		// httpPost.releaseConnection();
		// }
	}
}

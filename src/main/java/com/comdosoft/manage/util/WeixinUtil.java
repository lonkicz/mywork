package com.comdosoft.manage.util;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSONObject;

public class WeixinUtil {

	public static final String token = "weixin_dev";
	public static final String APPID = "";
	public static final String APPSECRET = "";
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] array = new String[]{token,timestamp,nonce};
		Arrays.sort(array);//字典顺序排序
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]);	//拼接成字符串
		}
		String encrypted = DigestUtils.sha1Hex(sb.toString());//sha1加密
		if(encrypted.equals(signature)){
			return true;
		}
		return false;
	}
	
	public static JSONObject doGetStr(String url){
		return null;
	}
	
}

package com.comdosoft.manage.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comdosoft.manage.beans.TextMessage;
import com.comdosoft.manage.util.MessageUtil;
import com.comdosoft.manage.util.WeixinUtil;

@Controller("access")
public class WechatAccessController {
	
	@RequestMapping(value="check",method=RequestMethod.GET)
	public String check(HttpServletRequest request,String signature,
			String timestamp, String nonce, String echostr){
		if(WeixinUtil.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		return null;
	}
	
	@RequestMapping(value="check",method=RequestMethod.POST)
	public String access(HttpServletRequest request,String signature,
			String timestamp, String nonce, String echostr,HttpServletResponse response) 
					throws UnsupportedEncodingException{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Map<String,String> map = new HashMap<String,String>();
		try {
			map = MessageUtil.xmlToMap(request);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			if("text".equals(msgType)){
				TextMessage tm = new TextMessage();
				tm.setFromUserName(toUserName);
				tm.setToUserName(fromUserName);
				tm.setContent("your sended msg is"+content);
				tm.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				tm.setMsgType("text");
				return MessageUtil.textMessageToXml(tm);
			}else if("event".equals(msgType)){
				String eventType = map.get("Event");
				if("subscribe".equals(eventType)){
					//菜单
				}else if("CLICK".equals(eventType)){
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}

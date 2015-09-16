package com.comdosoft.manage.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.comdosoft.manage.beans.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
	public static Map<String,String> xmlToMap(HttpServletRequest request) 
			throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		InputStream in = request.getInputStream();
		Document doc = reader.read(in);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		in.close();
		return map;
		
	}
	
	public static String textMessageToXml(TextMessage textMessage){
		XStream xsTream = new XStream();
		xsTream.alias("xml", textMessage.getClass());
		return xsTream.toXML(textMessage);
	}
}

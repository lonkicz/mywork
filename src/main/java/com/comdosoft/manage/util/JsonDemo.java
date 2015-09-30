/*******************************************************************************
 * Copyright (c) 2005, 2015 caozhen
 *
 * Version 2.0 
 *******************************************************************************/
package com.comdosoft.manage.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 演示fastjson的基本使用.
 * 
 * @author caozhen
 */
public class JsonDemo {
	
	public static void main(String[] args) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("name", "caozhen");
		map.put("age", 25);
		map.put("address", "US NewYork");
		System.out.println(JSON.toJSONString(map,true));//parse对象为json字符串
		String str = "{\"name\":\"A\",\"age\":2}";
		JSONObject obj = JSON.parseObject(str);//parse json字符串为json对象
		System.out.println(obj.get("age"));
		User user = new User("liming",1004f,23);
		User user1 = new User("baby",2000f,28);
		List<Object> list = new ArrayList<Object>();
		list.add(user);
		list.add(user1);
		System.out.println(JSON.toJSONString(list));
		String str1 = "[{\"age\":23,\"name\":\"liming\",\"salary\":1000},"+
				"{\"age\":23,\"name\":\"liming\",\"salary\":1000}]";
		JSONArray jsonArray = new JSONArray();
		jsonArray = JSON.parseArray(str1);//parse json字符串为json对象
		for(int i=0;i<jsonArray.size();i++){
			System.out.println(jsonArray.get(i).toString());
			
		}
	}
	
}

/**
 * 包含Money属性的对象.
 */
class User {
	private String name;
	private Float salary;
	private int age;

	public User(String name, Float salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
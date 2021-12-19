package com.jsikmc15.ktfctest.ktfcDatas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {
	
	@Autowired
	private RestConfig config;
	
	@GetMapping(value="/auth/AuthCode.do",produces ="application/json; charset=UTF-8" )
	public Map getAuthCode() {
		System.out.println("<============ Autho 인증 로직  ===================>");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.setAccessControlAllowOrigin("*");
		headers.setAccessControlAllowCredentials(true);
		HttpEntity entity = new HttpEntity(headers);
		
		String url = "https://developers.kftc.or.kr/proxy/oauth/2.0/authorize?response_type=code&client_id=d39e6903-3e83-4995-977d-252215520364&redirect_uri=http%3A%2F%2Flocalhost%3A9575%2Fktfctest%2Fauth%2FauthTest.do&scope=login%20inquiry%20transfer&client_info=test&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&auth_type=0&cellphone_cert_yn=Y&authorized_cert_yn=Y&account_hold_auth_yn=N&register_info=A";
		System.out.println(url);
		ResponseEntity<Map> response = config.restTemplate().exchange(
				url,
				HttpMethod.GET, 
				entity, Map.class);
		
		/*
		
			같은 url 인데 포스트맨은 되고 왜 프로젝트는 안될까 ? -->강사님께 질문던지자
		*/
		System.out.println("갔다왔습니다~");
		System.out.println("response : " + response.getHeaders());
		
		for(Object entry : response.getBody().keySet()) {
			
			System.out.println((String)entry + " - " + response.getBody().get(entry));
		}
//		String loc = response.getHeaders().getLocation().toASCIIString();
//		System.out.println("얘가말하는 Loc 함수 :" +loc);
//		String myLoc = response.getHeaders().get("Location").get(0);
//		System.out.println("내가 찾아본 Loc :" +myLoc);
		Map map = new HashMap();
		map.put("location", "dtd");
		return map;
	}
	
	
	@RequestMapping(value="/auth/AuthToken.do",produces="application/json; charset=UTF-8")
	public Map authToken(@RequestBody Map map) {
		System.out.println("<================ token 인증 로직 ========================>");
		for(Object entry : map.keySet()) {
			
			System.out.println((String)entry + " - " + map.get(entry));
		}
		System.out.println("<================ Data Sending ========================>");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAccessControlAllowOrigin("*");
		headers.setAccessControlAllowCredentials(true);

		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
		params.add("code", map.get("code").toString());
		params.add("client_id", map.get("client_id").toString());
		params.add("client_secret", map.get("client_secret").toString());
		params.add("redirect_uri", map.get("redirect_uri").toString());
		params.add("grant_type", map.get("grant_type").toString());
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(params,headers);
		
		String url = "https://developers.kftc.or.kr/proxy/oauth/2.0/token";
		System.out.println(url);
		System.out.println(entity.getHeaders());
		System.out.println(entity.getBody());
		ResponseEntity<Map> response = config.restTemplate().exchange(
				url,
				HttpMethod.POST, 
				entity, Map.class);
		
		/*
		
			같은 url 인데 포스트맨은 되고 왜 프로젝트는 안될까 ? -->강사님께 질문던지자
		*/
		System.out.println("갔다왔습니다~");
		for(Object entry : response.getBody().keySet()) {
		
			System.out.println((String)entry + " - " + response.getBody().get(entry));
		}
		
		return map; 
	}
	
	
}

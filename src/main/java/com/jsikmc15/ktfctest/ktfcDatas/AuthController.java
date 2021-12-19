package com.jsikmc15.ktfctest.ktfcDatas;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

//	@RequestMapping("/auth/RequestAuth.do")
//	public void requestAuth(HttpServletResponse resp) throws IOException {
//		
//		System.out.println("여기 먹음!");
////		resp.sendRedirect("https://twww.openbanking.or.kr/apt/mobileweb/authorizeNewGW?sessionID=b1751331-f2ac-4855-9012-c33ae6987c0f&action=Grant&api_tran_id=5994a730-7e5d-4d43-873a-c89a92d700ff&gw_svc_id=faf66bd6cafdf009a37caaac77ba5194&gw_app_key=d39e6903-3e83-4995-977d-252215520364&response_type=code&client_id=d39e6903-3e83-4995-977d-252215520364&client_info=test&redirect_uri=http://localhost:9575/ktfctest/auth/authTest.do&scope=login+inquiry+transfer&auth_type=0&lang=kor&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&account_hold_auth_yn=N&register_info=A&authorized_cert_yn=Y&cellphone_cert_yn=Y ");
//	}

//	@RequestMapping("/auth/RequestAuth.do")
//	public void requestAuth(HttpServletResponse resp) throws IOException {
//		
//		System.out.println("정답이다");
////		resp.sendRedirect("https://twww.openbanking.or.kr/apt/mobileweb/authorizeNewGW?sessionID=b1751331-f2ac-4855-9012-c33ae6987c0f&action=Grant&api_tran_id=5994a730-7e5d-4d43-873a-c89a92d700ff&gw_svc_id=faf66bd6cafdf009a37caaac77ba5194&gw_app_key=d39e6903-3e83-4995-977d-252215520364&response_type=code&client_id=d39e6903-3e83-4995-977d-252215520364&client_info=test&redirect_uri=http://localhost:9575/ktfctest/auth/authTest.do&scope=login+inquiry+transfer&auth_type=0&lang=kor&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&account_hold_auth_yn=N&register_info=A&authorized_cert_yn=Y&cellphone_cert_yn=Y ");
//		resp.sendRedirect("https://www.naver.com");
//	}
//	
	@RequestMapping("/auth/RequestAuth.do")
	public String requestAuth(@RequestParam Map map) {
		if(map.get("code")!=null) {
			System.out.println("Code 값 들어옴!!");
			System.out.println(map.get("code"));
		}
		System.out.println("이리가보자");

		return "auth/ClosePage";
	}
	
	
}

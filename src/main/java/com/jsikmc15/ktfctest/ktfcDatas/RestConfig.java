package com.jsikmc15.ktfctest.ktfcDatas;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/*
 * 	주로 외부라이브러리를 빈으로 등록할 때
 */

@Configuration
public class RestConfig {
	
	/*
	 *  반환타입 : IoC 컨테이너
	 * 	메소드명: 생성된 빈의 이름
	 * 	RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactory)
	 *  내부적으론 Connection URL을 쓴다는것임
	 *  
	 *  RestTemplate : 
	 *  	setMaxConnection 연결 유지 최대 수
	 *  	setMAxConnPerRoute 라우트 당 연결 수
	 *  	setConnectionTimeToLive 연결 만료시간(시간과 해당 시간에 대한 단위)
	 *  
	 */
	
	@Bean
	public RestTemplate restTemplate() {
		
		//httpClient 먼저 생성[Connection - pool 사용을 위한 객체임]
		CloseableHttpClient httpClient = HttpClientBuilder.create()
				.setMaxConnTotal(50)
				.setMaxConnPerRoute(50)
				.setConnectionTimeToLive(5,TimeUnit.SECONDS )
				.build();
		
		//타임아웃 설정을 위한 객체임 
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	
		//해당 타임아웃을 넘어가면 예외를 발생시키고 더이상 요청을 보내지 않음
		factory.setConnectTimeout(3000);
		//httpclient와 동기
		factory.setHttpClient(httpClient);
		
		
		//Async 계열은 비동기식 처리를 할때 사용한다
		//
		return new RestTemplate(factory);
	}
	
	
	
	
}

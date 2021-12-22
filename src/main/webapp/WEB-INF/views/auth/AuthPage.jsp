<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<jsp:include page="/WEB-INF/views/template/top.jsp"/>
<jsp:include page="/WEB-INF/views/template/header.jsp"/>

<!-- Banner -->
							
							<!-- Section -->
								<section>
									<header class="major">
										<h2>Access 토큰 얻기</h2>
									</header>
									<div>
										<a href="#" id="getAuth" class="button">실 인증용</a>
										<script>
											$('#getAuth').on('click',function(){
												//event.preventDefault();
												
												var nlocation = "https://twww.openbanking.or.kr/apt/mobileweb/authorizeNewGW"+
												"?sessionID=b1751331-f2ac-4855-9012-c33ae6987c0f&action=Grant&api_tran_id=5994a730-7e5d-4d43-873a-c89a92d700ff&"+
												"gw_svc_id=faf66bd6cafdf009a37caaac77ba5194&gw_app_key=d39e6903-3e83-4995-977d-252215520364&response_type=code&"+
												"client_id=d39e6903-3e83-4995-977d-252215520364&client_info=test&redirect_uri=http://localhost:9575/ktfctest/auth/authTest.do&"+
												"scope=login+inquiry+transfer&auth_type=0&lang=kor&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&account_hold_auth_yn=N&register_info=A&authorized_cert_yn=Y&cellphone_cert_yn=Y "
												
												var nlocation2 = "https://twww.openbanking.or.kr/apt/mobileweb/authorizeNewGW?sessionID=7f3a0a72-4d5a-4494-9aaa-783f19842564&action=Grant&api_tran_id=70876fa1-e2c2-48dd-a753-046bc542cf2d&gw_svc_id=faf66bd6cafdf009a37caaac77ba5194&gw_app_key=d39e6903-3e83-4995-977d-252215520364&response_type=code&client_id=d39e6903-3e83-4995-977d-252215520364&client_info=test&redirect_uri=http://localhost:9575/ktfctest/auth/authTest.do&scope=login+inquiry+transfer&auth_type=0&lang=kor&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&account_hold_auth_yn=N&register_info=A&authorized_cert_yn=Y&cellphone_cert_yn=Y"
												var tmpWindow=window.open(nlocation2,"",'_blank,width=900,height=880,menubar=false')
											})
										</script>
										
										<a href="#" id="getTest" class="button">테스트용</a>
										<a href="#" id="getAjax" class="button">ajax테스트용</a>
										<br><p>여기에 데이터 박힘</p>
										
										<script>

										$('#getTest').on('click',function(){
											//event.preventDefault();
											
											var nlocation = '<c:url value="/auth/RequestAuth.do"/>'
											var tmpWindow=window.open(nlocation,"",'_blank,width=900,height=880,menubar=false')
										})
											$("#getAjax").on('click',function(){
											
												$.ajax({
													url: '<c:url value="/auth/AuthCode.do"/>',
													type: 'GET',
													success:function(data){
														console.log("메세지는 잘오고가는데 ?")
														console.log(data);
														console.log(data.location);
													},
													error:function(e){
														console.log(e)
													}
											
												})
												
											})
											
										
										</script>
									</div>
									<br/><br/><br/><br/><br/>
									<div>
										<form method="post" action="#">
														<div class="row gtr-uniform">
															<input type="hidden" name="grant_type" value="authorization_code"/>
															
															<div class="col-6 col-12-xsmall">
																<input type="text" id="getTestResult" name="code" value="" placeholder="건들기 ㄴㄴ" />
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="client_id" id="clientId" value="" placeholder="client_ID" />
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="client_secret" id="clientSecret" value="" placeholder="client_secret" />
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="redirect_uri" id="redirectUrl" value="http://localhost:9575/ktfctest/auth/authTest"/>
												
															</div>
												
															
															<!-- Break -->
															<div class="col-12">
																<ul class="actions">
																	<li><input type="submit" value="Send Message" class="primary" /></li>
																	<li><input type="button" value="Reset" id="getTokenAjax"/></li>
																	<script>
																		$("#getTokenAjax").click(function(){
																			console.log('ajax로 수행합니다.');
																			console.log($('#clientId').val())
													
																			$.ajax({
																				url: '<c:url value="/auth/AuthToken.do"/>',
																				type: 'POST',
																				data:JSON.stringify({
																					  "code": $("#getTestResult").val(),
																					  "client_id": $('#clientId').val(),
																					  "client_secret": $('#clientSecret').val(),
																					  "redirect_uri": $('#redirectUrl').val(),
																					  "grant_type": "authorization_code"
																					}),
																				//dataType:'json',
																				contentType: "application/json;",
																				success:function(data){
																					console.log(data);
																					console.log(data.location);
																				},
																				error:function(){
																					
																				}
																			})
																		})
																	
																	</script>
																</ul>
															</div>
											
														</div>
													</form>
									</div>
									
								</section>

							

						</div>
					</div>

<jsp:include page="/WEB-INF/views/template/slide.jsp"/>
<jsp:include page="/WEB-INF/views/template/footer.jsp"/>
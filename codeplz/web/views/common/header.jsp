<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/codeplz.css" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<script type="text/javascript">
			$(document).ready(function () {
				$('#sidebarCollapse').on('click', function () {
					$('#sidebar').toggleClass('active');
					$(this).toggleClass('active');
				});
			}); 
		</script>
		<div class="wrapper">
			<nav id="sidebar">
				<div class="sidebar-header">
					<div class="before-login">
						<ul class="list-unstyled CTAs">						
                    		<li><a href="#" class="login-btn">로그인 / 회원가입</a></li>
                		</ul>
                	</div>
					<form class="search-wraper">
  						<div class="input-group">
    						<input type="text" class="form-control" placeholder="Search">
    						<div class="input-group-btn">
      							<button class="btn btn-default" id="search-btn" type="submit">
        							<i class="glyphicon glyphicon-search"></i>
      							</button>
    						</div>
  						</div>
        			</form>
				</div>

				<ul class="list-unstyled components">
				<!-- <p>Dummy Heading</p> -->
					<li>
						<a href="/codeplz/selectList.bo">공지사항</a>
					</li>
					<li>
						<a href="#">Q & A</a>
					</li>
					<li>
						<a href="#">정보</a>
					</li>
					<li>
						<a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">커뮤니티</a>
						<ul class="collapse list-unstyled" id="pageSubmenu">
							<li><a href="#">잡담</a></li>
							<li><a href="#">토론</a></li>
							<li><a href="#">회사정보</a></li>
							<li><a href="#">구인구직</a></li>
						</ul>
					</li>
				</ul>
            </nav>
            
            <div id="content">

                <nav class="navbar navbar-default" id="navbarTop">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" id="sidebarCollapse" class="navbar-btn">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                        
                            <a  class="logo-Btn-Top navbar-fixed-top" href="/codeplz/index.jsp">
                    		<img src="/codeplz/resources/images/text_logo.png"/>
                    		</a>
                            
                            <!-- <div class="search-wraper">
  								<div class="input-group">
    								<input type="text" class="form-control" placeholder="Search">
    								<div class="input-group-btn">
      									<button class="btn btn-default" type="submit">
        									<i class="glyphicon glyphicon-search"></i>
      									</button>
    								</div>
  								</div>
                    		</div> -->
                            
                            <!-- <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
									data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only"></span>
								접속하기
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
 -->                        </div>
                        
						<!-- <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#">Page</a></li>
                                <li><a href="#">Page</a></li>
                                <li><a href="#">로그인</a></li>
                                <li><a href="#">회원가입</a></li>
                            </ul>
                        </div> -->
                    </div>
                </nav>
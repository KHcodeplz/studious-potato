<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.board.model.vo.*, java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>코드좀-메인</title>
<%@ include file="../common/header.jsp"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>


<div class="row">
	<div class="col-12">
		<caption>
			<h3>메뉴판</h3>
		</caption>
		<table class="table">
			<div class="btn-group btn-group-toggle" data-toggle="buttons">
				<label class="btn btn-secondary active"> <input type="radio"
					name="options" id="option1" autocomplete="off" checked> 조회순
				</label> <label class="btn btn-secondary"> <input type="radio"
					name="options" id="option2" autocomplete="off"> 추천순
				</label> <label class="btn btn-secondary"> <input type="radio"
					name="options" id="option3" autocomplete="off"> 최신순
				</label> <label class="btn btn-secondary active"> <input
					type="radio" name="options" id="option1" autocomplete="off" checked>
					어쩌구저쩌구
				</label> 
				<form class="search-wraper">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" style="margin-left: 60px; margin-right: 0px;'">
						<div class="input-group-btn" style="margin-right: 0px;">
							<button class="btn btn-default" id="search-btn" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>

			<thead>
				<tr>
					<th scope="col" width="10%"></th>
					<th scope="col" width="70%">제목</th>
					<th scope="col" width="10%">작성</th>
				<!-- 	<th scope="col" width="15%">추천수</th> -->
					<th scope="col" width="10%">조회</th>

				</tr>
			</thead>
			<% for(Board b : list){ %>
			<tbody>
				<tr>
					<th scope="row"><%=b.getCol_board_index() %></th>
					<td><%=b.getCol_board_title() %></td>
					<td><%=b.getCol_board_writer() %></td>
					<%-- <td><%=b.getCol_board_count() %></td> 추천수 미구현--%> 
					<td><%=b.getCol_board_hits() %></td>
				</tr>
				<%} %>
	
			</tbody>
		</table>
	</div>
	<button type="button" class="btn btn-primary" align="center">공지글
		작성</button>
</div>
<!-- 페이징 처리할 부분 -->
      <!-- <br><br><br><br><br> -->
      <div class="pagingArea" align="center">
         <button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=1'"><<</button>
         <%  if(currentPage <= 1) {  %>
         <button disabled><</button>
         <%  } else { %>
         <button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage - 1 %>'"><</button>
         <%  } %>
         
         <% for(int p = startPage; p <= endPage; p++) {
               if(p == currentPage) {
         %>
            <button disabled><%= p %></button>
         <%      } else { %>
            <button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%= p %>'"><%= p %></button>
         <%      } %>
         <% } %>
            
         <%  if(currentPage >= maxPage) {  %>
         <button disabled>></button>
         <%  } else { %>
         <button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage + 1 %>'">></button>
         <%  } %>
         <button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%= maxPage %>'">>></button>
      </div>
      <br><br>
      
      <%-- <div class="searchArea" align="center">
         <select id="searchCondition" name="searchCondition">
            <option>---</option>
            <option value="writer">작성자</option>
            <option value="title">제목</option>
            <option value="content">내용</option>
         </select>
         <input type="search">
         <button type="submit">검색하기</button>
         <% if(m != null){ %>
            <button onclick="location.href='views/board/boardInsertForm.jsp'">작성하기</button>
         <% } %>
         
      </div> --%>


<!-- <div class="line"></div> -->

<!-- <div class="jumbotron index_jumbotron">
				<h1 class="text-center">CodePlz</h1>
				<br />
				<p class="text-center"><a class="btn btn-primary" href="#" role="button">들어가기</a></p>
			</div> -->
<%@ include file="../common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="com.board.model.vo.*, java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<%Board b = (Board)request.getAttribute("b"); %>
<title>제목 - codeplz</title>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
   $(document).ready(function() {
      $('fieldset').on('keyup', 'textarea', function(e) {
         $(this).css('height', 'auto');
         $(this).height(this.scrollHeight);
      });
      $('fieldset').find('textarea').keyup();
   });
</script>
<h3><a href="/codeplz/selectList.bo"><%=b.getCol_board_category_index() %></a></h3>
<div class="col-12" class="panel panel-default clearfix">
   <div class="panel-heading clearfix" id="boardInfo">
      <div class="avatar avatar-medium clearfix pull-left">
         <div class="avatar-info">
            <h2 class="panel-title"><%=b.getCol_board_title() %></h2>
            <div class="date-created">
               <p><span class="timeago"><%=b.getCol_board_inserted_date() %></span></p>
            </div>
         </div>
      </div>
      <div class="tag-container">
         <div class="content-tags" id="tags">
            <a href="#" class="list-group-item-text item-tag label label-info"><%=b.getCol_board_tags() %></a>
         </div>
      </div>
      <div class="content-identity pull-right">
        <div class="content-identity-count">조회수 &nbsp; <%=b.getCol_board_hits() %></div>
      </div>
   </div>

   <div class="content-container clearfix">
      <div class="panel-body content-body pull-left content-form">
         <a href="#"><%=b.getCol_board_writer() %></a>(티어)
         <hr />
         <article class="content-text"><%=b.getCol_board_content() %></article>
      </div>
      <br /><br />
   <button class="btn-delete pull-right btn btn-success">삭제하기</button>
   <button class="btn-modify pull-right btn btn-success">수정하기</button>
   </div>

   <br /><br /><br />
   
   <!-- 댓글창 -->
   <div class="panel panel-default clearfix"">
      <ul class="list-group">
         <li class="list-group-item note-title">
            <h3 class="panel-title">댓글</h3>
         </li>
         <li class="list-group-item note-item clearfix">
            <div class="content-body panel-body pull-left" id="panel-body">
               <div class="avatar avatar-medium clearfix">
                  <div class="avatar-info">
                     <a href="#">관리자 </a>(티어)
                     <div class="date-created">
                        <p id="p">
                           <span class="timeago">2018-05-30 23:16:45</span>&nbsp;작성&nbsp;&nbsp;
                           <span class="timeago">2018-05-30 23:18:59</span>&nbsp;수정됨
                        </p>
                     </div>
                  </div>
               </div>
               <fieldset class="form">
                  <article class="list-group-item-text note-text">안녕하세요</article>
               </fieldset>
            </div>
         </li>

         <!-- 비회원 댓글창 -->
         <!-- <div class="panel-body">
            <h5 class="text-center"><a href="#">로그인</a>을 하시면 답변을 등록할 수 있습니다.</h5>
         </div> -->

         <!-- 로그인 시 댓글창 -->
         <li class="list-group-item note-form clearfix">
            <form action="#" method="post" class="note-create-form">
               <div class="content-body panel-body pull-left comment-content" style="padding: 0;">
                  <div>
                     <div class="avatar-info">
                        <a href="#">관리자</a>(티어)
                     </div>
                  </div>
                  <fieldset class="form">
                     <textarea class="form-control" placeholder="내용을 입력하세요." style="margin-top: 10px; height: auto;"></textarea>
                  </fieldset>
               </div>
            </form>
            <div class="content-function-cog note-submit-buttons clearfix">
               <input type="submit" class="btn btn-success btn-wide pull-right" value="댓글쓰기" />
            </div>
         </li>
      </ul>

   </div>

</div>

<%@ include file="../common/footer.jsp"%>
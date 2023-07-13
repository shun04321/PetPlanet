<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pet Planet</title>
    <style>
        table {
            background-color: #98C0DC;
            border: none;
            border-spacing: 3px;
            font-family: 'GmarketSansMedium';
        }
        tr {
            background-color: white;
        }
        tr td {
            padding: 20px;
        }
        a {
            text-decoration-line: none; /* 링크의 밑줄 제거 */
            color: inherit; /* 링크의 색상 제거 */
        }
        h1 {
            margin-top: 0;
            margin-bottom: 15px; /* 줄간격을 조절합니다. */
            color: #98C0DC;
        }
        p {
            margin-top: 0;
            margin-bottom: 5px; /* 줄간격을 조절합니다. */
        }
        h4 {
            font-family: 'GmarketSansMedium';
            color: lightgrey;
        }
        @font-face {
            font-family: 'GmarketSansMedium';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }

        input {
            width: 300px;
            height: 32px;
            font-size: 15px;
            border: 0;
            border-radius: 10px;
            outline: none;
            padding-left: 10px;
            background-color: rgb(233, 233, 233);
            font-family: 'GmarketSansMedium';
        }

        .rev-button{
            background-color: #98C0DC;
            color: white;
            padding: 8px 8px;
            border: none;
            cursor: pointer;
            width: 80px;
            text-align: center;
            border-radius: 10px;
            font-size: 13px;
            font-weight: bold;
        }
    </style>
</head>
<jsp:include page="header2.jsp" />
<body align="center">
<br><br><br>
<h1>보낸 친구 신청</h1>
<br><br>
<table align="center">
    <c:forEach items="${sentRequests}" var="request">
        <tr>
            <td style="width:50px;">
                <c:if test="${not empty request.fromMember.kakaoProfileImg}">
                    <img src="${request.fromMember.kakaoProfileImg}" alt="Profile Image" width="30">
                </c:if>
            </td>
            <td style="width:80px;">${request.fromMember.nickname}</td>
            <td style="width:250px;">${request.fromMember.kakaoEmail}</td>
            <td style="width:80px;">
                <form action="/mypage/${memberId}/friends/cancel-request" method="post">
                    <input type="hidden" name="fromId" value="${request.fromMember.memberId}">
                    <button class="rev-button" type="submit">취소</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
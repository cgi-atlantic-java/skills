<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/html" prefix="html"%>
<!DOCTYPE html>

<jsp:useBean id="profile" type="com.cgi.skills.beans.IProfile"
	scope="request" />
<jsp:useBean id="classifications"
	type="com.cgi.skills.beans.Classifications" scope="request" />

<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheets/profile.css">


</head>
<title>${profile.name}</title>

<body>

	<form method="post">
		<c:forEach items="${classifications.allTypes}" var="type">
			<div class="type">
				${type}
				<c:forEach items="${classifications.allOrigins}" var="origin">
					<div class="origin">
						${origin}
						<c:forEach items="${classifications.allCategories}" var="category">
							<div class="category">
								<c:set var="test"
									value="${classifications.getAllSkillAreas(category,type,origin)}" />
								
								<c:if test="${!empty test}">

								${category}

								<c:forEach
										items="${test}"
										var="area">
										<div class="skill">

											<c:set var="currentLevel"
												value="${profile.getSkillLevel(area)}" />

											<label for="${area.id}">${area.name}</label> <select
												name="${area.id}" id="${area.id}">

												<html:option option="${nullLevel}" id="${currentLevel.id}" />

												<c:forEach items="${classifications.allLevels}" var="level">
													<html:option option="${level}" id="${currentLevel.id}" />
												</c:forEach>
											</select>
										</div>
									</c:forEach>
									
								</c:if>
								
							</div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
		<div>
			<input type="submit" name="submit" value="Submit" />
		</div>
	</form>
</body>
</html>
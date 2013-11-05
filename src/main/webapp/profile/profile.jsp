<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/html" prefix="html"%>
<!DOCTYPE html>

<jsp:useBean id="profile" type="com.cgi.skills.beans.IProfile"
	scope="request" />
<jsp:useBean id="classifications" type="com.cgi.skills.beans.Classifications"
    scope="request" />

<html>
<head>
<link rel="stylesheet" type="text/css" href="profile.css">
<title>${profile.name}</title>
</head>

<body>

	<form method="post">
		<c:forEach var="type" items="${classifications.allTypes}">
			<div class="type">
				${type}
				<c:forEach var="origin" items="${classifications.allOrigins}">
					<div class="origin">
						${origin}
						<c:forEach var="category" items="${classifications.allCategories}">
							<div class="category">
								<c:set var="areas"
									value="${classifications.getAllSkillAreas(category,type,origin)}" />
								
								<c:if test="${!empty areas}">

								${category}

								<c:forEach var="area" items="${areas}">
										<div class="skill">

											<c:set var="currentLevel"
												value="${profile.getSkillLevel(area)}" />

											<label for="${area.id}">${area.name}</label>
											<select name="${area.id}" id="${area.id}">
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
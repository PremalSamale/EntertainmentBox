<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/includes.jsp" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<jsp:include page="header.jsp" />
<body>
<div class="container">
	<div class="col-md-12">
		<form action="addMovie" method="post">
			<h2 class="form-heading">Add Movie</h2>
			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span style="color:green">${addMovieMsg}</span>
				<span style="color:red">${addMovieErrMsg}</span>
				<table class="col-lg-12 col-md-12">
					<tr><input required name="title" type="text" class="form-control" placeholder="title" autofocus="true"/></tr>
					<tr><input required name="year" type="number" class="form-control" placeholder="year" autofocus="true"/></tr>
					<tr><input name="actors" type="text" class="form-control" placeholder="actor(s)" autofocus="true"/></tr>
					<tr><input name="director" type="text" class="form-control" placeholder="director" autofocus="true"/></tr>
					<tr><input name="studio" type="text" class="form-control" placeholder="studio" autofocus="true"/></tr>
					<tr><input name="synopsis" type="text" class="form-control" placeholder="synopsis" autofocus="true"/></tr>
					<tr><input name="country" type="text" class="form-control" placeholder="country" autofocus="true"/></tr>
					<tr><input name="image" type="text" class="form-control" placeholder="image" autofocus="true"/></tr>
					<tr><input name="movie" type="text" class="form-control" placeholder="movie" autofocus="true"/></tr>
					<tr>
						<select name="genre" type="text" class="form-control" autofocus="true">
							<option value="" disabled selected>Genre</option>
							<option value="HORROR">HORROR</option>
							<option value="ACTION">ACTION</option>
							<option value="ROMANCE">ROMANCE</option>
							<option value="FICTION">FICTION</option>
							<option value="COMEDY">COMEDY</option>
							<option value="DRAMA">DRAMA</option>
						</select>
					</tr>
					<tr>
						<select name="mpaaRating" type="text" class="form-control" autofocus="true">
							<option value="" disabled selected>MPAA Rating</option>
							<option value="G">G</option>
							<option value="PG">PG</option>
							<option value="PG13">PG-13</option>
							<option value="R">R</option>
							<option value="NC17">NC-17</option>
						</select>
					</tr>
					<tr>
						<select name="availability" type="text" class="form-control" autofocus="true">
							<option value="" disabled selected>Movie Availability</option>
							<option value="FREE">FREE</option>
							<option value="SUBSCRIPTION_ONLY">SUBSCRIPTION_ONLY</option>
							<option value="PAY_PER_VIEW_ONLY">PAY_PER_VIEW_ONLY</option>
							<option value="PAID">PAID</option>
						</select>
					</tr>
					<tr>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Add Movie</button>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>


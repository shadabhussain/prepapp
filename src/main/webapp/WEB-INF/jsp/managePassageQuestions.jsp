<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat,01 Dec 2001 00:00:00 GMT">

<title>Manage Passage Questions</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Prep Manager</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-question">New Item</a></li>
					<li><a href="all-question">All Questions</a></li>
					<li><a href="all-passages">All Passages</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_NEWPASSAGEQUESTION'}">
		
			<div class="container" id="passageQuestionDiv">
				<h3>Passage Title: ${passage.name}</h3>
				<hr>
				<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demo">Show details</button>
				<div id="demo" class="collapse"><pre>${passage.description}</pre></div>
			</div>
			<hr>
			
			<div class="container text-center">
				<h3>Manage Question</h3>
				<hr>
				<form class="form-horizontal" method="POST"
					action="save-passage-question?passageid=${param.id}">

					<input type="hidden" name="id" value="${question.questionID}" />

					<div class="form-group">
						<label class="control-label col-md-3">Question Type</label>
						<div class="col-md-3">
							<select class="form-control form-control-sm" name="type">
								<option>Inference</option>
								<option>Purpose</option>
								<option>Main point</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Description</label>
						<div class="col-md-7">
							<textarea class="form-control" rows="5" id="description"
								name="description"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Option1 Text</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="option1"
								value="${question.option1}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Option2 Text</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="option2"
								value="${question.option2}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Option3 Text</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="option3"
								value="${question.option3}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Option4 Text</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="option4"
								value="${question.option4}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Option5 Text</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="option5"
								value="${question.option5}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Answer</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="answer"
								value="${question.answer}" />
						</div>
					</div>
					<div class="pull-right col-md-7">
						<input type="submit" class="btn btn-primary form-control-lg"
							value="Save" />
					</div>


				</form>

			</div>
		</c:when>
	</c:choose>


	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/index.js"></script>
</body>
</html>
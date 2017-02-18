<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat,01 Dec 2001 00:00:00 GMT">

<title>My Prep Questions Manager | Home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Prep Manager</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="new-question">New Item <span class="sr-only">(current)</span></a></li>
						<li><a href="all-question">All questions</a></li>
						<li><a href="all-passages">All passages</a></li>
					</ul>
					
					
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<c:choose>
			<c:when test="${mode == 'MODE_HOME'}">
				<div class="container" id="homeDiv">
					<div class="page-header">
						<h1>
							My Preparation Manager <small>Powered By Tando Allahyar
								Developers</small>
						</h1>
					</div>
				</div>
			</c:when>
			<c:when test="${mode == 'MODE_QUESTIONS'}">
				<div class="container" id="notesDiv">
					<h3>My Questions</h3>
					<hr>
					<div class="table-responsive">
						<table class="table table-stripped table-bordered">
							<thead>
								<tr>
									<th>Id</th>
									<th>Description</th>
									<th>Type</th>
									<th>SubType</th>
									<th>Option1</th>
									<th>Option2</th>
									<th>Option3</th>
									<th>Option4</th>
									<th>Option5</th>
									<th>Answer</th>
									<th>Answered</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="question" items="${questions}">
									<tr>
										<td>${question.questionID}</td>
										<td>${question.description}</td>
										<td>${question.type}</td>
										<td>${question.subtype}</td>
										<td>${question.option1}</td>
										<td>${question.option2}</td>
										<td>${question.option3}</td>
										<td>${question.option4}</td>
										<td>${question.option5}</td>
										<td>${question.answer}</td>
										<td>${question.isanswered}</td>
										<td><a href="delete-question?id=${question.questionID}"><span
												class="glyphicon glyphicon-trash"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:when>
			<c:when test="${mode == 'MODE_PASSAGES'}">
				<div class="container" id="passagesDiv">
					<h3>My Passages</h3>
					<hr>
					<div class="table-responsive">
						<table class="table table-stripped table-bordered">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Description</th>
									<th>Difficulty</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="passage" items="${passages}">
									<tr>
										<td>${passage.id}</td>
										<td>${passage.name}</td>
										<td>${passage.description}</td>
										<td>${passage.difficulty}</td>
										<td><a href="delete-passage?id=${passage.id}"><span
												class="glyphicon glyphicon-trash"></span></a></td>
										<td><a href="new-passage-question?id=${passage.id}"><span
												class="glyphicon glyphicon-plus"></span></a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>


			</c:when>
			<c:when test="${mode == 'MODE_UPDATE' || mode == 'MODE_NEW'}">
				<div class="form-group">
					<label class="control-label col-md-3 ">Please select</label>

					<div class="col-md-3">


						<select class="form-control form-control-sm" name="action"
							onchange="addSelected(this)">
							<option value="1">Add Question</option>
							<option value="2">Add Passage</option>
						</select>
					</div>
				</div>
				<br>
				<hr>
				<div class="container text-center" id="add-simple-question"
					style="display: none;">
					<h3>Manage Question</h3>
					<hr>
					<form class="form-horizontal" method="POST" action="save-question">

						<input type="hidden" name="id" value="${question.questionID}" />
						<div class="form-group">
							<label class="control-label col-md-3">Subject</label>
							<div class="col-md-3">
								<select class="form-control form-control-sm" name="subjectID">
									<option value="1">Math</option>
									<option value="2">Verbal</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Type</label>
							<div class="col-md-3">
								<select class="form-control form-control-sm" name="type">
									<option></option>
									<option value="1">Verbal</option>
									<option value="2">Math/Quantitative</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">SubType</label>
							<div class="col-md-3">
								<select class="form-control form-control-sm" name="subtype">
									<option></option>
									<option>MCQ</option>
									<option>Multiple answers</option>
									<option>Quantitative comparison</option>
									<option>Numeric entry</option>
									<option>Text completion</option>
									<option>Sentence equivalence</option>
									<option>Reading comprehension</option>
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
				<div class="container text-center" id="add-rc-passage"
					style="display: none;">
					<h3>Manage Reading Comprehension Passage</h3>
					<hr>
					<form class="form-horizontal" method="POST" action="save-passage">

						<input type="hidden" name="id" value="${passage.id}" />

						<div class="form-group">
							<label class="control-label col-md-3">Name</label>
							<div class="col-md-3">
								<input type="text" class="form-control" name="name"
									value="${passage.name}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Difficulty Level</label>
							<div class="col-md-3">
								<select class="form-control form-control-sm" name="difficulty">
									<option value="1">1</option>
									<option value="2">2</option>
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


						<div class="pull-right col-md-7">
							<input type="submit" class="btn btn-primary form-control-lg"
								value="Save Passage" />
						</div>


					</form>

				</div>
			</c:when>
		</c:choose>
	</div>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/index.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("input[type='range']").change(function() {
			var val = $(this).val();
			$(this).next().val(val);
		})
		$(".range-text").change(function() {
			var val = $(this).val();
			$(this).prev().val(val);
		})
	})
</script>
</head>
<body>

	<div class="heading">
		<h2>
			<span class="setcolor">Parameterized Graphics</span>
		</h2>
	</div>
	<div class="row">
		<div id="conditional-div" class="column1">
			<form action="BadgeServlet" method="post">
				<div class="item">
					<div class="content">
						<h4>Applet Properties</h4>
						<label for="fname">Height</label></br>
						<p class="range-field">
							<input type="range"  name="Y1" class="slider" min="1" max="999" step="1"> 
							<input class="range-text" type="text" value="500">

						</p>
						<p class="range-field">
							<label>Width</label> 
							<input type="range" name="X1" class="slider" min="1" max="999" step="1"> 
							<input class="range-text" type="text" value="500">
						</p>
					</div>
					<div class="side-content">
						<h4>Shape Properties</h4>
						<label for="fname">Height</label>
						<p class="range-field">
							<input type="range" name="Y" class="slider" min="0" max="1000"step="1" value="100"> 
							<input class="range-text"type="text" value="200">
						</p>
						<p class="range-field">
							<label>Width</label> <input type="range" name="X" class="slider"min="0" max="1000" step="1" value="200"> 
							<input class="range-text" type="text" value="300">
						</p>
					</div>
				</div>
				<div class="item-elongated">
					<div class="content">
					<br /><br /><br /><br /><br /><br />
						<h4>Text Properties</h4>
						<label>Message</label>
						<p class="range-field">
							<input type="text" name="MESSAGE" placeholder="Your message..">
						</p>
						<label>Font Size </label>
						<p class="range-field">
							<input type="range" name="FTSIZE" class="slider" min="0"
								max="100" value="12">
						</p>
						<label>Font Style </label>
						<p>
							<input name="FTSTYLE" value="BOLD" type="checkbox" id="bold" />
							<label for="bold" id='fontName'><b>Bold</b></label>&nbsp; &nbsp;
							<input name="FTSTYLE" value="ITALIC" type="checkbox" id="italic" />
							<label for="italic" id='fontName'><i>Italic</i></label><br /> <br />
						</p>

					</div>
					<div class="side-content">
					<br /><br /><br />
						<label>Shape</label>
						<p>
							<select id="shape" name="SHAPE">
								<option value="RECT">Rectangle</option>
								<option value="OVAL">Oval</option>
								<option value="ROUNDRECT">Rounded Rectangle</option>
							</select>
						</p>
						<h4>Color Properties</h4>
						<label>Foreground Color </label>
						<p>
							<select id="color" name="COLOR">
								<option value="orange">Orange</option>
								<option value="red">Red</option>
								<option value="black">Black</option>
								<option value="blue">Blue</option>
								<option value="cyan">Cyan</option>
								<option value="darkGray">Dark Gray</option>
								<option value="gray">Gray</option>
								<option value="green">Green</option>
								<option value="lightGray">Light Gray</option>
								<option value="magenta">Magenta</option>
								<option value="pink">Pink</option>
								<option value="white">White</option>
								<option value="yellow">Yellow</option>
							</select>
						</p>
						<label>Background Color </label>
						<p>
							<select id="bgcolor" name="BGCOLOR">
								<option value="gray">Gray</option>
								<option value="black">Black</option>
								<option value="blue">Blue</option>
								<option value="cyan">Cyan</option>
								<option value="darkGray">Dark Gray</option>
								<option value="green">Green</option>
								<option value="lightGray">Light Gray</option>
								<option value="magenta">Magenta</option>
								<option value="orange">Orange</option>
								<option value="pink">Pink</option>
								<option value="red">Red</option>
								<option value="white">White</option>
								<option value="yellow">Yellow</option>
							</select>
				
						</p>
						<br />
						<p>
							<input type="submit" value="Submit">
						</p>
					</div>
				</div>
			</form>
		</div>
		<div id="conditional-div" class="column2">
			<APPLET CODE="ShowShape" HEIGHT="500" WIDTH="500" >
				<PARAM NAME="MESSAGE" VALUE="Welcome">
				<PARAM NAME="SHAPE" VALUE="OVAL">
				<PARAM NAME="COLOR" VALUE="orange">
				<PARAM NAME="BGCOLOR" VALUE="gray">
				<PARAM NAME="X" VALUE="300">
				<PARAM NAME="Y" VALUE="200">
				<PARAM NAME="FTSTYLE" VALUE="BOLD">
				<PARAM NAME="FTSIZE" VALUE="20">
			</APPLET>
		</div>
	</div>
</body>
</html>

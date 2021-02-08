<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Doughnut Chart using chart js</title>
	<link rel="stylesheet" 
	href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>
	
</head>
<body>
	<h1>Top Countries Population Data</h1>
	
	<canvas id="myChart" width="400" height="150"></canvas>
	
	<script type="text/javascript">
		var ctx = document.getElementById("myChart");
		var myChart = new Chart(ctx,{
			type:"doughnut", 
			data: {
		        labels: ['China', 'India', 'U.S.A','Indonesia' , 'Pakistan', 'Brazil', 'Nigeria'],
		        datasets: [{
		            label: 'Top Population',
		            data: [434896346, 369139886, 265149886, 329453775, 271206028, 217428828,211352375],
		            
		            
		            backgroundColor: [
		                'rgba(255, 99, 132, 1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
		            borderColor: [
		                'rgba(255, 99, 132, 1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero: true
		                }
		            }]
		        }
		    }
		});
	</script>
</body>
</html>
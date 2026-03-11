function login(){

let role=document.getElementById("role").value;

if(role==="EMPLOYEE"){
window.location="employee.html";
}else{
window.location="manager.html";
}

}



function logout(){
window.location="login.html";
}



function applyLeave(){

let leaveType=document.getElementById("leaveType").value;
let startDate=document.getElementById("startDate").value;
let endDate=document.getElementById("endDate").value;
let reason=document.getElementById("reason").value;

if(leaveType==="" || startDate==="" || endDate==="" || reason===""){

alert("Please fill all fields");
return;

}

fetch("http://localhost:8080/leave/request",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({

leaveType:leaveType,
startDate:startDate,
endDate:endDate,
reason:reason

})

})

.then(response=>response.json())
.then(data=>{

alert("Leave Request Submitted");

})

}



function viewLeaves(){

fetch("http://localhost:8080/leave/all")

.then(response=>response.json())

.then(data=>{

let output="";

data.forEach(l=>{

let color="black";

if(l.status==="PENDING") color="orange";
if(l.status==="APPROVED") color="green";
if(l.status==="REJECTED") color="red";

output+=`

<p>

Leave Type: ${l.leaveType}<br>
Start Date: ${l.startDate}<br>
End Date: ${l.endDate}<br>

Status: <b style="color:${color}">${l.status}</b>

</p>

<hr>

`

})

document.getElementById("leaveList").innerHTML=output;

})

}



function loadLeaves(){

fetch("http://localhost:8080/leave/all")

.then(response=>response.json())

.then(data=>{

let output="";

data.forEach(l=>{

output+=`

<p>

Leave ID: ${l.id}<br>
Type: ${l.leaveType}<br>
Reason: ${l.reason}<br>
Status: ${l.status}

</p>

<button onclick="approveLeave(${l.id})">Approve</button>
<button onclick="rejectLeave(${l.id})">Reject</button>

<hr>

`

})

document.getElementById("managerLeaves").innerHTML=output;

})

}



function approveLeave(id){

fetch("http://localhost:8080/leave/approve/"+id,{
method:"PUT"
})

.then(()=>alert("Leave Approved"))

}



function rejectLeave(id){

fetch("http://localhost:8080/leave/reject/"+id,{
method:"PUT"
})

.then(()=>alert("Leave Rejected"))

}



function loadCalendar(){

fetch("http://localhost:8080/leave/all")

.then(response=>response.json())

.then(data=>{

let output="";

data.forEach(l=>{

output+=`

<tr>

<td>${l.id}</td>
<td>${l.leaveType}</td>
<td>${l.startDate}</td>
<td>${l.endDate}</td>
<td>${l.status}</td>

</tr>

`

})

document.getElementById("calendarData").innerHTML=output;

})

}



function goBack(){
window.location="employee.html"
}
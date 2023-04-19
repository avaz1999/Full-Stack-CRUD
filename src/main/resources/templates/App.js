var editFromData;

function getFromData() {
    return {
        id: document.getElementById("id").value,
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };
}

function setSuccessMessage(message) {
    document.getElementById("message").innerHTML = message;
}

function setFromData(firstName, lastName, username, password) {
    return {
        id: document.getElementById("id").value = id,
        firstName: document.getElementById("firstName").value = firstName,
        lastName: document.getElementById("lastName").value = lastName,
        username: document.getElementById("username").value = username,
        password: document.getElementById("password").value = password
    };
}

function clearFromData() {
    return {
        id: document.getElementById("id").value,
        firstName: document.getElementById("firstName").value = "",
        lastName: document.getElementById("lastName").value = "",
        username: document.getElementById("username").value = "",
        password: document.getElementById("password").value = ""
    };
}

function editDataCall(id) {
    // call get user details by id API
    fetch("http://localhost:3000/crud/getUserByID?id=" + id, {
        method: "GET",
    })
        .then((res) => res.json())
        .then((response) => {
            console.log("Edit info", response);
            editFromData = response[0];
            setFromData(editFromData.firstName, editFromData.lastName, editFromData.username, editFromData.password);
        });
}

function deleteData(id) {
    fetch("http://localhost:8080/users/" + "id")
        .then((res) => res.json())
        .then((response) => {
            setSuccessMessage(response.message);
            getData();
        });
}

function submitFrom() {
    if (!editFromData)
        addUser();
    else editData();
}


function editData(){
    var formData = getFromData();
    formData["id"] = editFromData.id;
    fetch("http://localhost:3000/crud/updateData",{
        method: "POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(formData),
    })
        .then((res) => res.json())
        .then((response)=>{
            setSuccessMessage(response.message);
            clearFromData();
            getData();
        });
}

function getData() {
    fetch("http://localhost:8080/users")
        .then((res) => res.json())
        .then((response) => {
            var tmpData = "";
            // console.log(response);
            response.forEach((user) => {
                tmpData += "<tr>";
                tmpData += "<td>" + user.id + "</td>";
                tmpData += "<td>" + user.firstName + "</td>";
                tmpData += "<td>" + user.lastName + "</td>";
                tmpData += "<td>" + user.username + "</td>"
                tmpData += "<td>" + user.password + "</td>"
                tmpData +=
                    "<td><button class='btn btn-primary' onclick='editDataCall(`" +
                    user._id +
                    "`)'>Edit</button></td>";
                tmpData +=
                    "<td><button class='btn btn-danger' onclick='deleteData(`" +
                    user._id +
                    "`)'>Delete</button></td>";

                tmpData += "</tr>";
            });
            document.getElementById("thData").innerHTML = tmpData;
        });
}

            function addUser() {
                let payload = getFromData();
                fetch("http://localhost:8080/api/users", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(payload),
                })
                    .then((res) => res.json())
                    .then((response) => {
                        setSuccessMessage(response.message);
                        // clear input lastName and name
                        clearFromData();
                        getData(); // reload table
                    });
            }

const showForm = document.querySelector("#showForm1");

showForm.addEventListener("click", async (e) => {
    e.preventDefault();
    const response = await fetch("http://localhost:8080/users");
    const data = await response.json();
    for (let i = 0; i < data.length; i++) {
        if (document.getElementById("id").value == data[i].id) {
            document.getElementById("name").value = data[i].firstName;
            document.getElementById("lastName").value = data[i].lastName;
            document.getElementById("username").value = data[i].username;
            document.getElementById("username").value = data[i].password;
        }
    }
});
function deleteForm(){
    let  id = parseInt(document.getElementById("id").value);
    fetch("http://localhost:8080/api/users/"+id,{
        method:"DELETE",
    })
        .then((res) => res.json())
        .then((response)=>{
            setSuccessMessage(response.message);
            clearFromData();
            getData();
        });
}
function updateForm(){
    var  formData = getFromData();
    let id = parseInt(document.getElementById("id").value);
    formData["id"] = id;
    fetch("http://localhost:8080/api/users/"+"id",{
        method: "POST",
        headers:{
            "Content-Type":"application/json",
        },
        body:JSON.stringify(formData),
    })
        .then((res) => res.json())
        .then((response)=>{
            setSuccessMessage(response.message);
            clearFromData();
            getData();
        });
}
getData();
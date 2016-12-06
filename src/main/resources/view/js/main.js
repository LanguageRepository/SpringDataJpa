/**
 * Created by kvasa on 04.12.2016.
 */
function getAllContactForUser() {
    $.ajax({
        url: '/contacts/getByUser/1',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            var table = document.getElementById('table1');
            var index, i, j, s;
            var selectSize = data.length;
            document.getElementById('cid').options.length = selectSize;
            var optionValue = document.getElementById('cid').options;
            for(index = data.length - 1, i = 1, j = 0, s = 0; index >= 0; --index, i++, j++, s++) {
                var tableRow = table.insertRow(i);
                var firstCell = tableRow.insertCell(0);
                var secondCell = tableRow.insertCell(1);
                var thirdCell = tableRow.insertCell(2);
                var fourthCell = tableRow.insertCell(3);
                var fifthCell = tableRow.insertCell(4);
                firstCell.innerHTML = s;
                secondCell.innerHTML = "<a href=\"#\">" + data[j].name + "</a>";
                thirdCell.innerHTML = data[j].description;
                fourthCell.innerHTML = data[j].phone;
                /* For link delete
                fifthCell.innerHTML = "<a href=\"" + "#" + "\"" + "onclick='deleteContact(" + data[j].id + ")'" + ">" + "Delete" + "</a>"*/
                fifthCell.innerHTML = "<button type=\"submit\"" + "onclick=\"" + "deleteContact(" + data[j].id + ")" + "\">" + "Delete" + "</button>";
                optionValue[j].value = data[j].id;
                optionValue[j].text = "(ID: " + data[j].id + "), " + data[j].name;
            }

        }
    })
}
function createContact() {
    var name = document.getElementById('inputName').value;
    var description = document.getElementById('inputDescription').value;
    var phone = document.getElementById('inputPhone').value;
    var result = {"name" : name,
                  "phone" : phone,
                  "description" : description,
                  "userId" : 1
                  };
    var jsonView = JSON.stringify(result);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/contacts/",
        data: jsonView,
        dataType: 'json',
        timeout: 600000,
        success: function () {
            document.location.href = 'http://localhost:8080/home?1';
        }
    })
}
function updateContact() {
    var cid = parseInt(document.getElementById('cid').value);
    var name = document.getElementById('inputName').value;
    var description = document.getElementById('inputDescription').value;
    var phone = document.getElementById('inputPhone').value;
    var result = {
        "id" : cid,
        "name" : name,
        "phone" : phone,
        "description" : description,
        "userId" : 1
    };
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/contacts/",
        data: JSON.stringify(result),
        dataType: 'json',
        timeout: 600000,
        success: setTimeout(function () {
            location.reload();
        }, 2000)
    })
}
function deleteContact(id) {
    $.ajax({
        url: "/contacts/del/" + id,
        type: "DELETE",
        success: setTimeout(function () {
            document.location.href = 'http://localhost:8080/home';
        }, 1000)
    })
}

function test(i, z) {
    var i, z;
    alert(i + z)
}
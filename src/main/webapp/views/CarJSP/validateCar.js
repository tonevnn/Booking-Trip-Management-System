function validateLicensePlate() {
    var licensePlate = document.getElementById("licensePlate").value;
    var regex = new RegExp("[0-9]{2}[A-Z]-[0-9]{4,5}");
    if (regex.test(licensePlate)) {
        return true;
    } else {
        document.getElementById("licensePlate").style.borderColor = "red";
        alert("License plate is wrong");
        return false;
    }
}

function confirmMes() {
    var result = confirm("Wanna delete this record?");
    if (result == true) {
        alert("Done");
        return true;
    } else {
        alert("Canceled");
        return false;
    }
}
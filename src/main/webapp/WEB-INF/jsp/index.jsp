<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Register Form</title>
    <style><%@include file="/WEB-INF/css/index.css"%></style>
</head>

<body>
    <h1>Register User</h1>
    <form>
        <label for="">First Name : </label>
        <input type="text" placeholder="Enter your first name">
        <label for="">Last Name : </label>
        <input type="text" placeholder="Enter your last name">
        <label for="">Email Id : </label>
        <input type="text" placeholder="Enter your email id">
        <label for="">Password : </label>
        <input type="text" placeholder="Enter your password">
        <label for="">User Image URL : </label>
        <input type="text" placeholder="Enter image url">
        <label for="">Organization Name : </label>
        <input type="text" placeholder="Enter organization name">
        <label for="">Organization Contact Number : </label>
        <input type="text" placeholder="Enter organizatio contact number">
        <label for="">Organization Email : </label>
        <input type="text" placeholder="Enter organization email">
        <label for="">Organization Address : </label>
        <input type="text" placeholder="Enter organization address">
    </form>
    <div>
        <button>Submit</button>
    </div>

</body>

</html>
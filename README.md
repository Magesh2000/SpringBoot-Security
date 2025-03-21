// creation of user details:
 URL :http://localhost:8080/api/user/create
 Method: Post
 Body:
 {
    "userName": "mageshN",
    "loginId": "mn22",
    "password": "kiki@2020",
    "contactNumber": 1234567890,
    "email": "mageshkrish1122@gmail.com",
    "address":{
        "city":"Chennai",
        "street" :"Chennai 01"
    }
}
// creation bearer Token:
URL:http://localhost:8080/auth/login
Method:Post
Body:
{
    "userName":"mageshN",
    "password":"kiki@2020"
}

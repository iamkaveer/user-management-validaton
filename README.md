# UserManagementWithValidation
## Spring Project that is a User management system
### Steps to complete the projects
1. Create a project using Spring Initializer with required dependencies(link:- https://start.spring.io/ )
2. Create a User  model 
3. Implement all endpoints provided above
4. You have to add H2 database
5. Add Validation on Api and use atleast 5 annotation visit this URL https://www.geeksforgeeks.org/spring-boot-annotations/ for reference
You have add validation on username , dateofBirth (date of birth should be validated with hyphen(-)),email,PhoneNumber(length of phone number should be 12 digit ,first two digit is country code and rest phone number)
### The user will have the following attribute :
1. UserId
2. username
3. DateOfBirth
4. email
5. Phone Number

### Endpoints to provided :
1. add User 
 ```
http://localhost:8080/add-user
```
3. update User
 ```
http://localhost:8080/update-info/{id}
```
4. delete user
 ```
http://localhost:8080/delete-user/{id}
```
5. Get all users 
 ```
http://localhost:8080/get-all-user
```
6. Get user by Id
 ```
http://localhost:8080/get-user/{id}
```

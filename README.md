#BUYSELL
Clone Avito.

Web Application:
* Delimitation of roles.
* User create products, added image for them
* User can log in/registration
* Admin also has ability to ban users and edit their information

# Local development
For starting database, use docker-compose-mysql.yml. Run command:
```bash
# Run mySql
docker-compose -f docker-compose-mysql.yml -p buysell-mysql up -d    
```

# Technological stack
- SpringBoot as a skeleton framework
- Spring Web
- Spring Data JPA
- MySQL database as a database for saving products and users
- Spring Security
- FreeMarker template engine

[//]: <> (https://www.youtube.com/playlist?list=PLMN3dELi3-VdVo8NGOYqaOLC2alq6ZmSh)

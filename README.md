## cook-book

Web recipe storage application. Useful for small food service businesses where employees can share suggestions for new recipes and other employees can comment them.

## Tech stack

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Bootstrap_CSS](https://yegor256.github.io/tacit/)
- [MySQL](https://www.mysql.com/)






**User-Registration** -  localhost:8080/registration
<br>-you can enter _*your login details_ (you will be logged as user)
![Registration](src/main/resources/assets/registration-page.png "Registration page")

**User-Log in** -  localhost:8080/login
<br>_*admin_[login: admin, e-mail: admin@gmail.com, password: pass]
<br>_*user_[login: user, e-mail: user@gmail.com, password: pass]
<br>_*your login details_
![Login](src/main/resources/assets/login-page.png "Login page")

**Admin-panel** -  localhost:8080/admin/panel
<br>-as admin
<br>*you can logout
<br>*or go to -> show all recipes
![Admin](src/main/resources/assets/admin-panel.png "Admin panel")

**Recipes-list-as-admin** - localhost:8080/
<br> you can filter recipes by name or tag
<br> you can logout
<br> you can add new recipe
<br> you can see recipe details
<br> you can edit recipe
<br> you can remove recipe
![Recipes-list-as-admin](src/main/resources/assets/recipes-list.png "Recipes list")

**User-panel** -  localhost:8080/user/panel
<br>-as user
<br>*you can logout
<br>*or go to -> show all recipes
![User](src/main/resources/assets/user-panel.png "User panel")

**Recipes-list-as-user** - localhost:8080/
<br> you can filter recipes by name or tag
<br> you can logout
<br> you can see recipe details
![Recipes-list-as-user](src/main/resources/assets/recipes-list-user.png "Recipes list")
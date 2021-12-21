# n11 TalentHub Java Bootcamp
## _second-homework_
Quick Start Detail
- Swagger UI url:  http://localhost:8080/swagger-ui.html
- Project Api url : http://localhost:8080/api/{controller_name} 


## Technologies

- Spring Boot
- Spring Data JPA / Hibernate
- Maven
- Java 17
- JDK 1.8+ 
- Swagger UI
- Mapstruct
- Java N-Tier(Layer) Architecture

## Installation

Can be installed and run as:

1. Clone the application

```cli
git clone https://github.com/n11-TalentHub-Java-Bootcamp/second-homework-byofficial
```
2. Install maven for running project

```sh
mvn clean install
```
3. Go to the project directory
```sh
cd second-homework-byofficial
```
4. Run Project 
```sh
mvnw spring-boot:run
```

## User-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/users | GET | No params|
| /api/users | PUT | No params|
| /api/users | POST | No params|
| /api/users/name={param1}&phone={param2} | DELETE |@param1, @param2
| /api/users/{id} | GET |@id
| /api/users/q?name={param1}&phone={param2} | GET |@param1, @param2

## Category-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/categories | GET | No params|
| /api/categories | PUT | No params|
| /api/categories | POST | No params|
| /api/categories/{id} | DELETE |@id
| /api/categories/{id}  | GET |@id
| /api/categories/{id}/products | GET |@id

## Review-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/reviews | GET | No params|
| /api/reviews | POST | No params|
| /api/reviews/user{id}  | GET |@id
| /api/reviews/product/{id} | GET |@id
| /api/reviews/{id} | DELETE |@id

## Product-Endpoints

| Endpoint | Method | Params |
| ------ | ------ | ------ |
| /api/products | GET | No params|
| /api/products | POST | No params|
| /api/products/{id}  | GET |@id
| /api/products/{id} | DELETE |@id
| /api/products/detail/{id}  | GET |@id
| /api/products/categories/{categoryId}  | GET |@categoryId



## Homework Problems


Problem 1:

```sh
Geçen hafta ödev olarak vermis olduğum entityleri bu projeye taşıyınız. Ek olarak kullancıya “kullaniciAdi” adında bir alan daha ekleyiniz.
```

Problem 2:

```sh
KullanıcıController adında bir Controller yazınız. Bu controller a;
2.1.Tüm kullanıcıları getiren bir servis yazınız.
2.2.Kullanıcı adından kullanıcıyı getiren bir servis yazınız.
2.3.Kullanıcı telefonundan Kulanıcıyı getiren bir servis yazınız.
2.4.Kullanıcı kaydedilebilecek bir servis yazınız. 
2.5.Kullanıcı silebilecek bir servis yazınız. (kullanıcı adı, ve telefon bilgileri alınmalı). Eğer kullanıcı 
adı ve telefon uyuşmuyorsa “XXX kullanıcı adı ile YYY telefonu bilgileri uyuşmamaktadır.”
şeklinde bir uyarı vermeil.
2.6.Kullanıcı bilgilerini güncelleyebilecek bir servis yazınız.
```

Problem 3:

```sh
YorumController adında bir Controller yazınız. Bu controller a;
3.1.Bir kullanıcının yaptığı yorumlari getiren bir servis yazınız. Eğer ilgili kullanıcının henüz bir 
yorumu yoksa “XXX kullanıcı henüz bir yorum yazmamıştır” şeklinde bir uyarı vermeli. 
3.2.Bir ürüne yapılan tüm yorumları getiren bir servis yazınız. Eğer o ürüne henüz bir yorum 
yazılmamışsa “XXX ürüne henüz bir yorum yazılmamıştır” şeklinde bir uyarı vermeli. 
3.3.Yeni bir yorum yazılabilecek bir servis yazınız. 
3.4.Yorum silebilecek bir servis yazınız.
```


```sh
localhost:8080
```

## License

MIT

**Burak YILDIZ**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>

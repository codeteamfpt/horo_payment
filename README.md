# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.1/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

#Require structural  client
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── vn
│   │   │       └── com
│   │   │          └── viettel
│   │   │             └── vds
│   │   │                 └── name-client
│   │   │                     ├── annotation => NƠi chứa các annotation.   ( Sử dụng thì thêm )
│   │   │                     ├── aop => Các Aspect Oriented Programming rules  ( Sử dụng thì thêm )
│   │   │                     ├── config => Quản lý cấu hình, các properties. ( Sử dụng thì thêm )
│   │   │                     │   ├── database : chứa các config database
│   │   │                     ├── constant => Constant. VD: Mã lỗi, Header...  ( Sử dụng thì thêm )
│   │   │                     ├── ├────── ResponseStatusCodeEnumClient extends ResponseStatusCodeEnum => Class constant Response trả về cho client  ( Sử dụng thì thêm )
│   │   │                     ├── controller => Config base. Hiện đang có base resful ( Sử dụng thì thêm )
│   │   │                     │   ├── restful : Chứa các controller restful ( Sử dụng thì thêm )
│   │   │                     │   ├── grpc : chưa các controler cho Grpc ( Sử dụng thì thêm )
│   │   │                     │   ├── kafka : chưa các consumer và producer kafka ( Sử dụng thì thêm )
│   │   │                     ├── dto => Nơi đặt các DTO ( Sử dụng thì thêm, hoặc có thể tách phần này ra một module khác )
│   │   │                     ├── exception => Danh sách các Exception muốn custom thêm nếu có  ( Sử dụng thì thêm )
│   │   │                     ├── filter => Các filter trigger khi có request gửi tới hoặc khi response trả về  ( Sử dụng thì thêm )
|   |   |                     ├── health => Healthcheck service indicator  ( Sử dụng thì thêm )
│   │   │                     ├── metrics => Chứa các config metrics cho theo dõi ứng dụng
│   │   │                     ├── repository => Tầng gọi đến databse ( Sử dụng thì thêm )
│   │   │                     ├── scheduling => Nơi đặt các task hẹn giờ chạy
│   │   │                     ├── service => Service nên để là một intefcace và được impl ở trong sub folder impl ( Sử dụng thì thêm )
│   │   │                     │   ├── impl : Chứa các class impl các inteface service. Các Class này sẽ impl code logic cho các method trừu tượng 
│   │   │                     ├── util => Lớp helper, cung cấp các hàm util, chú ý. Sử dụng Spring Utils library thay vì tự viết các hàm util: VD. xử lý String v..v  ( nếu cảm nhận thấy là common thì reqeust  để thêm vào archetype )
│   │   │                     ├── validator => Custom  validator  ( nếu cảm nhận thấy là common thì reqeust  để thêm vào archetype )
│   │   │                     │   ├── annotation => Annotation của validator
│   │   │                     │   ├── validator => Logic sử lý của validator tương ứng với annotation
│   │   │                     └── ... sẽ cập nhật thêm sau.
│   │   └── resources
│   │       └── application.properties 
│   │       └── bootstrap.properties 
│   │       └── .....
│   └── test
│       ├── java
│       └── resources

```

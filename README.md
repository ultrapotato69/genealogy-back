Сервис генеалогии.
Для запуска требуется:
- docker и docker-compose
- java 21 
- maven

Для запуска бд нужно выполнить команду:
docker-compose -f docker-compose-pg.yml up

Для компиляции и сборки локально:
mvn clean package -DskipTests

Для запуска java-приложения(версия 0.0.1-SNAPSHOT может измениться):
java -jar -Dspring.profiles.active=local impl/target/genealogy-back-impl-0.0.1-SNAPSHOT.jar

Приложение работает на порту 8686 и с server.servlet.context-path=/genealogy
Адрес swagger-ui для локальной работы: http://localhost:8686/genealogy/swagger-ui/index.html
# Calorie Tracker 

## Описание
REST API для отслеживания дневной нормы калорий и учета съеденных блюд.

## Функциональность
✔ Добавление пользователей с расчётом дневной нормы калорий  
✔ Добавление блюд с калорийностью и БЖУ  
✔ Регистрация приёмов пищи  
✔ Подсчёт калорий за день  
✔ Проверка, уложился ли пользователь в норму  
✔ История питания по дням  
✔ Swagger-документация API

---

## 1. Установка и запуск 

### Требования:
- Java 17+
- Maven
- PostgreSQL

### Шаги установки:
1. **Клонируем репозиторий:**
   ```sh
   git clone https://github.com/i-am-neegr/test1221
   cd test1221

   ```
2. **Настраиваем базу данных:**  
   В файле `application.properties` укажи свои настройки PostgreSQL:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/calorie_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. **Собираем и запускаем проект:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

---

## 2. API Эндпоинты 

### **Пользователи**
- **Добавить пользователя:** `POST /user`
  ```json
    {
      "id": 1,
      "name": "Вова",
      "email": "vova6939nagib@mail.gg",
      "age": 22,
      "weight": 94,
      "height": 163,
      "aim": "LOSE"
    }
  ```

### **Блюда**
- **Добавить блюдо:** `POST /dish`
  ```json
  {
  "id": 1,
  "name": "пица",
  "description": "круглая, жирная, вкусная",
  "calories": 1800,
  "protein": 120,
  "fat": 64,
  "carbohydrate": 180
    }
  ```

### **Swagger UI**
После запуска приложения документация доступна по адресу:
```
http://localhost:8080/swagger-ui.html
```

---

## 3. Тестирование 
Проект использует **JUnit 5 + Mockito** для юнит-тестов.

- **Запуск тестов:**
  ```sh
  mvn test
  ```


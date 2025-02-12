# Aplikacja CRUD dla użytkowników Opis

Projekt ten jest prostą aplikacją CRUD (Create, Read, Update, Delete) do zarządzania użytkownikami. Aplikacja wykorzystuje wzorzec Data Access Object (DAO) do obsługi operacji na bazie danych i implementuje podstawowe operacje na użytkownikach za pomocą JDBC.

# Aplikacja obsługuje następujące operacje:

Tworzenie nowego użytkownika.
Odczyt danych użytkownika na podstawie jego ID.
Aktualizacja danych użytkownika.
Usuwanie użytkownika.
Pobieranie wszystkich użytkowników.
Usuwanie wszystkich użytkowników.

# Dodatkowo w projekcie zastosowano BCrypt do bezpiecznego haszowania haseł użytkowników. Technologie

Java — główny język programowania.
JDBC — do komunikacji z bazą danych.
BCrypt — do haszowania haseł.
MySQL — baza danych (lub inna SGBD obsługująca JDBC).

# Główne zasady i wzorce

# Data Access Object (DAO)

Wzorzec DAO jest używany do oddzielenia logiki dostępu do danych od logiki aplikacji. W projekcie używany jest klasa UserDao, która odpowiada za operacje na bazie danych takie jak tworzenie, odczyt, aktualizacja i usuwanie użytkowników. Dzięki temu logika aplikacji nie jest obciążona bezpośrednią interakcją z bazą danych. 
# Enkapsulacja

Wszystkie pola w klasie User są prywatne, a dostęp do nich odbywa się za pomocą metod getter i setter. Dzięki temu można kontrolować sposób modyfikacji danych, co zapewnia większe bezpieczeństwo. 

# Zastosowanie BCrypt do haszowania haseł

Hasła użytkowników są haszowane przed zapisaniem ich w bazie danych przy użyciu biblioteki BCrypt. Dzięki temu hasła są przechowywane w sposób bezpieczny, a nie w formie otwartego tekstu. 
# JDBC
Do komunikacji z bazą danych wykorzystano standardowy mechanizm JDBC (Java Database Connectivity), który umożliwia nawiązywanie połączeń, wykonywanie zapytań SQL i obsługę wyników.

# Struktura projektu

   # Klasa User

Klasa User reprezentuje użytkownika i zawiera następujące pola:

id — unikalny identyfikator użytkownika (generowany automatycznie przy tworzeniu).
email — adres email użytkownika.
username — nazwa użytkownika.
password — hasło użytkownika (w postaci haszu).

Klasa User zawiera metody getter i setter dla wszystkich pól oraz metodę toString(), która umożliwia reprezentację obiektu jako tekst. 2. Klasa UserDao

# Klasa UserDao implementuje operacje CRUD:

create(User user) — tworzy nowego użytkownika w bazie danych.
read(int id) — znajduje użytkownika po jego ID.
update(User user) — aktualizuje dane użytkownika w bazie danych.
delete(int id) — usuwa użytkownika z bazy danych.
findAll() — znajduje wszystkich użytkowników w bazie danych.
deleteAll() — usuwa wszystkich użytkowników z bazy danych.

# Wszystkie zapytania do bazy danych wykonywane są przy pomocy przygotowanych zapytań (PreparedStatement), co zapewnia ochronę przed atakami typu SQL injection. 
# Klasa MainDao
Klasa główna, która pokazuje, jak używać DAO. Tworzy użytkowników, wykonuje operacje odczytu, aktualizacji, usuwania i wyświetlania wszystkich użytkowników. W tej klasie również używany jest BCrypt do haszowania haseł.

# Przykład, jak używać podstawowych funkcji aplikacji:

public class Main { public static void main(String[] args) { UserDao userDao = new UserDao();

    // Tworzenie użytkowników
   UserDao userDao = new UserDao();

    User user1 = new User();

    user1.setEmail("email1@gmail.com");
    user1.setUsername("nickname1");
    user1.setPassword("password1");
    user1 = userDao.create(user1);
    System.out.println(user1.getId());


    User user2 = new User();


    user2.setEmail("email2@gmail.com");
    user2.setUsername("nickname2");
    user2.setPassword("password2");
    user2 = userDao.create(user2);
    System.out.println(user2.getId());


    User user3 = new User();

    user3.setEmail("email3@gmail.com");
    user3.setUsername("nickname3");
    user3.setPassword("password3");
    user3 = userDao.create(user3);
    System.out.println(user3.getId());
    // Odczyt użytkownika
    user3 = userDao.read(3);

    // Aktualizacja użytkownika
    user3.setEmail("newEmail@gmail.com");
    user3.setUsername("newUsername");
    user3.setPassword("newPassword");
    userDao.update(user3);

    // Usunięcie użytkownika
    userDao.delete(user3.getId());

    // Pobranie wszystkich użytkowników
    User[] users = userDao.findAll();
    for (User user : users) {
        System.out.println(user);
    }

    // Usunięcie wszystkich użytkowników
    userDao.deleteAll();
}

}

# Uwagi:

Hasła użytkowników są haszowane przy pomocy BCrypt przed zapisaniem w bazie danych.
Wszystkie zapytania do bazy danych są wykonywane za pomocą PreparedStatement, co chroni przed atakami typu SQL injection.
Wszelkie operacje na użytkownikach są realizowane przez klasę UserDao, co pozwala na oddzielenie logiki dostępu do danych od logiki aplikacji.

Uruchomienie projektu

Upewnij się, że masz zainstalowane JDK 8+.
Zainstaluj bibliotekę BCrypt oraz skonfiguruj bazę danych.
<dependencies>
    <dependency>
        <groupId>org.mindrot</groupId>
        <artifactId>jbcrypt</artifactId>
        <version>0.4</version>
    </dependency>

    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.0.33</version>
    </dependency>

</dependencies>

Skompiluj i uruchom projekt w swojej IDE lub za pomocą linii poleceń.

Podsumowanie

Projekt ten demonstruje podstawowe operacje na użytkownikach w kontekście wzorca Data Access Object oraz bezpieczne przechowywanie haseł użytkowników za pomocą BCrypt. Można łatwo rozbudować projekt o nowe funkcje, takie jak walidacja danych, obsługa wyjątków czy bardziej zaawansowane zapytania do bazy danych.

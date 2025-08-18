package day25;

//Subject
interface Database {
 void fetchData();
}

//Real Subject
class RealDatabase implements Database {
 public void fetchData() {
     System.out.println("Fetching data from the database...");
 }
}

//Proxy
class DatabaseProxy implements Database {
 private RealDatabase realDatabase;
 private String username;
 private String password;

 public DatabaseProxy(String username, String password) {
     this.username = username;
     this.password = password;
 }

 private boolean authenticate() {
     // Simple auth check (in real life, check hashed passwords)
     return "admin".equals(username) && "1234".equals(password);
 }

 public void fetchData() {
     if (authenticate()) {
         if (realDatabase == null) {
             realDatabase = new RealDatabase();
         }
         realDatabase.fetchData();
     } else {
         System.out.println("Access denied: Invalid credentials.");
     }
 }
}

//Client
public class HomeTask03_ProxyPatternAuthExample {
 public static void main(String[] args) {
     Database db1 = new DatabaseProxy("admin", "1234"); // correct credentials
     db1.fetchData();

     Database db2 = new DatabaseProxy("user", "wrong"); // wrong credentials
     db2.fetchData();
 }
}

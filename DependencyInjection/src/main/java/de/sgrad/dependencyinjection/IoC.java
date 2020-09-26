package de.sgrad.depinj;

/*** First Version bad because we internally rely on Database, no unit test is possible
public class IoC {
    public static void main(String [] args){
        IoC container = new IoC();
        User user = container.new User();
        user.add("Some data");
    }

    // Business Logic Layer
    public class User{
        private MySqlDatabase db;

        public User() {
            db = new MySqlDatabase();
        }

        public void add (String data){
            db.persist(data);
        }
    }

    // Data Access Layer
    public class MySqlDatabase{
        public void persist(String data){
            System.out.println("Data is persisted in MySql db." + data);
        }
    }
}
 */

/*** This is no better testable can pass a db but if we add e.e OracleDatabase class it wont work
public class IoC {
    public static void main(String [] args){
        IoC container = new IoC();
        User user = container.new User(container.new MySqlDatabase());
        user.add("Some data");
    }

    // Business Logic Layer
    public class User{
        private MySqlDatabase db;

        public User(MySqlDatabase db) {
            this.db = db;
        }

        public void add (String data){
            db.persist(data);
        }
    }

    // Data Access Layer
    public class MySqlDatabase{
        public void persist(String data){
            System.out.println("Data is persisted in MySql db." + data);
        }
    }
}
 */


/** Interface Version
public class IoC {
    public static void main(String [] args){
        IoC container = new IoC();
        User user = container.new User(container.new OracleDatabase());
        user.add("Some data");
    }

    // Business Logic Layer
    public class User{
        private IDatabase db;

        public User(IDatabase db) {
            this.db = db;
        }

        public void add (String data){
            db.persist(data);
        }
    }

    public interface IDatabase{
        public void persist(String data);
    }

    // Data Access Layer
    public class MySqlDatabase implements IDatabase{
        public void persist(String data){
            System.out.println("Persisted in MySql db:" + data);
        }
    }

    public class OracleDatabase implements IDatabase{
        public void persist(String data){
            System.out.println("Persisted in Oracle db:" + data);
        }
    }
}
*/


import org.springframework.beans.factory.annotation.Autowired;

/**
 * XMl Config
 * <bean id="MySql" class="com.java.mysql"/>
 * <bean id="Oracle" class="com.java.oracle"/>
 *
 * <bean id="user" class="com.java.user"/>
 *      <arg ref="MySql"/>
 *      <arg ref="Oracle"/>
 * </bean>
 *
*/

/**
public class IoC {
    public static void main(String [] args){
        IoC container = new IoC();
        //User user = container.new User(container.new OracleDatabase());

        // initialize user based on bean description
        @Autowired
        User user;

        @Autowired
        User user2;

        @Autowired
        User user3;

        user.add("Some data");
    }

    // Business Logic Layer
    public class User{
        private IDatabase db;

        public User(IDatabase db) {
            this.db = db;
        }

        public void add (String data){
            db.persist(data);
        }
    }

    public interface IDatabase{
        public void persist(String data);
    }

    // Data Access Layer
    public class MySqlDatabase implements IDatabase{
        public void persist(String data){
            System.out.println("Persisted in MySql db:" + data);
        }
    }

    public class OracleDatabase implements IDatabase{
        public void persist(String data){
            System.out.println("Persisted in Oracle db:" + data);
        }
    }
}
 */

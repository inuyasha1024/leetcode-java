package jiuzhang.stream;

class User{
    String name;
    Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

public class StreamTest {


    public static void main(String[] args) {
//        List<String> list = Arrays.asList("James","Tom","Andy");
//        List<String> list1 = list.jiuzhang.stream().map(str -> {str = "Mike :"; return  str;}).collect(Collectors.toList());
//        System.out.println("------------------------------------------");
//        System.out.println(list);
//        System.out.println("------------------------------------------");
//        System.out.println(list1);
//
//        List<User> users = Arrays.asList(new User("James",10));
//        List<User> users1 = users.jiuzhang.stream().map(user -> {user.age += 10; return user;}).collect(Collectors.toList());
//
//        System.out.println(users);
//        System.out.println("----------------");
//        System.out.println(users1);

        Integer a = 10;
        Integer b = a;
        a = 20;
        System.out.println(b);
        System.out.println("---------------------------");
        User user1 = new User("James" ,20);
        User user2 = user1;
        user1.age = 20;
        System.out.println(user2.age);
    }
}

package Prototype;

import java.util.HashMap;

public class ShallowCopy {
    private static class Person {
        private String name;
        private int ege;

        public Person(String name, int ege) {
            this.name = name;
            this.ege = ege;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEge() {
            return ege;
        }

        public void setEge(int ege) {
            this.ege = ege;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", ege=" + ege +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashMap<String, Person> map1 = new HashMap<>();
        map1.put("1", new Person("邱羽彤", 5));
        map1.put("2", new Person("林琳", 35));
        map1.put("3", new Person("邱春波", 38));

        HashMap<String, Person> map2 = (HashMap<String, Person>) map1.clone();
        map2.get("3").setEge(37);
        map2.remove("3");
        map2.put("3", new Person("邱春波", 59));
        map2.get("3").setEge(39);

        System.out.println(map1);
        System.out.println(map2);
    }
}

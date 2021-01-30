package practice.cache;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutalbeDemo {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("aa");
        originalList.add("bb");
        originalList.add("cc");
        originalList.add("dd");

        List<String> jdkUnmodifiableList = Collections.unmodifiableList(originalList);
        List<String> guavaImmutableList = ImmutableList.copyOf(originalList);
        //jdkUnmodifiableList.add("ee");
        // guavaImmutableList.add("ff");

        String[] arr = {"aa", "bb", "cc", "dd"};
        List<String> jakImmutableCollections = List.of(arr);
        arr = new String[]{"aa", "bb", "cc", "dd", "ee"};

        originalList.add("ee");

        System.out.println(jdkUnmodifiableList);
        System.out.println(guavaImmutableList);
        System.out.println(jakImmutableCollections);

    }
}

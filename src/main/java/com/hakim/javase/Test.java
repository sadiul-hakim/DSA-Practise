package com.hakim.javase;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Stack;


public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        HttpRequest request=HttpRequest.newBuilder()
//                .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
//                .GET()
//                .build();
//        HttpResponse<String> send = HttpClient.newHttpClient()
//                .send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(send.body());

        String name="Hakim";
        String transform = name.transform(n -> n.indent(10));
        Path file=Path.of("text.txt");
        Path file1=Path.of("text1.txt");

        String date= LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println();
    }

    public static List<String> get(List<Long> list){
        return list.stream().map(String::valueOf).toList();
    }

    public static String getQuery(List<Long> dealPropertyIdList, List<String> valueList){
        if(dealPropertyIdList == null || dealPropertyIdList.isEmpty() || valueList == null || valueList.isEmpty()) return null;
        StringBuilder builder=new StringBuilder("SELECT * FROM dealproperties WHERE");

        for(int i=0;i<dealPropertyIdList.size();i++){
            builder.append("(")
                    .append("ID_PropertyType=")
                    .append(dealPropertyIdList.get(i))
                    .append(" AND ")
                    .append("VALUE=")
                    .append(valueList.get(i))
                    .append(")");
            if(i != dealPropertyIdList.size() -1){
                builder.append(" OR ");
            }
        }

        return builder.toString();
    }
}

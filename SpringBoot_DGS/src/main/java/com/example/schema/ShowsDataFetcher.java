package com.example.schema;

import com.example.pojo.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDataFetcher {

    @DgsData(parentType = "Query", field = "shows")
    public List<Show> shows(@InputArgument("title") String title, @InputArgument("releaseYear") Integer releaseYear) {
        if (title == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(title)).collect(Collectors.toList());
    }

    // 模拟 DB 查询
    private final List<Show> shows = Arrays.asList(
            new Show("java", 1995),
            new Show("php", 1995),
            new Show("python", 1990),
            new Show("golang", 2009),
            new Show("rust", 2015)
    );
}

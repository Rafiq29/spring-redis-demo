package com.herb.springredisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("Movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
    public enum FSK {
        FSK_0, FSK_8, FSK_12, FSK_18
    }

    @Id
    private String key;
    private String name;
    private FSK fsk;
    private List<String> actors;
}

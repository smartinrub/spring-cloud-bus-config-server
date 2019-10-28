package com.sergiomartinrubio.secondclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mysql.properties")
public class MySqlProperties {

    private String url;
    private String username;
    private String password;

}

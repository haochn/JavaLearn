package com.pers.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataConfig {
    public DataConfig(){
        System.out.println("pojo:"+ this.toString());
    }
    @Value("3307")
    private String url;
    private String driverName;
    private String userName;
    private String password;
}

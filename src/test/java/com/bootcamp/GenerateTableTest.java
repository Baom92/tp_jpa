package com.bootcamp;

import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.Properties;

/**
 * Created by darextossa on 9/22/17.
 */


public class GenerateTableTest {

    @Test
    public void generateTables(){
        Persistence.generateSchema("TP_JPA_PU", new Properties());
    }
}

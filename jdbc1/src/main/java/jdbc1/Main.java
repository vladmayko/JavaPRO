//package com.company;

import jdbc1.ConnectToDB;
import jdbc1.TableNameDao;
import jdbc1.Human;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        TableNameDao tableNameDao = new TableNameDao();

        //check all
        showAllFoundPeople(tableNameDao);
        System.out.println();

        //find by id
        System.out.println("Found: " + tableNameDao.findById(6));
        System.out.println();

        //add human to db
//        Human testHuman = new Human("Paul", 26);
//        System.out.println(tableNameDao.addHuman(testHuman));
//        showAllFoundPeople(tableNameDao);
        System.out.println();

        //update human with wrong data
        System.out.println(tableNameDao.updateHuman(10, "Anna", 19));
        //update human with correct data
        System.out.println(tableNameDao.updateHuman(5, "Nick", 27));
        showAllFoundPeople(tableNameDao);
        System.out.println();

        //delete human
//        System.out.println(tableNameDao.deleteHuman(7));
        showAllFoundPeople(tableNameDao);

    }

    public static void showAllFoundPeople(TableNameDao tableNameDao) throws SQLException{
        Collection<Human> humans =  tableNameDao.findAll();
        for (Human human : humans){
            System.out.println(human);
        }
    }
}

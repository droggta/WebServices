package configuration;

import Database.Nutzer;

import java.util.ArrayList;

public enum Configuration {
    instance;
    public final String baseURL = "http://10.50.15.51:9000/";
    public ArrayList<Nutzer> users = new ArrayList<Nutzer>();
}

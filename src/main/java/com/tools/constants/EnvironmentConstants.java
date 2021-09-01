package com.tools.constants;

import com.tools.persistence.PropertyFileReader;

public class EnvironmentConstants {
    public static final String API_KEY = PropertyFileReader.getEnvConstantsItem("API_KEY");
    public static final String API_TOKEN = PropertyFileReader.getEnvConstantsItem("API_TOKEN");
    public static final String USERNAME = PropertyFileReader.getEnvConstantsItem("USERNAME");
    public static final String PASSWORD = PropertyFileReader.getEnvConstantsItem("PASSWORD");
    public static final String API_BASE_URL = PropertyFileReader.getEnvConstantsItem("API_BASE_URL");

}

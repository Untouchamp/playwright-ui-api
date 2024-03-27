package config;

import org.ini4j.Ini;

import java.io.FileReader;
import java.io.IOException;

public class SetupConfig {

    private SetupConfig() { throw new IllegalStateException("Config class");}

    static Ini ini;

    static {
        try (FileReader fileReader = new FileReader("config.properties")) {
            ini = new Ini(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final class UserCredentials {
        private UserCredentials() { throw new IllegalStateException("Config class");}
        private static final String sectionName     = "User_Credentials";
        public  static final String userLogin       = ini.get(sectionName, "userLogin", String.class);
        public  static final String userPassword    = ini.get(sectionName, "userPassword", String.class);
    }

    public static final class UIEndpoints {
        private UIEndpoints() { throw new IllegalStateException("Config class");}
        private static final String sectionName             = "UI_Endpoints";
        public  static final String uiBaseUrl               = ini.get(sectionName, "uiBaseUrl", String.class);
        private static final String uiDocsSection           = ini.get(sectionName, "uiDocsSection", String.class);
        private static final String uiDocsIntro             = uiDocsSection + ini.get(sectionName, "uiDocsIntro", String.class);
        private static final String uiDocsWritingTests      = uiDocsSection + ini.get(sectionName, "uiDocsWritingTests", String.class);
        private static final String uiDocsGeneratingTests   = uiDocsSection + ini.get(sectionName, "uiDocsGeneratingTests", String.class);


        private static final String uiApiSection            = uiDocsSection + ini.get(sectionName, "uiApiSection", String.class);
        private static final String uiApiClassPlaywright    = uiApiSection + ini.get(sectionName, "uiApiClassPlaywright", String.class);
    }

    public static final class APIEndpoints {
        private APIEndpoints() { throw new IllegalStateException("Config class");}
        private static final String sectionName             = "API_Endpoints";
        public  static final String apiBaseUrl              = ini.get(sectionName, "apiBaseUrl", String.class);
        public  static final String apiPostAuthCreateUser   = ini.get(sectionName, "apiPostAuthCreateUser", String.class);
        public  static final String apiPostAuthToken        = ini.get(sectionName, "apiPostAuthToken", String.class);
        public  static final String apiGetTodos             = ini.get(sectionName, "apiGetTodos", String.class);
        public  static final String apiPostTodos            = ini.get(sectionName, "apiPostTodos", String.class);
        public  static final String apiGetTodosUser         = ini.get(sectionName, "apiGetTodosUser", String.class);
        public  static final String apiGetTodoById          = ini.get(sectionName, "apiGetTodoById", String.class);
        public  static final String apiPutTodoById          = ini.get(sectionName, "apiPutTodoById", String.class);
        public  static final String apiDeleteTodoById       = ini.get(sectionName, "apiDeleteTodoById", String.class);
        public  static final String apiGetAddress           = ini.get(sectionName, "apiGetAddress", String.class);
        public  static final String apiPostAddress          = ini.get(sectionName, "apiPostAddress", String.class);
        public  static final String apiDeleteAddress        = ini.get(sectionName, "apiDeleteAddress", String.class);
        public  static final String apiGetUsers             = ini.get(sectionName, "apiGetUsers", String.class);
        public  static final String apiDeleteOwnUser        = ini.get(sectionName, "apiDeleteOwnUser", String.class);
        public  static final String apiGetUserById          = ini.get(sectionName, "apiGetUserById", String.class);
        public  static final String apiGetUser              = ini.get(sectionName, "apiGetUser", String.class);
        public  static final String apiGetUserFilter        = ini.get(sectionName, "apiGetUserFilter", String.class);
        public  static final String apiPutUserPassword      = ini.get(sectionName, "apiPutUserPassword", String.class);
    }

}

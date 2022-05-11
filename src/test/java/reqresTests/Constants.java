package reqresTests;

public class Constants {
    public static class Urls {
        public static final String DOMAIN_URL = "https://reqres.in";
        public static final String ADD_USER_ENDPOINT = "/api/users";
        public static final String GET_USER_BY_ID = "/api/users/";
        public static final String DELETE_USER = "/api/users/";
        public static final String USER_ID = "12";
    }

    public static class Requests {
        public   String name = "Wasya";
        public   String job ="Big Boss";

        @Override
        public String toString() {
            return "{\"name\":" + "\""+name+"\""  +", \"job\":\"" + job + "\"}";
        }
    }

}

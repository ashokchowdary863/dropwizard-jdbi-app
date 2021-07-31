package com.ashok.entity;

public class User {
    private final String userId;
    private final String name;

    private User(UserBuilder userBuilder) {
        this.userId = userBuilder.userId;
        this.name = userBuilder.name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }


    public static class UserBuilder {
        private String userId;
        private String name;

        public UserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }


    }
}

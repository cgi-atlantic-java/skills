package com.cgi.skills.beans;

public interface Option {

    String getName();

    Long getId();

    final Option NULL = new Option() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public Long getId() {
            return null;
        }
    };
}

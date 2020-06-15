package tn.esprit.spring.entity;

import java.util.Arrays;

public enum Role {
	 ADMINISTRATEUR("ADMINISTRATEUR"), USER("USER");
	
	String type;
	 private Role(String type) {
	        this.type = type;
	    }

	    public String getType() {
	        return type;
	    }

	    public static Role getEnum(String value) {
	        for(Role v : values())
	            if(v.getType().equalsIgnoreCase(value)) return v;
	        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	    }
}

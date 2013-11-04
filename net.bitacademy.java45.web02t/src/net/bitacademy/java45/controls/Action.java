package net.bitacademy.java45.controls;

import java.util.Map;

public interface Action {
	String execute(Map<String,Object> model) throws Exception;
}

package com.gst.invoice;

import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;

public class CustomSnakeCase extends PropertyNamingStrategyBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 833802844193974561L;
	private static final Pattern REGEX = Pattern.compile("[A-Z]");

    @Override
    public String translate(String input) {
        if (input == null)
            return input; // garbage in, garbage out

        if (!input.isEmpty() && Character.isUpperCase(input.charAt(0)))
            input = input.substring(0, 1).toLowerCase() + input.substring(1);

        return REGEX.matcher(input).replaceAll("_$0").toLowerCase();
    }

}

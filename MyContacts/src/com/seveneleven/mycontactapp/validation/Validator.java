package com.seveneleven.mycontactapp.validation;
import java.util.regex.Pattern;
public class Validator {
 public static boolean isValidEmail(String email) {
 	String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
     return Pattern.matches(EMAIL_REGEX, email);
 }
 public static boolean isValidPassword(String password) {
     return password.length() >= 8;
 }
}
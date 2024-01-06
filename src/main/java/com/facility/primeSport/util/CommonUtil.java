package com.facility.primeSport.util;

import com.facility.primeSport.enums.WorkoutLevel;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class CommonUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE_REGEX = "^(\\+)?[0-9]{7,15}$";

    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isTrue(Boolean value){
        return value != null && value;
    }

    public static boolean isNullOrEmpathy(String value){
        return !value.isBlank() && !value.isEmpty() && !value.trim().isEmpty();
    }

    public static String createVerificationCode() {
        StringBuilder stringBuilder = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }


    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    public static String getBirtDateFormat(LocalDate date){
        if (date != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return  date.format(formatter);
        }
        return "-";
    }

    public static WorkoutLevel findLevel(Long id){
        if (id == 101) {
            return WorkoutLevel.BEGINNER;
        } else if (id == 102){
            return WorkoutLevel.INTERMEDIATE;
        } else if (id == 103){
            return WorkoutLevel.ADVANCED;
        } else if (id == 104){
            return WorkoutLevel.SPECIFIC;
        }else {
            return WorkoutLevel.BEGINNER;
        }
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}

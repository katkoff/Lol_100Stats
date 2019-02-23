package com.katkov.lolachievements.utils;

import java.util.Arrays;

public class ServerNamesHandler {

    private static final String[] SERVER_CODES = {
            "EUN1",
            "EUW1",
            "JP1",
            "KR",
            "LA1",
            "LA2",
            "NA",
            "NA1",
            "OC1",
            "TR1",
            "RU",
            "PBE1",
    };

    private static String[] SERVER_NAMES = {
            "Еун1",
            "Европа1",
            "Япония",
            "Корея",
            "Лат америка1",
            "Лат америка 2",
            "Северная амер",
            "Северная амер 1",
            "Океания",
            "Тр1",
            "Россия",
            "ПБЕ1",
    };

    public static String getCodeByName(String code) {
        int codeIndex = Arrays.asList(SERVER_NAMES).indexOf(code);
        return SERVER_CODES[codeIndex];
    }

    public static String getNameByCode(String name) {
        int nameIndex = Arrays.asList(SERVER_CODES).indexOf(name);
        return SERVER_NAMES[nameIndex];
    }

    public static String getNameByIndex(int index) {
        return SERVER_NAMES[index];
    }

    public static String getCodeByIndex(int index) {
        return SERVER_CODES[index];
    }

    public static String[] getServerCodes() {
        return SERVER_CODES;
    }

    public static String[] getServerNames() {
        return SERVER_NAMES;
    }
}

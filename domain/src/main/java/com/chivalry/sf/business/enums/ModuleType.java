package com.chivalry.sf.business.enums;

public enum ModuleType {
    LOCAL("0"),
    OUT("1");

    private String value;

    ModuleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

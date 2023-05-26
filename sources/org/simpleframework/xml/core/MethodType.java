package org.simpleframework.xml.core;

/* loaded from: classes5.dex */
enum MethodType {
    GET(3),
    IS(2),
    SET(3),
    NONE(0);
    
    private int prefix;

    MethodType(int i8) {
        this.prefix = i8;
    }

    public int getPrefix() {
        return this.prefix;
    }
}

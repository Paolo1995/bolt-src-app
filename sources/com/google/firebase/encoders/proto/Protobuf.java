package com.google.firebase.encoders.proto;

/* loaded from: classes3.dex */
public @interface Protobuf {

    /* loaded from: classes3.dex */
    public enum IntEncoding {
        DEFAULT,
        SIGNED,
        FIXED
    }

    IntEncoding intEncoding() default IntEncoding.DEFAULT;

    int tag();
}

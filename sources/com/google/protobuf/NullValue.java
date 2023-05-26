package com.google.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    

    /* renamed from: i  reason: collision with root package name */
    private static final Internal.EnumLiteMap<NullValue> f17545i = new Internal.EnumLiteMap<NullValue>() { // from class: com.google.protobuf.NullValue.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public NullValue a(int i8) {
            return NullValue.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f17547f;

    NullValue(int i8) {
        this.f17547f = i8;
    }

    public static NullValue a(int i8) {
        if (i8 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f17547f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

package com.google.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    

    /* renamed from: j  reason: collision with root package name */
    private static final Internal.EnumLiteMap<Syntax> f17611j = new Internal.EnumLiteMap<Syntax>() { // from class: com.google.protobuf.Syntax.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public Syntax a(int i8) {
            return Syntax.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f17613f;

    Syntax(int i8) {
        this.f17613f = i8;
    }

    public static Syntax a(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                return null;
            }
            return SYNTAX_PROTO3;
        }
        return SYNTAX_PROTO2;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f17613f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

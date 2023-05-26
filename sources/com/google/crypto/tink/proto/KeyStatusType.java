package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum KeyStatusType implements Internal.EnumLite {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: l  reason: collision with root package name */
    private static final Internal.EnumLiteMap<KeyStatusType> f14947l = new Internal.EnumLiteMap<KeyStatusType>() { // from class: com.google.crypto.tink.proto.KeyStatusType.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public KeyStatusType a(int i8) {
            return KeyStatusType.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f14949f;

    KeyStatusType(int i8) {
        this.f14949f = i8;
    }

    public static KeyStatusType a(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return null;
                    }
                    return DESTROYED;
                }
                return DISABLED;
            }
            return ENABLED;
        }
        return UNKNOWN_STATUS;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f14949f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

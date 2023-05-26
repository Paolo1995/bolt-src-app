package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum ChangeType implements Internal.EnumLite {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: l  reason: collision with root package name */
    private static final Internal.EnumLiteMap<ChangeType> f14673l = new Internal.EnumLiteMap<ChangeType>() { // from class: com.google.api.ChangeType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public ChangeType a(int i8) {
            return ChangeType.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f14675f;

    ChangeType(int i8) {
        this.f14675f = i8;
    }

    public static ChangeType a(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return null;
                    }
                    return MODIFIED;
                }
                return REMOVED;
            }
            return ADDED;
        }
        return CHANGE_TYPE_UNSPECIFIED;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f14675f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

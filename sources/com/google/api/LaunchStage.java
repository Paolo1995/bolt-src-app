package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum LaunchStage implements Internal.EnumLite {
    LAUNCH_STAGE_UNSPECIFIED(0),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);
    

    /* renamed from: n  reason: collision with root package name */
    private static final Internal.EnumLiteMap<LaunchStage> f14724n = new Internal.EnumLiteMap<LaunchStage>() { // from class: com.google.api.LaunchStage.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public LaunchStage a(int i8) {
            return LaunchStage.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f14726f;

    LaunchStage(int i8) {
        this.f14726f = i8;
    }

    public static LaunchStage a(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 != 5) {
                                return null;
                            }
                            return DEPRECATED;
                        }
                        return GA;
                    }
                    return BETA;
                }
                return ALPHA;
            }
            return EARLY_ACCESS;
        }
        return LAUNCH_STAGE_UNSPECIFIED;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f14726f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

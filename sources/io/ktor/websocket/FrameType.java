package io.ktor.websocket;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: FrameType.kt */
/* loaded from: classes5.dex */
public enum FrameType {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);
    

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f47549h = new Companion(null);

    /* renamed from: i  reason: collision with root package name */
    private static final int f47550i;

    /* renamed from: j  reason: collision with root package name */
    private static final FrameType[] f47551j;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f47558f;

    /* renamed from: g  reason: collision with root package name */
    private final int f47559g;

    /* compiled from: FrameType.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        boolean z7;
        FrameType frameType;
        int J;
        boolean z8;
        FrameType[] values = values();
        if (values.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            frameType = null;
        } else {
            frameType = values[0];
            J = ArraysKt___ArraysKt.J(values);
            if (J != 0) {
                int i8 = frameType.f47559g;
                IntIterator it = new IntRange(1, J).iterator();
                while (it.hasNext()) {
                    FrameType frameType2 = values[it.nextInt()];
                    int i9 = frameType2.f47559g;
                    if (i8 < i9) {
                        frameType = frameType2;
                        i8 = i9;
                    }
                }
            }
        }
        Intrinsics.c(frameType);
        int i10 = frameType.f47559g;
        f47550i = i10;
        int i11 = i10 + 1;
        FrameType[] frameTypeArr = new FrameType[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            FrameType[] values2 = values();
            int length = values2.length;
            FrameType frameType3 = null;
            int i13 = 0;
            boolean z9 = false;
            while (true) {
                if (i13 < length) {
                    FrameType frameType4 = values2[i13];
                    if (frameType4.f47559g == i12) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        if (z9) {
                            break;
                        }
                        frameType3 = frameType4;
                        z9 = true;
                    }
                    i13++;
                } else if (z9) {
                }
            }
            frameType3 = null;
            frameTypeArr[i12] = frameType3;
        }
        f47551j = frameTypeArr;
    }

    FrameType(boolean z7, int i8) {
        this.f47558f = z7;
        this.f47559g = i8;
    }
}

package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
/* loaded from: classes5.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* compiled from: Settings.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        ArraysKt___ArraysJvmKt.n(this.values, 0, 0, 0, 6, null);
    }

    public final int get(int i8) {
        return this.values[i8];
    }

    public final boolean getEnablePush(boolean z7) {
        if ((this.set & 4) != 0) {
            if (this.values[2] == 1) {
                return true;
            }
            return false;
        }
        return z7;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int getMaxFrameSize(int i8) {
        if ((this.set & 32) != 0) {
            return this.values[5];
        }
        return i8;
    }

    public final int getMaxHeaderListSize(int i8) {
        if ((this.set & 64) != 0) {
            return this.values[6];
        }
        return i8;
    }

    public final boolean isSet(int i8) {
        if (((1 << i8) & this.set) != 0) {
            return true;
        }
        return false;
    }

    public final void merge(Settings other) {
        Intrinsics.f(other, "other");
        int i8 = 0;
        while (i8 < 10) {
            int i9 = i8 + 1;
            if (other.isSet(i8)) {
                set(i8, other.get(i8));
            }
            i8 = i9;
        }
    }

    public final Settings set(int i8, int i9) {
        if (i8 >= 0) {
            int[] iArr = this.values;
            if (i8 < iArr.length) {
                this.set = (1 << i8) | this.set;
                iArr[i8] = i9;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}

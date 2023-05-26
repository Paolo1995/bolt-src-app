package io.ktor.http;

/* compiled from: Parameters.kt */
/* loaded from: classes5.dex */
public final class ParametersKt {
    public static final ParametersBuilder a(int i8) {
        return new ParametersBuilderImpl(i8);
    }

    public static /* synthetic */ ParametersBuilder b(int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 8;
        }
        return a(i8);
    }
}

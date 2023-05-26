package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Collection;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z7, @NonNull String str) {
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    @NonNull
    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T c(@NonNull T t7) {
        if (!t7.isEmpty()) {
            return t7;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    @NonNull
    public static <T> T d(T t7) {
        return (T) e(t7, "Argument must not be null");
    }

    @NonNull
    public static <T> T e(T t7, @NonNull String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }
}

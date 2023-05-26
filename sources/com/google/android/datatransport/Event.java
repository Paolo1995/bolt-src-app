package com.google.android.datatransport;

/* loaded from: classes.dex */
public abstract class Event<T> {
    public static <T> Event<T> d(T t7) {
        return new AutoValue_Event(null, t7, Priority.DEFAULT);
    }

    public static <T> Event<T> e(T t7) {
        return new AutoValue_Event(null, t7, Priority.VERY_LOW);
    }

    public static <T> Event<T> f(T t7) {
        return new AutoValue_Event(null, t7, Priority.HIGHEST);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}

package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.Set;

/* loaded from: classes.dex */
public interface Config {

    /* loaded from: classes.dex */
    public static abstract class Option<T> {
        @NonNull
        public static <T> Option<T> a(@NonNull String str, @NonNull Class<?> cls) {
            return b(str, cls, null);
        }

        @NonNull
        public static <T> Option<T> b(@NonNull String str, @NonNull Class<?> cls, Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }

        @NonNull
        public abstract String c();

        public abstract Object d();

        @NonNull
        public abstract Class<T> e();
    }

    /* loaded from: classes.dex */
    public interface OptionMatcher {
        boolean a(@NonNull Option<?> option);
    }

    /* loaded from: classes.dex */
    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    <ValueT> ValueT a(@NonNull Option<ValueT> option);

    boolean b(@NonNull Option<?> option);

    @NonNull
    Set<Option<?>> c();

    <ValueT> ValueT e(@NonNull Option<ValueT> option, ValueT valuet);

    @NonNull
    OptionPriority f(@NonNull Option<?> option);

    void l(@NonNull String str, @NonNull OptionMatcher optionMatcher);

    <ValueT> ValueT m(@NonNull Option<ValueT> option, @NonNull OptionPriority optionPriority);

    @NonNull
    Set<OptionPriority> t(@NonNull Option<?> option);
}

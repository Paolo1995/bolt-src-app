package android.os;

import android.annotation.NonNull;
import android.annotation.Nullable;
import java.util.Locale;

/* loaded from: classes.dex */
public final /* synthetic */ class LocaleList implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ LocaleList(@NonNull Locale... localeArr) {
    }

    @NonNull
    public static native /* synthetic */ LocaleList forLanguageTags(@Nullable String str);

    @NonNull
    public static native /* synthetic */ LocaleList getAdjustedDefault();

    @NonNull
    public static native /* synthetic */ LocaleList getDefault();

    public static native /* synthetic */ void setDefault(@NonNull LocaleList localeList);

    public native /* synthetic */ boolean equals(@Nullable Object obj);

    public native /* synthetic */ Locale get(int i8);

    public native /* synthetic */ int hashCode();

    public native /* synthetic */ boolean isEmpty();

    public native /* synthetic */ int size();

    @NonNull
    public native /* synthetic */ String toLanguageTags();

    public native /* synthetic */ String toString();
}

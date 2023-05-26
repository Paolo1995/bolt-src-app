package android.text;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.text.Layout;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final /* synthetic */ class StaticLayout$Builder {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ StaticLayout$Builder obtain(@NonNull CharSequence charSequence, int i8, int i9, @NonNull TextPaint textPaint, int i10);

    @NonNull
    public native /* synthetic */ StaticLayout build();

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setAlignment(@NonNull Layout.Alignment alignment);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setBreakStrategy(int i8);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setEllipsize(@Nullable TextUtils.TruncateAt truncateAt);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setHyphenationFrequency(int i8);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setIncludePad(boolean z7);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setLineSpacing(float f8, float f9);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setMaxLines(int i8);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic);
}

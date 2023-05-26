package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class CustomTabColorSchemeParams {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f2323a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f2324b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f2325c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f2326d;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f2327a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f2328b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f2329c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f2330d;

        @NonNull
        public CustomTabColorSchemeParams a() {
            return new CustomTabColorSchemeParams(this.f2327a, this.f2328b, this.f2329c, this.f2330d);
        }

        @NonNull
        public Builder b(int i8) {
            this.f2327a = Integer.valueOf(i8 | (-16777216));
            return this;
        }
    }

    CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f2323a = num;
        this.f2324b = num2;
        this.f2325c = num3;
        this.f2326d = num4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f2323a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f2324b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f2325c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f2326d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}

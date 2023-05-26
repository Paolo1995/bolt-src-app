package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppStickyBanner.kt */
/* loaded from: classes3.dex */
public final class AppStickyBanner {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f32167a;

    /* renamed from: b  reason: collision with root package name */
    private final Image f32168b;

    /* renamed from: c  reason: collision with root package name */
    private final Color f32169c;

    public AppStickyBanner(CharSequence text, Image image, Color color) {
        Intrinsics.f(text, "text");
        this.f32167a = text;
        this.f32168b = image;
        this.f32169c = color;
    }

    public final Color a() {
        return this.f32169c;
    }

    public final Image b() {
        return this.f32168b;
    }

    public final CharSequence c() {
        return this.f32167a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppStickyBanner) {
            AppStickyBanner appStickyBanner = (AppStickyBanner) obj;
            return Intrinsics.a(this.f32167a, appStickyBanner.f32167a) && Intrinsics.a(this.f32168b, appStickyBanner.f32168b) && Intrinsics.a(this.f32169c, appStickyBanner.f32169c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f32167a.hashCode() * 31;
        Image image = this.f32168b;
        int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
        Color color = this.f32169c;
        return hashCode2 + (color != null ? color.hashCode() : 0);
    }

    public String toString() {
        CharSequence charSequence = this.f32167a;
        Image image = this.f32168b;
        Color color = this.f32169c;
        return "AppStickyBanner(text=" + ((Object) charSequence) + ", image=" + image + ", backgroundColor=" + color + ")";
    }
}

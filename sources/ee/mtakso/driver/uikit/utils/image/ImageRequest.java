package ee.mtakso.driver.uikit.utils.image;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageRequest.kt */
/* loaded from: classes5.dex */
public final class ImageRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f36079a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageSize f36080b;

    /* renamed from: c  reason: collision with root package name */
    private final Drawable f36081c;

    /* renamed from: d  reason: collision with root package name */
    private final Drawable f36082d;

    public ImageRequest(String url, ImageSize imageSize, Drawable drawable, Drawable drawable2) {
        Intrinsics.f(url, "url");
        this.f36079a = url;
        this.f36080b = imageSize;
        this.f36081c = drawable;
        this.f36082d = drawable2;
    }

    public final Drawable a() {
        return this.f36082d;
    }

    public final ImageSize b() {
        return this.f36080b;
    }

    public final Drawable c() {
        return this.f36081c;
    }

    public final String d() {
        return this.f36079a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return Intrinsics.a(this.f36079a, imageRequest.f36079a) && Intrinsics.a(this.f36080b, imageRequest.f36080b) && Intrinsics.a(this.f36081c, imageRequest.f36081c) && Intrinsics.a(this.f36082d, imageRequest.f36082d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f36079a.hashCode() * 31;
        ImageSize imageSize = this.f36080b;
        int hashCode2 = (hashCode + (imageSize == null ? 0 : imageSize.hashCode())) * 31;
        Drawable drawable = this.f36081c;
        int hashCode3 = (hashCode2 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Drawable drawable2 = this.f36082d;
        return hashCode3 + (drawable2 != null ? drawable2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f36079a;
        ImageSize imageSize = this.f36080b;
        Drawable drawable = this.f36081c;
        Drawable drawable2 = this.f36082d;
        return "ImageRequest(url=" + str + ", newSize=" + imageSize + ", placeholder=" + drawable + ", error=" + drawable2 + ")";
    }

    public /* synthetic */ ImageRequest(String str, ImageSize imageSize, Drawable drawable, Drawable drawable2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : imageSize, (i8 & 4) != 0 ? null : drawable, (i8 & 8) != 0 ? null : drawable2);
    }
}

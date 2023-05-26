package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerData.kt */
/* loaded from: classes3.dex */
public final class BannerData<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Text f28981a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f28982b;

    /* renamed from: c  reason: collision with root package name */
    private final Image f28983c;

    /* renamed from: d  reason: collision with root package name */
    private final Color f28984d;

    /* renamed from: e  reason: collision with root package name */
    private final BannerItem f28985e;

    /* renamed from: f  reason: collision with root package name */
    private final T f28986f;

    public BannerData(Text title, Text text, Image image, Color backgroundColor, BannerItem bannerItem, T t7) {
        Intrinsics.f(title, "title");
        Intrinsics.f(backgroundColor, "backgroundColor");
        this.f28981a = title;
        this.f28982b = text;
        this.f28983c = image;
        this.f28984d = backgroundColor;
        this.f28985e = bannerItem;
        this.f28986f = t7;
    }

    public final Color a() {
        return this.f28984d;
    }

    public final Image b() {
        return this.f28983c;
    }

    public final T c() {
        return this.f28986f;
    }

    public final Text d() {
        return this.f28982b;
    }

    public final Text e() {
        return this.f28981a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BannerData) {
            BannerData bannerData = (BannerData) obj;
            return Intrinsics.a(this.f28981a, bannerData.f28981a) && Intrinsics.a(this.f28982b, bannerData.f28982b) && Intrinsics.a(this.f28983c, bannerData.f28983c) && Intrinsics.a(this.f28984d, bannerData.f28984d) && Intrinsics.a(this.f28985e, bannerData.f28985e) && Intrinsics.a(this.f28986f, bannerData.f28986f);
        }
        return false;
    }

    public final BannerItem f() {
        return this.f28985e;
    }

    public int hashCode() {
        int hashCode = this.f28981a.hashCode() * 31;
        Text text = this.f28982b;
        int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
        Image image = this.f28983c;
        int hashCode3 = (((hashCode2 + (image == null ? 0 : image.hashCode())) * 31) + this.f28984d.hashCode()) * 31;
        BannerItem bannerItem = this.f28985e;
        int hashCode4 = (hashCode3 + (bannerItem == null ? 0 : bannerItem.hashCode())) * 31;
        T t7 = this.f28986f;
        return hashCode4 + (t7 != null ? t7.hashCode() : 0);
    }

    public String toString() {
        Text text = this.f28981a;
        Text text2 = this.f28982b;
        Image image = this.f28983c;
        Color color = this.f28984d;
        BannerItem bannerItem = this.f28985e;
        T t7 = this.f28986f;
        return "BannerData(title=" + text + ", subtitle=" + text2 + ", image=" + image + ", backgroundColor=" + color + ", trailingComponent=" + bannerItem + ", payload=" + t7 + ")";
    }
}

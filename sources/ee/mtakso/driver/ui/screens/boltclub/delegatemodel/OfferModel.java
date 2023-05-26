package ee.mtakso.driver.ui.screens.boltclub.delegatemodel;

import ee.mtakso.driver.uikit.utils.Image;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfferModel.kt */
/* loaded from: classes3.dex */
public final class OfferModel {

    /* renamed from: a  reason: collision with root package name */
    private final long f27184a;

    /* renamed from: b  reason: collision with root package name */
    private final Image f27185b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27186c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27187d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27188e;

    public OfferModel(long j8, Image logo, String title, String str, String str2) {
        Intrinsics.f(logo, "logo");
        Intrinsics.f(title, "title");
        this.f27184a = j8;
        this.f27185b = logo;
        this.f27186c = title;
        this.f27187d = str;
        this.f27188e = str2;
    }

    public final String a() {
        return this.f27188e;
    }

    public final Image b() {
        return this.f27185b;
    }

    public final long c() {
        return this.f27184a;
    }

    public final String d() {
        return this.f27187d;
    }

    public final String e() {
        return this.f27186c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfferModel) {
            OfferModel offerModel = (OfferModel) obj;
            return this.f27184a == offerModel.f27184a && Intrinsics.a(this.f27185b, offerModel.f27185b) && Intrinsics.a(this.f27186c, offerModel.f27186c) && Intrinsics.a(this.f27187d, offerModel.f27187d) && Intrinsics.a(this.f27188e, offerModel.f27188e);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((a.a(this.f27184a) * 31) + this.f27185b.hashCode()) * 31) + this.f27186c.hashCode()) * 31;
        String str = this.f27187d;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f27188e;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f27184a;
        Image image = this.f27185b;
        String str = this.f27186c;
        String str2 = this.f27187d;
        String str3 = this.f27188e;
        return "OfferModel(offerId=" + j8 + ", logo=" + image + ", title=" + str + ", shortDescription=" + str2 + ", formattedDiscount=" + str3 + ")";
    }
}

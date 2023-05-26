package ee.mtakso.driver.ui.screens.boltclub;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubDetailsState.kt */
/* loaded from: classes3.dex */
public final class BoltClubDetailsState {

    /* renamed from: a  reason: collision with root package name */
    private final long f27118a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27119b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27120c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ListModel> f27121d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f27122e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f27123f;

    /* JADX WARN: Multi-variable type inference failed */
    public BoltClubDetailsState(long j8, String offerTitle, String str, List<? extends ListModel> model, boolean z7, boolean z8) {
        Intrinsics.f(offerTitle, "offerTitle");
        Intrinsics.f(model, "model");
        this.f27118a = j8;
        this.f27119b = offerTitle;
        this.f27120c = str;
        this.f27121d = model;
        this.f27122e = z7;
        this.f27123f = z8;
    }

    public final BoltClubDetailsState a(long j8, String offerTitle, String str, List<? extends ListModel> model, boolean z7, boolean z8) {
        Intrinsics.f(offerTitle, "offerTitle");
        Intrinsics.f(model, "model");
        return new BoltClubDetailsState(j8, offerTitle, str, model, z7, z8);
    }

    public final String c() {
        return this.f27120c;
    }

    public final List<ListModel> d() {
        return this.f27121d;
    }

    public final long e() {
        return this.f27118a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltClubDetailsState) {
            BoltClubDetailsState boltClubDetailsState = (BoltClubDetailsState) obj;
            return this.f27118a == boltClubDetailsState.f27118a && Intrinsics.a(this.f27119b, boltClubDetailsState.f27119b) && Intrinsics.a(this.f27120c, boltClubDetailsState.f27120c) && Intrinsics.a(this.f27121d, boltClubDetailsState.f27121d) && this.f27122e == boltClubDetailsState.f27122e && this.f27123f == boltClubDetailsState.f27123f;
        }
        return false;
    }

    public final String f() {
        return this.f27119b;
    }

    public final boolean g() {
        return this.f27122e;
    }

    public final boolean h() {
        return this.f27123f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((i0.a.a(this.f27118a) * 31) + this.f27119b.hashCode()) * 31;
        String str = this.f27120c;
        int hashCode = (((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f27121d.hashCode()) * 31;
        boolean z7 = this.f27122e;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f27123f;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        long j8 = this.f27118a;
        String str = this.f27119b;
        String str2 = this.f27120c;
        List<ListModel> list = this.f27121d;
        boolean z7 = this.f27122e;
        boolean z8 = this.f27123f;
        return "BoltClubDetailsState(offerId=" + j8 + ", offerTitle=" + str + ", integrationDataActionType=" + str2 + ", model=" + list + ", isFavourite=" + z7 + ", isFavouriteIconShown=" + z8 + ")";
    }
}

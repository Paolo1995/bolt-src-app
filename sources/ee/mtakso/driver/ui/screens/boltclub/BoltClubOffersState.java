package ee.mtakso.driver.ui.screens.boltclub;

import ee.mtakso.driver.network.client.boltclub.model.NoOffersAvailable;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubOffersState.kt */
/* loaded from: classes3.dex */
public final class BoltClubOffersState {

    /* renamed from: a  reason: collision with root package name */
    private final String f27162a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ListModel> f27163b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27164c;

    /* renamed from: d  reason: collision with root package name */
    private final NoOffersAvailable f27165d;

    /* JADX WARN: Multi-variable type inference failed */
    public BoltClubOffersState(String title, List<? extends ListModel> models, String str, NoOffersAvailable noOffersAvailable) {
        Intrinsics.f(title, "title");
        Intrinsics.f(models, "models");
        this.f27162a = title;
        this.f27163b = models;
        this.f27164c = str;
        this.f27165d = noOffersAvailable;
    }

    public final String a() {
        return this.f27164c;
    }

    public final List<ListModel> b() {
        return this.f27163b;
    }

    public final NoOffersAvailable c() {
        return this.f27165d;
    }

    public final String d() {
        return this.f27162a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltClubOffersState) {
            BoltClubOffersState boltClubOffersState = (BoltClubOffersState) obj;
            return Intrinsics.a(this.f27162a, boltClubOffersState.f27162a) && Intrinsics.a(this.f27163b, boltClubOffersState.f27163b) && Intrinsics.a(this.f27164c, boltClubOffersState.f27164c) && Intrinsics.a(this.f27165d, boltClubOffersState.f27165d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f27162a.hashCode() * 31) + this.f27163b.hashCode()) * 31;
        String str = this.f27164c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        NoOffersAvailable noOffersAvailable = this.f27165d;
        return hashCode2 + (noOffersAvailable != null ? noOffersAvailable.hashCode() : 0);
    }

    public String toString() {
        String str = this.f27162a;
        List<ListModel> list = this.f27163b;
        String str2 = this.f27164c;
        NoOffersAvailable noOffersAvailable = this.f27165d;
        return "BoltClubOffersState(title=" + str + ", models=" + list + ", faqLink=" + str2 + ", noOffersAvailable=" + noOffersAvailable + ")";
    }
}

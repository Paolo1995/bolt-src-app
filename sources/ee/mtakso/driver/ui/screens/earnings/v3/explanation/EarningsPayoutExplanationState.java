package ee.mtakso.driver.ui.screens.earnings.v3.explanation;

import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsPayoutExplanationState.kt */
/* loaded from: classes3.dex */
public final class EarningsPayoutExplanationState {

    /* renamed from: a  reason: collision with root package name */
    private final Text f29078a;

    /* renamed from: b  reason: collision with root package name */
    private final List<EarningsPayoutExplanationDelegate.Model> f29079b;

    /* renamed from: c  reason: collision with root package name */
    private final List<InfoBlockDelegate.Model> f29080c;

    public EarningsPayoutExplanationState() {
        this(null, null, null, 7, null);
    }

    public EarningsPayoutExplanationState(Text text, List<EarningsPayoutExplanationDelegate.Model> items, List<InfoBlockDelegate.Model> infoBlocks) {
        Intrinsics.f(items, "items");
        Intrinsics.f(infoBlocks, "infoBlocks");
        this.f29078a = text;
        this.f29079b = items;
        this.f29080c = infoBlocks;
    }

    public final EarningsPayoutExplanationState a(Text text, List<EarningsPayoutExplanationDelegate.Model> items, List<InfoBlockDelegate.Model> infoBlocks) {
        Intrinsics.f(items, "items");
        Intrinsics.f(infoBlocks, "infoBlocks");
        return new EarningsPayoutExplanationState(text, items, infoBlocks);
    }

    public final List<InfoBlockDelegate.Model> b() {
        return this.f29080c;
    }

    public final List<EarningsPayoutExplanationDelegate.Model> c() {
        return this.f29079b;
    }

    public final Text d() {
        return this.f29078a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsPayoutExplanationState) {
            EarningsPayoutExplanationState earningsPayoutExplanationState = (EarningsPayoutExplanationState) obj;
            return Intrinsics.a(this.f29078a, earningsPayoutExplanationState.f29078a) && Intrinsics.a(this.f29079b, earningsPayoutExplanationState.f29079b) && Intrinsics.a(this.f29080c, earningsPayoutExplanationState.f29080c);
        }
        return false;
    }

    public int hashCode() {
        Text text = this.f29078a;
        return ((((text == null ? 0 : text.hashCode()) * 31) + this.f29079b.hashCode()) * 31) + this.f29080c.hashCode();
    }

    public String toString() {
        Text text = this.f29078a;
        List<EarningsPayoutExplanationDelegate.Model> list = this.f29079b;
        List<InfoBlockDelegate.Model> list2 = this.f29080c;
        return "EarningsPayoutExplanationState(title=" + text + ", items=" + list + ", infoBlocks=" + list2 + ")";
    }

    public /* synthetic */ EarningsPayoutExplanationState(Text text, List list, List list2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : text, (i8 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 4) != 0 ? CollectionsKt__CollectionsKt.k() : list2);
    }
}

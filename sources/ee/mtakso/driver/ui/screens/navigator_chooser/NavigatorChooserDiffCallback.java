package ee.mtakso.driver.ui.screens.navigator_chooser;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorChooserDiffCallback.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserDiffCallback extends DiffUtil.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final List<NavigatorItem> f30911a;

    /* renamed from: b  reason: collision with root package name */
    private final List<NavigatorItem> f30912b;

    public NavigatorChooserDiffCallback(List<NavigatorItem> oldItemsList, List<NavigatorItem> newItemsList) {
        Intrinsics.f(oldItemsList, "oldItemsList");
        Intrinsics.f(newItemsList, "newItemsList");
        this.f30911a = oldItemsList;
        this.f30912b = newItemsList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean a(int i8, int i9) {
        return Intrinsics.a(this.f30911a.get(i8), this.f30912b.get(i9));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean b(int i8, int i9) {
        return Intrinsics.a(this.f30911a.get(i8).c(), this.f30912b.get(i9).c());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public Object c(int i8, int i9) {
        boolean z7;
        NavigatorItem navigatorItem = this.f30911a.get(i8);
        NavigatorItem navigatorItem2 = this.f30912b.get(i9);
        Boolean bool = null;
        if (Intrinsics.a(navigatorItem, navigatorItem2)) {
            return null;
        }
        Boolean valueOf = Boolean.valueOf(navigatorItem2.d());
        valueOf.booleanValue();
        if (navigatorItem2.d() != navigatorItem.d()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            bool = valueOf;
        }
        return new Payload(bool);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int d() {
        return this.f30912b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int e() {
        return this.f30911a.size();
    }

    /* compiled from: NavigatorChooserDiffCallback.kt */
    /* loaded from: classes3.dex */
    public static final class Payload {

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f30913a;

        public Payload() {
            this(null, 1, null);
        }

        public Payload(Boolean bool) {
            this.f30913a = bool;
        }

        public final Boolean a() {
            return this.f30913a;
        }

        public /* synthetic */ Payload(Boolean bool, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : bool);
        }
    }
}

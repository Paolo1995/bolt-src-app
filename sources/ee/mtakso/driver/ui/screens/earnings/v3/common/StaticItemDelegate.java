package ee.mtakso.driver.ui.screens.earnings.v3.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsSpan;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticItemDelegate.kt */
/* loaded from: classes3.dex */
public final class StaticItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f29052b;

    /* compiled from: StaticItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static abstract class Model extends ListModel {
        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int n();

        /* compiled from: StaticItemDelegate.kt */
        /* loaded from: classes3.dex */
        public static final class Grid extends Model implements SpanModel {

            /* renamed from: a  reason: collision with root package name */
            private final String f29053a;

            /* renamed from: b  reason: collision with root package name */
            private final int f29054b;

            /* renamed from: c  reason: collision with root package name */
            private final SpanModel f29055c;

            public /* synthetic */ Grid(String str, int i8, SpanModel spanModel, int i9, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i8, (i9 & 4) != 0 ? EarningsSpan.f28766a : spanModel);
            }

            @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
            public int b() {
                return this.f29055c.b();
            }

            @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
            public int c() {
                return this.f29055c.c();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Grid) {
                    Grid grid = (Grid) obj;
                    return Intrinsics.a(m(), grid.m()) && n() == grid.n() && Intrinsics.a(this.f29055c, grid.f29055c);
                }
                return false;
            }

            @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
            public int g() {
                return this.f29055c.g();
            }

            @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
            public int h() {
                return this.f29055c.h();
            }

            @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
            public int hashCode() {
                return (((m().hashCode() * 31) + n()) * 31) + this.f29055c.hashCode();
            }

            @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
            public String m() {
                return this.f29053a;
            }

            @Override // ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate.Model
            public int n() {
                return this.f29054b;
            }

            public String toString() {
                String m8 = m();
                int n8 = n();
                SpanModel spanModel = this.f29055c;
                return "Grid(listId=" + m8 + ", layoutRes=" + n8 + ", span=" + spanModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Grid(String listId, int i8, SpanModel span) {
                super(null);
                Intrinsics.f(listId, "listId");
                Intrinsics.f(span, "span");
                this.f29053a = listId;
                this.f29054b = i8;
                this.f29055c = span;
            }
        }

        /* compiled from: StaticItemDelegate.kt */
        /* loaded from: classes3.dex */
        public static final class List extends Model implements DividerModel {

            /* renamed from: a  reason: collision with root package name */
            private final String f29056a;

            /* renamed from: b  reason: collision with root package name */
            private final int f29057b;

            /* renamed from: c  reason: collision with root package name */
            private final DividerModel f29058c;

            public /* synthetic */ List(String str, int i8, DividerModel dividerModel, int i9, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i8, (i9 & 4) != 0 ? NoDivider.f34829a : dividerModel);
            }

            @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
            public Color d() {
                return this.f29058c.d();
            }

            @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
            public boolean e() {
                return this.f29058c.e();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof List) {
                    List list = (List) obj;
                    return Intrinsics.a(m(), list.m()) && n() == list.n() && Intrinsics.a(this.f29058c, list.f29058c);
                }
                return false;
            }

            @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
            public Color f() {
                return this.f29058c.f();
            }

            @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
            public int hashCode() {
                return (((m().hashCode() * 31) + n()) * 31) + this.f29058c.hashCode();
            }

            @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
            public Float i() {
                return this.f29058c.i();
            }

            @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
            public boolean j() {
                return this.f29058c.j();
            }

            @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
            public boolean k() {
                return this.f29058c.k();
            }

            @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
            public String m() {
                return this.f29056a;
            }

            @Override // ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate.Model
            public int n() {
                return this.f29057b;
            }

            public String toString() {
                String m8 = m();
                int n8 = n();
                DividerModel dividerModel = this.f29058c;
                return "List(listId=" + m8 + ", layoutRes=" + n8 + ", divider=" + dividerModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public List(String listId, int i8, DividerModel divider) {
                super(null);
                Intrinsics.f(listId, "listId");
                Intrinsics.f(divider, "divider");
                this.f29056a = listId;
                this.f29057b = i8;
                this.f29058c = divider;
            }
        }
    }

    /* compiled from: StaticItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29059u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f29060v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f29060v = new LinkedHashMap();
            this.f29059u = containerView;
        }
    }

    public StaticItemDelegate(int i8) {
        this.f29052b = i8;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29052b;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        if ((model instanceof Model) && ((Model) model).n() == this.f29052b) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View inflate = inflater.inflate(this.f29052b, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(layoutRes, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}

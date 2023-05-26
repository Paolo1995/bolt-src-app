package ee.mtakso.driver.ui.screens.vehicle.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.vehicle.list.VehicleApplicationDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.ChipExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import i0.a;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VehicleApplicationDelegate.kt */
/* loaded from: classes5.dex */
public final class VehicleApplicationDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Long, Unit> f33596b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33597c;

    /* compiled from: VehicleApplicationDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f33611u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f33612v;

        /* renamed from: w  reason: collision with root package name */
        private final Chip f33613w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.vehicleTitle);
            Intrinsics.e(textView, "itemView.vehicleTitle");
            this.f33611u = textView;
            TextView textView2 = (TextView) itemView.findViewById(R.id.vehicleDescription);
            Intrinsics.e(textView2, "itemView.vehicleDescription");
            this.f33612v = textView2;
            Chip chip = (Chip) itemView.findViewById(R.id.applicationState);
            Intrinsics.e(chip, "itemView.applicationState");
            this.f33613w = chip;
        }

        public final TextView O() {
            return this.f33612v;
        }

        public final Chip P() {
            return this.f33613w;
        }

        public final TextView Q() {
            return this.f33611u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VehicleApplicationDelegate(Function1<? super Long, Unit> onItemClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f33596b = onItemClickListener;
        this.f33597c = R.layout.fragment_vehicle_list_application;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(VehicleApplicationDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f33596b.invoke(Long.valueOf(model.n()));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f33597c;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View view = inflater.inflate(R.layout.fragment_vehicle_list_application, parent, false);
        Intrinsics.e(view, "view");
        return new ViewHolder(view);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.Q().setText(model.s());
        holder.O().setText(model.r());
        holder.P().setText(holder.f7332a.getContext().getText(model.p()));
        TextViewExtKt.i(holder.P(), model.q());
        ChipExtKt.a(holder.P(), model.o());
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: i5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VehicleApplicationDelegate.u(VehicleApplicationDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: VehicleApplicationDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f33598a;

        /* renamed from: b  reason: collision with root package name */
        private final long f33599b;

        /* renamed from: c  reason: collision with root package name */
        private final String f33600c;

        /* renamed from: d  reason: collision with root package name */
        private final String f33601d;

        /* renamed from: e  reason: collision with root package name */
        private final int f33602e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f33603f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f33604g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33605h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f33606i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f33607j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f33608k;

        /* renamed from: l  reason: collision with root package name */
        private final Color f33609l;

        /* renamed from: m  reason: collision with root package name */
        private final float f33610m;

        public /* synthetic */ Model(String str, long j8, String str2, String str3, int i8, Color color, Color color2, boolean z7, boolean z8, boolean z9, Color color3, Color color4, float f8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j8, str2, str3, i8, color, color2, (i9 & 128) != 0 ? true : z7, (i9 & Spliterator.NONNULL) != 0 ? false : z8, (i9 & 512) != 0 ? false : z9, (i9 & Spliterator.IMMUTABLE) != 0 ? new Color.Attr(R.attr.dynamicNeutral01) : color3, (i9 & 2048) != 0 ? new Color.Attr(R.attr.backPrimary) : color4, (i9 & 4096) != 0 ? Dimens.b(1.0f) : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f33608k;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f33605h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f33599b == model.f33599b && Intrinsics.a(this.f33600c, model.f33600c) && Intrinsics.a(this.f33601d, model.f33601d) && this.f33602e == model.f33602e && Intrinsics.a(this.f33603f, model.f33603f) && Intrinsics.a(this.f33604g, model.f33604g) && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f33609l;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((((m().hashCode() * 31) + a.a(this.f33599b)) * 31) + this.f33600c.hashCode()) * 31) + this.f33601d.hashCode()) * 31) + this.f33602e) * 31;
            Color color = this.f33603f;
            int hashCode2 = (hashCode + (color == null ? 0 : color.hashCode())) * 31;
            Color color2 = this.f33604g;
            int hashCode3 = (hashCode2 + (color2 != null ? color2.hashCode() : 0)) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode3 + i8) * 31;
            boolean j8 = j();
            int i10 = j8;
            if (j8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean k8 = k();
            return ((((((i11 + (k8 ? 1 : k8)) * 31) + d().hashCode()) * 31) + f().hashCode()) * 31) + i().hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f33610m);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f33606i;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f33607j;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f33598a;
        }

        public final long n() {
            return this.f33599b;
        }

        public final Color o() {
            return this.f33604g;
        }

        public final int p() {
            return this.f33602e;
        }

        public final Color q() {
            return this.f33603f;
        }

        public final String r() {
            return this.f33601d;
        }

        public final String s() {
            return this.f33600c;
        }

        public String toString() {
            String m8 = m();
            long j8 = this.f33599b;
            String str = this.f33600c;
            String str2 = this.f33601d;
            int i8 = this.f33602e;
            Color color = this.f33603f;
            Color color2 = this.f33604g;
            boolean e8 = e();
            boolean j9 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i9 = i();
            return "Model(listId=" + m8 + ", applicationId=" + j8 + ", title=" + str + ", description=" + str2 + ", chipText=" + i8 + ", chipTextColor=" + color + ", chipBgColor=" + color2 + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j9 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i9 + ")";
        }

        public Model(String listId, long j8, String title, String description, int i8, Color color, Color color2, boolean z7, boolean z8, boolean z9, Color dividerColor, Color dividerBackColor, float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(description, "description");
            Intrinsics.f(dividerColor, "dividerColor");
            Intrinsics.f(dividerBackColor, "dividerBackColor");
            this.f33598a = listId;
            this.f33599b = j8;
            this.f33600c = title;
            this.f33601d = description;
            this.f33602e = i8;
            this.f33603f = color;
            this.f33604g = color2;
            this.f33605h = z7;
            this.f33606i = z8;
            this.f33607j = z9;
            this.f33608k = dividerColor;
            this.f33609l = dividerBackColor;
            this.f33610m = f8;
        }
    }
}

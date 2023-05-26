package ee.mtakso.driver.ui.screens.vehicle.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.vehicle.list.InsuredVehicleDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import i0.a;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InsuredVehicleDelegate.kt */
/* loaded from: classes5.dex */
public final class InsuredVehicleDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Long, Unit> f33577b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<Long, Unit> f33578c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33579d;

    /* compiled from: InsuredVehicleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f33592u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f33593v;

        /* renamed from: w  reason: collision with root package name */
        private final RadioButton f33594w;

        /* renamed from: x  reason: collision with root package name */
        private final TextView f33595x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.vehicleTitle);
            Intrinsics.e(textView, "itemView.vehicleTitle");
            this.f33592u = textView;
            TextView textView2 = (TextView) itemView.findViewById(R.id.vehicleDescription);
            Intrinsics.e(textView2, "itemView.vehicleDescription");
            this.f33593v = textView2;
            RadioButton radioButton = (RadioButton) itemView.findViewById(R.id.vehicleRadioButton);
            Intrinsics.e(radioButton, "itemView.vehicleRadioButton");
            this.f33594w = radioButton;
            TextView textView3 = (TextView) itemView.findViewById(R.id.vehicleInsuranceButton);
            Intrinsics.e(textView3, "itemView.vehicleInsuranceButton");
            this.f33595x = textView3;
        }

        public final RadioButton O() {
            return this.f33594w;
        }

        public final TextView P() {
            return this.f33593v;
        }

        public final TextView Q() {
            return this.f33595x;
        }

        public final TextView R() {
            return this.f33592u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InsuredVehicleDelegate(Function1<? super Long, Unit> onItemClickListener, Function1<? super Long, Unit> onInsuranceClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        Intrinsics.f(onInsuranceClickListener, "onInsuranceClickListener");
        this.f33577b = onItemClickListener;
        this.f33578c = onInsuranceClickListener;
        this.f33579d = R.layout.fragment_vehicle_list_insured;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(InsuredVehicleDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f33577b.invoke(Long.valueOf(model.p()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(InsuredVehicleDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f33578c.invoke(Long.valueOf(model.p()));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f33579d;
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
        View view = inflater.inflate(R.layout.fragment_vehicle_list_insured, parent, false);
        Intrinsics.e(view, "view");
        return new ViewHolder(view);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.R().setText(model.o());
        holder.P().setText(model.n());
        holder.O().setChecked(model.q());
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: i5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InsuredVehicleDelegate.v(InsuredVehicleDelegate.this, model, view);
            }
        });
        holder.Q().setOnClickListener(new View.OnClickListener() { // from class: i5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InsuredVehicleDelegate.w(InsuredVehicleDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: InsuredVehicleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f33580a;

        /* renamed from: b  reason: collision with root package name */
        private final long f33581b;

        /* renamed from: c  reason: collision with root package name */
        private final String f33582c;

        /* renamed from: d  reason: collision with root package name */
        private final String f33583d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f33584e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f33585f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f33586g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33587h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f33588i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f33589j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f33590k;

        /* renamed from: l  reason: collision with root package name */
        private final float f33591l;

        public /* synthetic */ Model(String str, long j8, String str2, String str3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Color color, Color color2, float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j8, str2, str3, z7, z8, (i8 & 64) != 0 ? true : z9, (i8 & 128) != 0 ? false : z10, (i8 & Spliterator.NONNULL) != 0 ? true : z11, (i8 & 512) != 0 ? new Color.Attr(R.attr.backTertiary) : color, (i8 & Spliterator.IMMUTABLE) != 0 ? null : color2, (i8 & 2048) != 0 ? Dimens.b(8.0f) : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f33589j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f33586g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f33581b == model.f33581b && Intrinsics.a(this.f33582c, model.f33582c) && Intrinsics.a(this.f33583d, model.f33583d) && this.f33584e == model.f33584e && this.f33585f == model.f33585f && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f33590k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((m().hashCode() * 31) + a.a(this.f33581b)) * 31) + this.f33582c.hashCode()) * 31) + this.f33583d.hashCode()) * 31;
            boolean z7 = this.f33584e;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean z8 = this.f33585f;
            int i10 = z8;
            if (z8 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean e8 = e();
            int i12 = e8;
            if (e8) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            boolean j8 = j();
            int i14 = j8;
            if (j8) {
                i14 = 1;
            }
            int i15 = (i13 + i14) * 31;
            boolean k8 = k();
            return ((((((i15 + (k8 ? 1 : k8)) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() != null ? f().hashCode() : 0)) * 31) + i().hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f33591l);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f33587h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f33588i;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f33580a;
        }

        public final String n() {
            return this.f33583d;
        }

        public final String o() {
            return this.f33582c;
        }

        public final long p() {
            return this.f33581b;
        }

        public final boolean q() {
            return this.f33584e;
        }

        public String toString() {
            String m8 = m();
            long j8 = this.f33581b;
            String str = this.f33582c;
            String str2 = this.f33583d;
            boolean z7 = this.f33584e;
            boolean z8 = this.f33585f;
            boolean e8 = e();
            boolean j9 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            return "Model(listId=" + m8 + ", vehicleId=" + j8 + ", title=" + str + ", description=" + str2 + ", isSelected=" + z7 + ", isSelectable=" + z8 + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j9 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
        }

        public Model(String listId, long j8, String title, String description, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Color color, Color color2, float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(description, "description");
            this.f33580a = listId;
            this.f33581b = j8;
            this.f33582c = title;
            this.f33583d = description;
            this.f33584e = z7;
            this.f33585f = z8;
            this.f33586g = z9;
            this.f33587h = z10;
            this.f33588i = z11;
            this.f33589j = color;
            this.f33590k = color2;
            this.f33591l = f8;
        }
    }
}

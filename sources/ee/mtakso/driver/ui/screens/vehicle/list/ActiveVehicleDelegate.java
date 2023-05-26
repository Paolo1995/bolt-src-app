package ee.mtakso.driver.ui.screens.vehicle.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.vehicle.list.ActiveVehicleDelegate;
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

/* compiled from: ActiveVehicleDelegate.kt */
/* loaded from: classes5.dex */
public final class ActiveVehicleDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Long, Unit> f33560b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33561c;

    /* compiled from: ActiveVehicleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f33574u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f33575v;

        /* renamed from: w  reason: collision with root package name */
        private final RadioButton f33576w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.vehicleTitle);
            Intrinsics.e(textView, "itemView.vehicleTitle");
            this.f33574u = textView;
            TextView textView2 = (TextView) itemView.findViewById(R.id.vehicleDescription);
            Intrinsics.e(textView2, "itemView.vehicleDescription");
            this.f33575v = textView2;
            RadioButton radioButton = (RadioButton) itemView.findViewById(R.id.vehicleRadioButton);
            Intrinsics.e(radioButton, "itemView.vehicleRadioButton");
            this.f33576w = radioButton;
        }

        public final RadioButton O() {
            return this.f33576w;
        }

        public final TextView P() {
            return this.f33575v;
        }

        public final TextView Q() {
            return this.f33574u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActiveVehicleDelegate(Function1<? super Long, Unit> onItemClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f33560b = onItemClickListener;
        this.f33561c = R.layout.fragment_vehicle_list_active;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ActiveVehicleDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f33560b.invoke(Long.valueOf(model.p()));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f33561c;
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
        View view = inflater.inflate(R.layout.fragment_vehicle_list_active, parent, false);
        Intrinsics.e(view, "view");
        return new ViewHolder(view);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.Q().setText(model.o());
        holder.P().setText(model.n());
        holder.O().setChecked(model.q());
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: i5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveVehicleDelegate.u(ActiveVehicleDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ActiveVehicleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f33562a;

        /* renamed from: b  reason: collision with root package name */
        private final long f33563b;

        /* renamed from: c  reason: collision with root package name */
        private final String f33564c;

        /* renamed from: d  reason: collision with root package name */
        private final String f33565d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f33566e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f33567f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f33568g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33569h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f33570i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f33571j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f33572k;

        /* renamed from: l  reason: collision with root package name */
        private final float f33573l;

        public /* synthetic */ Model(String str, long j8, String str2, String str3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Color color, Color color2, float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j8, str2, str3, z7, z8, (i8 & 64) != 0 ? true : z9, (i8 & 128) != 0 ? false : z10, (i8 & Spliterator.NONNULL) != 0 ? false : z11, (i8 & 512) != 0 ? new Color.Attr(R.attr.dynamicNeutral01) : color, (i8 & Spliterator.IMMUTABLE) != 0 ? new Color.Attr(R.attr.backPrimary) : color2, (i8 & 2048) != 0 ? Dimens.b(1.0f) : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f33571j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f33568g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f33563b == model.f33563b && Intrinsics.a(this.f33564c, model.f33564c) && Intrinsics.a(this.f33565d, model.f33565d) && this.f33566e == model.f33566e && this.f33567f == model.f33567f && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f33572k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((m().hashCode() * 31) + a.a(this.f33563b)) * 31) + this.f33564c.hashCode()) * 31) + this.f33565d.hashCode()) * 31;
            boolean z7 = this.f33566e;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean z8 = this.f33567f;
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
            return ((((((i15 + (k8 ? 1 : k8)) * 31) + d().hashCode()) * 31) + f().hashCode()) * 31) + i().hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f33573l);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f33569h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f33570i;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f33562a;
        }

        public final String n() {
            return this.f33565d;
        }

        public final String o() {
            return this.f33564c;
        }

        public final long p() {
            return this.f33563b;
        }

        public final boolean q() {
            return this.f33566e;
        }

        public String toString() {
            String m8 = m();
            long j8 = this.f33563b;
            String str = this.f33564c;
            String str2 = this.f33565d;
            boolean z7 = this.f33566e;
            boolean z8 = this.f33567f;
            boolean e8 = e();
            boolean j9 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            return "Model(listId=" + m8 + ", vehicleId=" + j8 + ", title=" + str + ", description=" + str2 + ", isSelected=" + z7 + ", isSelectable=" + z8 + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j9 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
        }

        public Model(String listId, long j8, String title, String description, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Color dividerColor, Color dividerBackColor, float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(description, "description");
            Intrinsics.f(dividerColor, "dividerColor");
            Intrinsics.f(dividerBackColor, "dividerBackColor");
            this.f33562a = listId;
            this.f33563b = j8;
            this.f33564c = title;
            this.f33565d = description;
            this.f33566e = z7;
            this.f33567f = z8;
            this.f33568g = z9;
            this.f33569h = z10;
            this.f33570i = z11;
            this.f33571j = dividerColor;
            this.f33572k = dividerBackColor;
            this.f33573l = f8;
        }
    }
}

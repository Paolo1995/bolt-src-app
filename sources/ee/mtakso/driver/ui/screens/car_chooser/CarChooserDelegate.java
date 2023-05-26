package ee.mtakso.driver.ui.screens.car_chooser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.Car;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarChooserDelegate.kt */
/* loaded from: classes3.dex */
public final class CarChooserDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Car, Unit> f27665b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f27666c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27667d;

    /* compiled from: CarChooserDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Payload {

        /* renamed from: a  reason: collision with root package name */
        private final Car f27680a;

        /* renamed from: b  reason: collision with root package name */
        private final Boolean f27681b;

        /* renamed from: c  reason: collision with root package name */
        private final String f27682c;

        /* renamed from: d  reason: collision with root package name */
        private final Boolean f27683d;

        /* renamed from: e  reason: collision with root package name */
        private final Boolean f27684e;

        public Payload(Car car, Boolean bool, String str, Boolean bool2, Boolean bool3) {
            this.f27680a = car;
            this.f27681b = bool;
            this.f27682c = str;
            this.f27683d = bool2;
            this.f27684e = bool3;
        }

        public final Car a() {
            return this.f27680a;
        }

        public final String b() {
            return this.f27682c;
        }

        public final Boolean c() {
            return this.f27681b;
        }

        public final Boolean d() {
            return this.f27683d;
        }

        public final Boolean e() {
            return this.f27684e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Payload) {
                Payload payload = (Payload) obj;
                return Intrinsics.a(this.f27680a, payload.f27680a) && Intrinsics.a(this.f27681b, payload.f27681b) && Intrinsics.a(this.f27682c, payload.f27682c) && Intrinsics.a(this.f27683d, payload.f27683d) && Intrinsics.a(this.f27684e, payload.f27684e);
            }
            return false;
        }

        public int hashCode() {
            Car car = this.f27680a;
            int hashCode = (car == null ? 0 : car.hashCode()) * 31;
            Boolean bool = this.f27681b;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.f27682c;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool2 = this.f27683d;
            int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.f27684e;
            return hashCode4 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            Car car = this.f27680a;
            Boolean bool = this.f27681b;
            String str = this.f27682c;
            Boolean bool2 = this.f27683d;
            Boolean bool3 = this.f27684e;
            return "Payload(car=" + car + ", showInsuranceSection=" + bool + ", insuranceKey=" + str + ", isActive=" + bool2 + ", isEnabled=" + bool3 + ")";
        }
    }

    /* compiled from: CarChooserDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f27685u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f27686v;

        /* renamed from: w  reason: collision with root package name */
        private final View f27687w;

        /* renamed from: x  reason: collision with root package name */
        private final RadioButton f27688x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.carTitle);
            Intrinsics.e(textView, "itemView.carTitle");
            this.f27685u = textView;
            TextView textView2 = (TextView) itemView.findViewById(R.id.carInsurance);
            Intrinsics.e(textView2, "itemView.carInsurance");
            this.f27686v = textView2;
            LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R.id.carInsuranceSection);
            Intrinsics.e(linearLayout, "itemView.carInsuranceSection");
            this.f27687w = linearLayout;
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) itemView.findViewById(R.id.carChooserRadioButton);
            Intrinsics.e(appCompatRadioButton, "itemView.carChooserRadioButton");
            this.f27688x = appCompatRadioButton;
        }

        public final TextView O() {
            return this.f27686v;
        }

        public final View P() {
            return this.f27687w;
        }

        public final RadioButton Q() {
            return this.f27688x;
        }

        public final TextView R() {
            return this.f27685u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CarChooserDelegate(Function1<? super Car, Unit> onItemClickListener, Function1<? super String, Unit> onInsuranceKeyCopyListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        Intrinsics.f(onInsuranceKeyCopyListener, "onInsuranceKeyCopyListener");
        this.f27665b = onItemClickListener;
        this.f27666c = onInsuranceKeyCopyListener;
        this.f27667d = R.layout.car_chooser_item_delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(CarChooserDelegate this$0, Car car, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(car, "$car");
        this$0.f27665b.invoke(car);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CarChooserDelegate this$0, String insuranceKey, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(insuranceKey, "$insuranceKey");
        this$0.f27666c.invoke(insuranceKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(CarChooserDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f27665b.invoke(model.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(CarChooserDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f27666c.invoke(model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27667d;
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
        View view = inflater.inflate(R.layout.car_chooser_item_delegate, parent, false);
        Intrinsics.e(view, "view");
        return new ViewHolder(view);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarChooserDelegate.x(CarChooserDelegate.this, model, view);
            }
        });
        ViewExtKt.e(holder.P(), model.p(), 0, 2, null);
        if (model.o() != null) {
            holder.P().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CarChooserDelegate.y(CarChooserDelegate.this, model, view);
                }
            });
        }
        holder.O().setText(model.o());
        holder.R().setText(model.n().c());
        holder.Q().setEnabled(model.r());
        holder.Q().setChecked(model.q());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: z */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        ArrayList<Payload> arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof Payload) {
                arrayList.add(obj);
            }
        }
        for (Payload payload : arrayList) {
            final Car a8 = payload.a();
            if (a8 != null) {
                holder.R().setText(a8.c());
                holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CarChooserDelegate.A(CarChooserDelegate.this, a8, view);
                    }
                });
            }
            Boolean c8 = payload.c();
            if (c8 != null) {
                ViewExtKt.e(holder.P(), c8.booleanValue(), 0, 2, null);
            }
            final String b8 = payload.b();
            if (b8 != null) {
                holder.P().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CarChooserDelegate.B(CarChooserDelegate.this, b8, view);
                    }
                });
                holder.O().setText(b8);
            }
            Boolean d8 = payload.d();
            if (d8 != null) {
                holder.Q().setChecked(d8.booleanValue());
            }
            Boolean e8 = payload.e();
            if (e8 != null) {
                holder.Q().setEnabled(e8.booleanValue());
            }
        }
    }

    /* compiled from: CarChooserDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27668a;

        /* renamed from: b  reason: collision with root package name */
        private final Car f27669b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f27670c;

        /* renamed from: d  reason: collision with root package name */
        private final String f27671d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f27672e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27673f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f27674g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f27675h;

        /* renamed from: i  reason: collision with root package name */
        private final float f27676i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f27677j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f27678k;

        /* renamed from: l  reason: collision with root package name */
        private final boolean f27679l;

        public /* synthetic */ Model(String str, Car car, boolean z7, String str2, boolean z8, boolean z9, Color color, Color color2, float f8, boolean z10, boolean z11, boolean z12, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, car, z7, str2, (i8 & 16) != 0 ? false : z8, (i8 & 32) != 0 ? false : z9, (i8 & 64) != 0 ? new Color.Attr(R.attr.dynamicNeutral01) : color, (i8 & 128) != 0 ? null : color2, (i8 & Spliterator.NONNULL) != 0 ? Dimens.c(1.0f) : f8, (i8 & 512) != 0 ? false : z10, z11, (i8 & 2048) != 0 ? false : z12);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27674g;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27678k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27669b, model.f27669b) && this.f27670c == model.f27670c && Intrinsics.a(this.f27671d, model.f27671d) && this.f27672e == model.f27672e && this.f27673f == model.f27673f && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0 && j() == model.j() && e() == model.e() && k() == model.k();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27675h;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((m().hashCode() * 31) + this.f27669b.hashCode()) * 31;
            boolean z7 = this.f27670c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            String str = this.f27671d;
            int hashCode2 = (i9 + (str == null ? 0 : str.hashCode())) * 31;
            boolean z8 = this.f27672e;
            int i10 = z8;
            if (z8 != 0) {
                i10 = 1;
            }
            int i11 = (hashCode2 + i10) * 31;
            boolean z9 = this.f27673f;
            int i12 = z9;
            if (z9 != 0) {
                i12 = 1;
            }
            int hashCode3 = (((((((i11 + i12) * 31) + d().hashCode()) * 31) + (f() != null ? f().hashCode() : 0)) * 31) + i().hashCode()) * 31;
            boolean j8 = j();
            int i13 = j8;
            if (j8) {
                i13 = 1;
            }
            int i14 = (hashCode3 + i13) * 31;
            boolean e8 = e();
            int i15 = e8;
            if (e8) {
                i15 = 1;
            }
            int i16 = (i14 + i15) * 31;
            boolean k8 = k();
            return i16 + (k8 ? 1 : k8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f27676i);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27677j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27679l;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public Object l(ListModel oldModel) {
            Car car;
            boolean z7;
            String str;
            boolean z8;
            Boolean bool;
            Boolean bool2;
            Intrinsics.f(oldModel, "oldModel");
            if (!(oldModel instanceof Model)) {
                return null;
            }
            Car car2 = this.f27669b;
            Model model = (Model) oldModel;
            boolean z9 = true;
            if (!Intrinsics.a(car2, model.f27669b)) {
                car = car2;
            } else {
                car = null;
            }
            Boolean valueOf = Boolean.valueOf(this.f27670c);
            if (valueOf.booleanValue() != model.f27670c) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            String str2 = this.f27671d;
            if (!Intrinsics.a(str2, model.f27671d)) {
                str = str2;
            } else {
                str = null;
            }
            Boolean valueOf2 = Boolean.valueOf(this.f27672e);
            if (valueOf2.booleanValue() != model.f27672e) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                bool = valueOf2;
            } else {
                bool = null;
            }
            Boolean valueOf3 = Boolean.valueOf(this.f27673f);
            if (valueOf3.booleanValue() == model.f27673f) {
                z9 = false;
            }
            if (z9) {
                bool2 = valueOf3;
            } else {
                bool2 = null;
            }
            return new Payload(car, valueOf, str, bool, bool2);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27668a;
        }

        public final Car n() {
            return this.f27669b;
        }

        public final String o() {
            return this.f27671d;
        }

        public final boolean p() {
            return this.f27670c;
        }

        public final boolean q() {
            return this.f27672e;
        }

        public final boolean r() {
            return this.f27673f;
        }

        public String toString() {
            String m8 = m();
            Car car = this.f27669b;
            boolean z7 = this.f27670c;
            String str = this.f27671d;
            boolean z8 = this.f27672e;
            boolean z9 = this.f27673f;
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            boolean j8 = j();
            boolean e8 = e();
            boolean k8 = k();
            return "Model(listId=" + m8 + ", car=" + car + ", showInsuranceSection=" + z7 + ", insuranceKey=" + str + ", isActive=" + z8 + ", isEnabled=" + z9 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ", isDividerAtTheTop=" + j8 + ", isDividerEnabled=" + e8 + ", shouldIgnoreMargins=" + k8 + ")";
        }

        public Model(String listId, Car car, boolean z7, String str, boolean z8, boolean z9, Color dividerColor, Color color, float f8, boolean z10, boolean z11, boolean z12) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(car, "car");
            Intrinsics.f(dividerColor, "dividerColor");
            this.f27668a = listId;
            this.f27669b = car;
            this.f27670c = z7;
            this.f27671d = str;
            this.f27672e = z8;
            this.f27673f = z9;
            this.f27674g = dividerColor;
            this.f27675h = color;
            this.f27676i = f8;
            this.f27677j = z10;
            this.f27678k = z11;
            this.f27679l = z12;
        }
    }
}

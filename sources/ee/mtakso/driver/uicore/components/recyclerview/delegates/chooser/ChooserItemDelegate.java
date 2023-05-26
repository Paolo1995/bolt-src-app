package ee.mtakso.driver.uicore.components.recyclerview.delegates.chooser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.chooser.ChooserItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import j$.util.Spliterator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChooserItemDelegate.kt */
/* loaded from: classes5.dex */
public final class ChooserItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f34893b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34894c;

    /* compiled from: ChooserItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f34906u;

        /* renamed from: v  reason: collision with root package name */
        private final AppCompatRadioButton f34907v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            this.f34906u = (TextView) itemView.findViewById(R$id.D0);
            this.f34907v = (AppCompatRadioButton) itemView.findViewById(R$id.chooser);
        }

        public final AppCompatRadioButton O() {
            return this.f34907v;
        }

        public final TextView P() {
            return this.f34906u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChooserItemDelegate(Function1<? super Model, Unit> onItemClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f34893b = onItemClickListener;
        this.f34894c = R$layout.delegate_choosable_item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ChooserItemDelegate this$0, ViewHolder holder, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(holder, "$holder");
        this$0.f34893b.invoke(this$0.d(holder));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34894c;
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
        View view = inflater.inflate(R$layout.delegate_choosable_item, parent, false);
        Intrinsics.e(view, "view");
        return new ViewHolder(view);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.P().setText(model.n());
        holder.O().setChecked(model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            Payload payload = (Payload) it.next();
            String a8 = payload.a();
            if (a8 != null) {
                holder.P().setText(a8);
            }
            Boolean b8 = payload.b();
            if (b8 != null) {
                holder.O().setChecked(b8.booleanValue());
            }
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void p(final ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        super.p(holder);
        holder.f7332a.setClickable(true);
        holder.f7332a.setFocusable(true);
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: r5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooserItemDelegate.w(ChooserItemDelegate.this, holder, view);
            }
        });
    }

    /* compiled from: ChooserItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34895a;

        /* renamed from: b  reason: collision with root package name */
        private final String f34896b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f34897c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f34898d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f34899e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f34900f;

        /* renamed from: g  reason: collision with root package name */
        private final float f34901g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f34902h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f34903i;

        public /* synthetic */ Model(String str, String str2, boolean z7, boolean z8, Color color, Color color2, float f8, boolean z9, boolean z10, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z7, z8, (i8 & 16) != 0 ? new Color.Attr(R$attr.f34582m) : color, (i8 & 32) != 0 ? null : color2, (i8 & 64) != 0 ? Dimens.c(1.0f) : f8, (i8 & 128) != 0 ? false : z9, (i8 & Spliterator.NONNULL) != 0 ? false : z10);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f34899e;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f34898d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34896b, model.f34896b) && this.f34897c == model.f34897c && e() == model.e() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0 && j() == model.j() && k() == model.k();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f34900f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((m().hashCode() * 31) + this.f34896b.hashCode()) * 31;
            boolean z7 = this.f34897c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean e8 = e();
            int i10 = e8;
            if (e8) {
                i10 = 1;
            }
            int hashCode2 = (((((((i9 + i10) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() != null ? f().hashCode() : 0)) * 31) + i().hashCode()) * 31;
            boolean j8 = j();
            int i11 = j8;
            if (j8) {
                i11 = 1;
            }
            int i12 = (hashCode2 + i11) * 31;
            boolean k8 = k();
            return i12 + (k8 ? 1 : k8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f34901g);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f34902h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f34903i;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public Object l(ListModel oldModel) {
            boolean z7;
            Intrinsics.f(oldModel, "oldModel");
            if (!(oldModel instanceof Model)) {
                return null;
            }
            Boolean valueOf = Boolean.valueOf(this.f34897c);
            if (valueOf.booleanValue() != ((Model) oldModel).f34897c) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            return new Payload(null, valueOf, 1, null);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34895a;
        }

        public final String n() {
            return this.f34896b;
        }

        public final boolean o() {
            return this.f34897c;
        }

        public String toString() {
            String m8 = m();
            String str = this.f34896b;
            boolean z7 = this.f34897c;
            boolean e8 = e();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            boolean j8 = j();
            boolean k8 = k();
            return "Model(listId=" + m8 + ", title=" + str + ", isSelected=" + z7 + ", isDividerEnabled=" + e8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ")";
        }

        public Model(String listId, String title, boolean z7, boolean z8, Color color, Color color2, float f8, boolean z9, boolean z10) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            this.f34895a = listId;
            this.f34896b = title;
            this.f34897c = z7;
            this.f34898d = z8;
            this.f34899e = color;
            this.f34900f = color2;
            this.f34901g = f8;
            this.f34902h = z9;
            this.f34903i = z10;
        }
    }

    /* compiled from: ChooserItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Payload {

        /* renamed from: a  reason: collision with root package name */
        private final String f34904a;

        /* renamed from: b  reason: collision with root package name */
        private final Boolean f34905b;

        public Payload() {
            this(null, null, 3, null);
        }

        public Payload(String str, Boolean bool) {
            this.f34904a = str;
            this.f34905b = bool;
        }

        public final String a() {
            return this.f34904a;
        }

        public final Boolean b() {
            return this.f34905b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Payload) {
                Payload payload = (Payload) obj;
                return Intrinsics.a(this.f34904a, payload.f34904a) && Intrinsics.a(this.f34905b, payload.f34905b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f34904a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.f34905b;
            return hashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            String str = this.f34904a;
            Boolean bool = this.f34905b;
            return "Payload(title=" + str + ", isSelected=" + bool + ")";
        }

        public /* synthetic */ Payload(String str, Boolean bool, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : bool);
        }
    }
}

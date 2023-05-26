package ee.mtakso.driver.uicore.components.recyclerview.delegates.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.SwipeModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.action.TextWithTwoActionsDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextWithTwoActionsDelegate.kt */
/* loaded from: classes5.dex */
public final class TextWithTwoActionsDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f34838d = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final Function2<Model, String, Unit> f34839b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34840c;

    /* compiled from: TextWithTwoActionsDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TextWithTwoActionsDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel, SwipeModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34841a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f34842b;

        /* renamed from: c  reason: collision with root package name */
        private final int f34843c;

        /* renamed from: d  reason: collision with root package name */
        private final int f34844d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f34845e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f34846f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f34847g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f34848h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f34849i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f34850j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f34851k;

        /* renamed from: l  reason: collision with root package name */
        private final Float f34852l;

        public /* synthetic */ Model(String str, CharSequence charSequence, int i8, int i9, Object obj, boolean z7, boolean z8, boolean z9, boolean z10, Color color, Color color2, Float f8, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, i8, i9, (i10 & 16) != 0 ? null : obj, (i10 & 32) != 0 ? false : z7, (i10 & 64) != 0 ? true : z8, (i10 & 128) != 0 ? false : z9, (i10 & Spliterator.NONNULL) != 0 ? true : z10, (i10 & 512) != 0 ? null : color, (i10 & Spliterator.IMMUTABLE) != 0 ? null : color2, (i10 & 2048) != 0 ? null : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.SwipeModel
        public boolean a() {
            return this.f34846f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f34850j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f34847g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34842b, model.f34842b) && this.f34843c == model.f34843c && this.f34844d == model.f34844d && Intrinsics.a(this.f34845e, model.f34845e) && a() == model.a() && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f34851k;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((m().hashCode() * 31) + this.f34842b.hashCode()) * 31) + this.f34843c) * 31) + this.f34844d) * 31;
            Object obj = this.f34845e;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            boolean a8 = a();
            int i8 = a8;
            if (a8) {
                i8 = 1;
            }
            int i9 = (hashCode2 + i8) * 31;
            boolean e8 = e();
            int i10 = e8;
            if (e8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean j8 = j();
            int i12 = j8;
            if (j8) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            boolean k8 = k();
            return ((((((i13 + (k8 ? 1 : k8)) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + (i() != null ? i().hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f34852l;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f34848h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f34849i;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34841a;
        }

        public final int n() {
            return this.f34843c;
        }

        public final int o() {
            return this.f34844d;
        }

        public final CharSequence p() {
            return this.f34842b;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f34842b;
            int i8 = this.f34843c;
            int i9 = this.f34844d;
            Object obj = this.f34845e;
            boolean a8 = a();
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i10 = i();
            return "Model(listId=" + m8 + ", text=" + ((Object) charSequence) + ", actionIconFirst=" + i8 + ", actionIconSecond=" + i9 + ", payload=" + obj + ", canSwipe=" + a8 + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i10 + ")";
        }

        public Model(String listId, CharSequence text, int i8, int i9, Object obj, boolean z7, boolean z8, boolean z9, boolean z10, Color color, Color color2, Float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(text, "text");
            this.f34841a = listId;
            this.f34842b = text;
            this.f34843c = i8;
            this.f34844d = i9;
            this.f34845e = obj;
            this.f34846f = z7;
            this.f34847g = z8;
            this.f34848h = z9;
            this.f34849i = z10;
            this.f34850j = color;
            this.f34851k = color2;
            this.f34852l = f8;
        }
    }

    /* compiled from: TextWithTwoActionsDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f34853u;

        /* renamed from: v  reason: collision with root package name */
        private final RoundButton f34854v;

        /* renamed from: w  reason: collision with root package name */
        private final RoundButton f34855w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R$id.f34604s0);
            Intrinsics.e(textView, "itemView.text");
            this.f34853u = textView;
            RoundButton roundButton = (RoundButton) itemView.findViewById(R$id.imageActionFirst);
            Intrinsics.e(roundButton, "itemView.imageActionFirst");
            this.f34854v = roundButton;
            RoundButton roundButton2 = (RoundButton) itemView.findViewById(R$id.imageActionSecond);
            Intrinsics.e(roundButton2, "itemView.imageActionSecond");
            this.f34855w = roundButton2;
        }

        public final RoundButton O() {
            return this.f34854v;
        }

        public final RoundButton P() {
            return this.f34855w;
        }

        public final TextView Q() {
            return this.f34853u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextWithTwoActionsDelegate(Function2<? super Model, ? super String, Unit> onAction) {
        Intrinsics.f(onAction, "onAction");
        this.f34839b = onAction;
        this.f34840c = R$layout.delegate_text_two_actions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(TextWithTwoActionsDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f34839b.s(model, "TAG_ACTION_FIRST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(TextWithTwoActionsDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f34839b.s(model, "TAG_ACTION_SECOND");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34840c;
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
        View v7 = inflater.inflate(R$layout.delegate_text_two_actions, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.Q().setText(model.p());
        holder.O().b(model.n());
        holder.P().b(model.o());
        holder.O().setOnClickListener(new View.OnClickListener() { // from class: q5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextWithTwoActionsDelegate.v(TextWithTwoActionsDelegate.this, model, view);
            }
        });
        holder.P().setOnClickListener(new View.OnClickListener() { // from class: q5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextWithTwoActionsDelegate.w(TextWithTwoActionsDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}

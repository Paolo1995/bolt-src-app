package ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.R$style;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardBannerDelegate.kt */
/* loaded from: classes5.dex */
public class DashboardBannerDelegate extends DiffAdapterDelegate<ViewHolder, Model> implements DashboardDelegate {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f35204b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35205c;

    /* compiled from: DashboardBannerDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35217u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35218v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f35219w;

        /* renamed from: x  reason: collision with root package name */
        private final AppCompatImageView f35220x;

        /* renamed from: y  reason: collision with root package name */
        private final ConstraintLayout f35221y;

        /* renamed from: z  reason: collision with root package name */
        private final View f35222z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.F0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35217u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.f34603q0);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35218v = appCompatTextView2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.leftIcon);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35219w = appCompatImageView;
            this.f35220x = (AppCompatImageView) itemView.findViewById(R$id.linkChevron);
            this.f35221y = (ConstraintLayout) itemView.findViewById(R$id.viewRoot);
            this.f35222z = itemView.findViewById(R$id.backgroundView);
        }

        public final View O() {
            return this.f35222z;
        }

        public final ImageView P() {
            return this.f35219w;
        }

        public final AppCompatImageView Q() {
            return this.f35220x;
        }

        public final TextView R() {
            return this.f35218v;
        }

        public final TextView S() {
            return this.f35217u;
        }

        public final ConstraintLayout T() {
            return this.f35221y;
        }
    }

    public /* synthetic */ DashboardBannerDelegate(Function1 function1, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i9 & 2) != 0 ? R$layout.delegate_dashboard_banner : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DashboardBannerDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35204b.invoke(model);
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardDelegate
    public void a(View view) {
        ViewGroup viewGroup;
        ConstraintLayout constraintLayout;
        Intrinsics.f(view, "view");
        ViewGroup.LayoutParams layoutParams = null;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && (constraintLayout = (ConstraintLayout) viewGroup.findViewById(R$id.viewRoot)) != null) {
            layoutParams = constraintLayout.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        view.getLayoutParams().height = -2;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35205c;
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
        View v7 = inflater.inflate(e(), parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r2 == null) goto L26;
     */
    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate.ViewHolder r10, final ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate.Model r11) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate.g(ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate$ViewHolder, ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate$Model):void");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DashboardBannerDelegate(Function1<? super Model, Unit> onInfoClick, int i8) {
        Intrinsics.f(onInfoClick, "onInfoClick");
        this.f35204b = onInfoClick;
        this.f35205c = i8;
    }

    /* compiled from: DashboardBannerDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35206a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35207b;

        /* renamed from: c  reason: collision with root package name */
        private final int f35208c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35209d;

        /* renamed from: e  reason: collision with root package name */
        private final Text f35210e;

        /* renamed from: f  reason: collision with root package name */
        private final int f35211f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f35212g;

        /* renamed from: h  reason: collision with root package name */
        private final Image f35213h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f35214i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f35215j;

        /* renamed from: k  reason: collision with root package name */
        private final Object f35216k;

        public /* synthetic */ Model(String str, Text text, int i8, Color color, Text text2, int i9, Color color2, Image image, boolean z7, Color color3, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? null : text, (i10 & 4) != 0 ? R$style.TextAppearance_UIKit_BodyM_Semibold : i8, (i10 & 8) != 0 ? new Color.Attr(R$attr.contentPrimary) : color, (i10 & 16) != 0 ? null : text2, (i10 & 32) != 0 ? R$style.f34606b : i9, (i10 & 64) != 0 ? new Color.Attr(R$attr.contentPrimary) : color2, (i10 & 128) != 0 ? null : image, (i10 & Spliterator.NONNULL) != 0 ? false : z7, (i10 & 512) != 0 ? new Color.Attr(R$attr.backPrimary) : color3, (i10 & Spliterator.IMMUTABLE) == 0 ? obj : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35207b, model.f35207b) && this.f35208c == model.f35208c && Intrinsics.a(this.f35209d, model.f35209d) && Intrinsics.a(this.f35210e, model.f35210e) && this.f35211f == model.f35211f && Intrinsics.a(this.f35212g, model.f35212g) && Intrinsics.a(this.f35213h, model.f35213h) && this.f35214i == model.f35214i && Intrinsics.a(this.f35215j, model.f35215j) && Intrinsics.a(this.f35216k, model.f35216k);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f35207b;
            int hashCode2 = (((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f35208c) * 31) + this.f35209d.hashCode()) * 31;
            Text text2 = this.f35210e;
            int hashCode3 = (((((hashCode2 + (text2 == null ? 0 : text2.hashCode())) * 31) + this.f35211f) * 31) + this.f35212g.hashCode()) * 31;
            Image image = this.f35213h;
            int hashCode4 = (hashCode3 + (image == null ? 0 : image.hashCode())) * 31;
            boolean z7 = this.f35214i;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int hashCode5 = (((hashCode4 + i8) * 31) + this.f35215j.hashCode()) * 31;
            Object obj = this.f35216k;
            return hashCode5 + (obj != null ? obj.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35206a;
        }

        public final Color n() {
            return this.f35215j;
        }

        public final boolean o() {
            return this.f35214i;
        }

        public final Image p() {
            return this.f35213h;
        }

        public final Object q() {
            return this.f35216k;
        }

        public final Text r() {
            return this.f35210e;
        }

        public final int s() {
            return this.f35211f;
        }

        public final Color t() {
            return this.f35212g;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35207b;
            int i8 = this.f35208c;
            Color color = this.f35209d;
            Text text2 = this.f35210e;
            int i9 = this.f35211f;
            Color color2 = this.f35212g;
            Image image = this.f35213h;
            boolean z7 = this.f35214i;
            Color color3 = this.f35215j;
            Object obj = this.f35216k;
            return "Model(listId=" + m8 + ", titleText=" + text + ", titleTextAppearance=" + i8 + ", titleTextColor=" + color + ", subtitleText=" + text2 + ", subtitleTextAppearance=" + i9 + ", subtitleTextColor=" + color2 + ", leftIcon=" + image + ", chevronVisible=" + z7 + ", backgroundColor=" + color3 + ", payload=" + obj + ")";
        }

        public final Text u() {
            return this.f35207b;
        }

        public final int v() {
            return this.f35208c;
        }

        public final Color w() {
            return this.f35209d;
        }

        public Model(String listId, Text text, int i8, Color titleTextColor, Text text2, int i9, Color subtitleTextColor, Image image, boolean z7, Color backgroundColor, Object obj) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(titleTextColor, "titleTextColor");
            Intrinsics.f(subtitleTextColor, "subtitleTextColor");
            Intrinsics.f(backgroundColor, "backgroundColor");
            this.f35206a = listId;
            this.f35207b = text;
            this.f35208c = i8;
            this.f35209d = titleTextColor;
            this.f35210e = text2;
            this.f35211f = i9;
            this.f35212g = subtitleTextColor;
            this.f35213h = image;
            this.f35214i = z7;
            this.f35215j = backgroundColor;
            this.f35216k = obj;
        }
    }
}

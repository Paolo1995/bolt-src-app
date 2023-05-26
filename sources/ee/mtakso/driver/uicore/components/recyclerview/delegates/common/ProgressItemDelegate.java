package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
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
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.StyledText;
import ee.mtakso.driver.uikit.utils.StyledTextKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressItemDelegate.kt */
/* loaded from: classes5.dex */
public class ProgressItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f35033b;

    /* compiled from: ProgressItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35040u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35041v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f35042w;

        /* renamed from: x  reason: collision with root package name */
        private final View f35043x;

        /* renamed from: y  reason: collision with root package name */
        private final ConstraintLayout f35044y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.leftText);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35040u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.valueText);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35041v = appCompatTextView2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.progressIcon);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35042w = appCompatImageView;
            this.f35043x = itemView.findViewById(R$id.lineView);
            this.f35044y = (ConstraintLayout) itemView.findViewById(R$id.viewRoot);
        }

        public final TextView O() {
            return this.f35040u;
        }

        public final View P() {
            return this.f35043x;
        }

        public final ImageView Q() {
            return this.f35042w;
        }

        public final TextView R() {
            return this.f35041v;
        }

        public final ConstraintLayout S() {
            return this.f35044y;
        }
    }

    public ProgressItemDelegate() {
        this(0, 1, null);
    }

    public /* synthetic */ ProgressItemDelegate(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? R$layout.delegate_progress_item : i8);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35033b;
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

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.O().getContext();
        StyledTextKt.a(holder.O(), model.o());
        StyledTextKt.a(holder.R(), model.r());
        ImageView Q = holder.Q();
        boolean z8 = true;
        int i8 = 0;
        if (model.q() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(Q, z7, 0, 2, null);
        Image q8 = model.q();
        if (q8 != null) {
            ImageKt.b(q8, holder.Q(), null, 2, null);
        }
        View P = holder.P();
        Intrinsics.e(P, "holder.lineView");
        if (model.p() == null) {
            z8 = false;
        }
        ViewExtKt.e(P, z8, 0, 2, null);
        Color p8 = model.p();
        if (p8 != null) {
            Context context2 = holder.P().getContext();
            Intrinsics.e(context2, "holder.lineView.context");
            holder.P().setBackgroundColor(ColorKt.a(p8, context2));
        }
        ConstraintLayout S = holder.S();
        if (model.p() != null) {
            i8 = Dimens.d(72);
        }
        S.setMinHeight(i8);
        ConstraintLayout S2 = holder.S();
        Color n8 = model.n();
        Intrinsics.e(context, "context");
        S2.setBackgroundColor(ColorKt.a(n8, context));
        RippleProvider rippleProvider = RippleProvider.f35730a;
        ConstraintLayout S3 = holder.S();
        Intrinsics.e(S3, "holder.viewRoot");
        RippleProvider.b(rippleProvider, S3, ColorKt.a(model.n(), context), 0, 2, null);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ProgressItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35034a;

        /* renamed from: b  reason: collision with root package name */
        private final StyledText f35035b;

        /* renamed from: c  reason: collision with root package name */
        private final StyledText f35036c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35037d;

        /* renamed from: e  reason: collision with root package name */
        private final Image f35038e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f35039f;

        public /* synthetic */ Model(String str, StyledText styledText, StyledText styledText2, Color color, Image image, Color color2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : styledText, (i8 & 4) != 0 ? null : styledText2, (i8 & 8) != 0 ? null : color, (i8 & 16) == 0 ? image : null, (i8 & 32) != 0 ? new Color.Attr(R$attr.backPrimary) : color2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35035b, model.f35035b) && Intrinsics.a(this.f35036c, model.f35036c) && Intrinsics.a(this.f35037d, model.f35037d) && Intrinsics.a(this.f35038e, model.f35038e) && Intrinsics.a(this.f35039f, model.f35039f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            StyledText styledText = this.f35035b;
            int hashCode2 = (hashCode + (styledText == null ? 0 : styledText.hashCode())) * 31;
            StyledText styledText2 = this.f35036c;
            int hashCode3 = (hashCode2 + (styledText2 == null ? 0 : styledText2.hashCode())) * 31;
            Color color = this.f35037d;
            int hashCode4 = (hashCode3 + (color == null ? 0 : color.hashCode())) * 31;
            Image image = this.f35038e;
            return ((hashCode4 + (image != null ? image.hashCode() : 0)) * 31) + this.f35039f.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35034a;
        }

        public final Color n() {
            return this.f35039f;
        }

        public final StyledText o() {
            return this.f35035b;
        }

        public final Color p() {
            return this.f35037d;
        }

        public final Image q() {
            return this.f35038e;
        }

        public final StyledText r() {
            return this.f35036c;
        }

        public String toString() {
            String m8 = m();
            StyledText styledText = this.f35035b;
            StyledText styledText2 = this.f35036c;
            Color color = this.f35037d;
            Image image = this.f35038e;
            Color color2 = this.f35039f;
            return "Model(listId=" + m8 + ", keyText=" + styledText + ", valueText=" + styledText2 + ", lineColor=" + color + ", progressIcon=" + image + ", backgroundColor=" + color2 + ")";
        }

        public Model(String listId, StyledText styledText, StyledText styledText2, Color color, Image image, Color backgroundColor) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(backgroundColor, "backgroundColor");
            this.f35034a = listId;
            this.f35035b = styledText;
            this.f35036c = styledText2;
            this.f35037d = color;
            this.f35038e = image;
            this.f35039f = backgroundColor;
        }
    }

    public ProgressItemDelegate(int i8) {
        this.f35033b = i8;
    }
}

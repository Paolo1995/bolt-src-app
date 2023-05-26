package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Lottie;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoLinesItemDelegate.kt */
/* loaded from: classes5.dex */
public class TwoLinesItemDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f35088b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f35089c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35090d;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f35091e;

    /* compiled from: TwoLinesItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static abstract class Indicator {

        /* compiled from: TwoLinesItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Chip extends Indicator {

            /* renamed from: a  reason: collision with root package name */
            private final CharSequence f35094a;

            /* renamed from: b  reason: collision with root package name */
            private final Color f35095b;

            /* renamed from: c  reason: collision with root package name */
            private final Integer f35096c;

            /* renamed from: d  reason: collision with root package name */
            private final Color f35097d;

            /* renamed from: e  reason: collision with root package name */
            private final Color f35098e;

            public /* synthetic */ Chip(CharSequence charSequence, Color color, Integer num, Color color2, Color color3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
                this(charSequence, color, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : color2, color3);
            }

            public final Color a() {
                return this.f35098e;
            }

            public final Integer b() {
                return this.f35096c;
            }

            public final Color c() {
                return this.f35097d;
            }

            public final CharSequence d() {
                return this.f35094a;
            }

            public final Color e() {
                return this.f35095b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Chip) {
                    Chip chip = (Chip) obj;
                    return Intrinsics.a(this.f35094a, chip.f35094a) && Intrinsics.a(this.f35095b, chip.f35095b) && Intrinsics.a(this.f35096c, chip.f35096c) && Intrinsics.a(this.f35097d, chip.f35097d) && Intrinsics.a(this.f35098e, chip.f35098e);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((this.f35094a.hashCode() * 31) + this.f35095b.hashCode()) * 31;
                Integer num = this.f35096c;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                Color color = this.f35097d;
                return ((hashCode2 + (color != null ? color.hashCode() : 0)) * 31) + this.f35098e.hashCode();
            }

            public String toString() {
                CharSequence charSequence = this.f35094a;
                Color color = this.f35095b;
                Integer num = this.f35096c;
                Color color2 = this.f35097d;
                Color color3 = this.f35098e;
                return "Chip(text=" + ((Object) charSequence) + ", textColor=" + color + ", icon=" + num + ", iconTint=" + color2 + ", backgroundColor=" + color3 + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Chip(CharSequence text, Color textColor, Integer num, Color color, Color backgroundColor) {
                super(null);
                Intrinsics.f(text, "text");
                Intrinsics.f(textColor, "textColor");
                Intrinsics.f(backgroundColor, "backgroundColor");
                this.f35094a = text;
                this.f35095b = textColor;
                this.f35096c = num;
                this.f35097d = color;
                this.f35098e = backgroundColor;
            }
        }

        /* compiled from: TwoLinesItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Icon extends Indicator {

            /* renamed from: a  reason: collision with root package name */
            private final int f35099a;

            public Icon(int i8) {
                super(null);
                this.f35099a = i8;
            }

            public final int a() {
                return this.f35099a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Icon) && this.f35099a == ((Icon) obj).f35099a;
            }

            public int hashCode() {
                return this.f35099a;
            }

            public String toString() {
                int i8 = this.f35099a;
                return "Icon(icon=" + i8 + ")";
            }
        }

        /* compiled from: TwoLinesItemDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Label extends Indicator {

            /* renamed from: a  reason: collision with root package name */
            private final Text f35100a;

            /* renamed from: b  reason: collision with root package name */
            private final Integer f35101b;

            /* renamed from: c  reason: collision with root package name */
            private final Color f35102c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Label(Text text, Integer num, Color color) {
                super(null);
                Intrinsics.f(text, "text");
                this.f35100a = text;
                this.f35101b = num;
                this.f35102c = color;
            }

            public final Text a() {
                return this.f35100a;
            }

            public final Integer b() {
                return this.f35101b;
            }

            public final Color c() {
                return this.f35102c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Label) {
                    Label label = (Label) obj;
                    return Intrinsics.a(this.f35100a, label.f35100a) && Intrinsics.a(this.f35101b, label.f35101b) && Intrinsics.a(this.f35102c, label.f35102c);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f35100a.hashCode() * 31;
                Integer num = this.f35101b;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                Color color = this.f35102c;
                return hashCode2 + (color != null ? color.hashCode() : 0);
            }

            public String toString() {
                Text text = this.f35100a;
                Integer num = this.f35101b;
                Color color = this.f35102c;
                return "Label(text=" + text + ", textAppearance=" + num + ", textColor=" + color + ")";
            }
        }

        private Indicator() {
        }

        public /* synthetic */ Indicator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TwoLinesItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View A;
        private final ImageView B;
        private final IndeterminateProgressView C;

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35129u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35130v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f35131w;

        /* renamed from: x  reason: collision with root package name */
        private final LottieAnimationView f35132x;

        /* renamed from: y  reason: collision with root package name */
        private final ImageView f35133y;

        /* renamed from: z  reason: collision with root package name */
        private final ImageView f35134z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.R);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35129u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.valueText);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35130v = appCompatTextView2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.leftIcon);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35131w = appCompatImageView;
            this.f35132x = (LottieAnimationView) itemView.findViewById(R$id.leftLottie);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) itemView.findViewById(R$id.rightIcon);
            Intrinsics.d(appCompatImageView2, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35133y = appCompatImageView2;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) itemView.findViewById(R$id.rightActionIcon);
            this.f35134z = appCompatImageButton instanceof ImageView ? appCompatImageButton : null;
            ConstraintLayout constraintLayout = (ConstraintLayout) itemView.findViewById(R$id.viewRoot);
            Intrinsics.d(constraintLayout, "null cannot be cast to non-null type android.view.View");
            this.A = constraintLayout;
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) itemView.findViewById(R$id.infoIcon);
            Intrinsics.d(appCompatImageView3, "null cannot be cast to non-null type android.widget.ImageView");
            this.B = appCompatImageView3;
            this.C = (IndeterminateProgressView) itemView.findViewById(R$id.progressEnd);
        }

        public final ImageView O() {
            return this.B;
        }

        public final TextView P() {
            return this.f35129u;
        }

        public final ImageView Q() {
            return this.f35131w;
        }

        public final LottieAnimationView R() {
            return this.f35132x;
        }

        public final IndeterminateProgressView S() {
            return this.C;
        }

        public final View T() {
            return this.A;
        }

        public final ImageView U() {
            return this.f35134z;
        }

        public final ImageView V() {
            return this.f35133y;
        }

        public final TextView W() {
            return this.f35130v;
        }
    }

    public /* synthetic */ TwoLinesItemDelegate(Function1 function1, Function1 function12, int i8, Function1 function13, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i9 & 2) != 0 ? new Function1<Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.1
            public final void b(Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((Model) obj);
                return Unit.f50853a;
            }
        } : function12, (i9 & 4) != 0 ? R$layout.delegate_two_lines_item : i8, (i9 & 8) != 0 ? new Function1<Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.2
            public final void b(Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((Model) obj);
                return Unit.f50853a;
            }
        } : function13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(TwoLinesItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35091e.invoke(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(TwoLinesItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35089c.invoke(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(TwoLinesItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35088b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35090d;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        if ((model instanceof Model) && ((Model) model).p() == null) {
            return true;
        }
        return false;
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
        if (r2 == null) goto L81;
     */
    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.ViewHolder r14, final ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Model<T> r15) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.g(ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate$ViewHolder, ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate$Model):void");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: z */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TwoLinesItemDelegate(Function1<? super Model<T>, Unit> onItemClick, Function1<? super Model<T>, Unit> onInfoClick, int i8, Function1<? super Model<T>, Unit> onRightIconClick) {
        Intrinsics.f(onItemClick, "onItemClick");
        Intrinsics.f(onInfoClick, "onInfoClick");
        Intrinsics.f(onRightIconClick, "onRightIconClick");
        this.f35088b = onItemClick;
        this.f35089c = onInfoClick;
        this.f35090d = i8;
        this.f35091e = onRightIconClick;
    }

    /* compiled from: TwoLinesItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel implements DividerModel {
        private final boolean A;
        private final boolean B;
        private boolean C;

        /* renamed from: a  reason: collision with root package name */
        private final String f35103a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35104b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f35105c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35106d;

        /* renamed from: e  reason: collision with root package name */
        private final Integer f35107e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f35108f;

        /* renamed from: g  reason: collision with root package name */
        private final Integer f35109g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f35110h;

        /* renamed from: i  reason: collision with root package name */
        private final Color f35111i;

        /* renamed from: j  reason: collision with root package name */
        private final Image f35112j;

        /* renamed from: k  reason: collision with root package name */
        private final Lottie f35113k;

        /* renamed from: l  reason: collision with root package name */
        private final Color f35114l;

        /* renamed from: m  reason: collision with root package name */
        private final Image f35115m;

        /* renamed from: n  reason: collision with root package name */
        private final Color f35116n;

        /* renamed from: o  reason: collision with root package name */
        private final Image f35117o;

        /* renamed from: p  reason: collision with root package name */
        private final Image f35118p;

        /* renamed from: q  reason: collision with root package name */
        private final Color f35119q;

        /* renamed from: r  reason: collision with root package name */
        private final Indicator f35120r;

        /* renamed from: s  reason: collision with root package name */
        private final T f35121s;

        /* renamed from: t  reason: collision with root package name */
        private final boolean f35122t;

        /* renamed from: u  reason: collision with root package name */
        private final int f35123u;

        /* renamed from: v  reason: collision with root package name */
        private final int f35124v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f35125w;

        /* renamed from: x  reason: collision with root package name */
        private final Color f35126x;

        /* renamed from: y  reason: collision with root package name */
        private final Color f35127y;

        /* renamed from: z  reason: collision with root package name */
        private final Float f35128z;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Model(java.lang.String r31, ee.mtakso.driver.uikit.utils.Text r32, java.lang.Integer r33, ee.mtakso.driver.uikit.utils.Color r34, java.lang.Integer r35, ee.mtakso.driver.uikit.utils.Text r36, java.lang.Integer r37, ee.mtakso.driver.uikit.utils.Color r38, ee.mtakso.driver.uikit.utils.Color r39, ee.mtakso.driver.uikit.utils.Image r40, ee.mtakso.driver.uikit.utils.Lottie r41, ee.mtakso.driver.uikit.utils.Color r42, ee.mtakso.driver.uikit.utils.Image r43, ee.mtakso.driver.uikit.utils.Color r44, ee.mtakso.driver.uikit.utils.Image r45, ee.mtakso.driver.uikit.utils.Image r46, ee.mtakso.driver.uikit.utils.Color r47, ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Indicator r48, java.lang.Object r49, boolean r50, int r51, int r52, boolean r53, ee.mtakso.driver.uikit.utils.Color r54, ee.mtakso.driver.uikit.utils.Color r55, java.lang.Float r56, boolean r57, boolean r58, boolean r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
            /*
                Method dump skipped, instructions count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Model.<init>(java.lang.String, ee.mtakso.driver.uikit.utils.Text, java.lang.Integer, ee.mtakso.driver.uikit.utils.Color, java.lang.Integer, ee.mtakso.driver.uikit.utils.Text, java.lang.Integer, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Image, ee.mtakso.driver.uikit.utils.Lottie, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Image, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Image, ee.mtakso.driver.uikit.utils.Image, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate$Indicator, java.lang.Object, boolean, int, int, boolean, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Color, java.lang.Float, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final boolean A() {
            return this.C;
        }

        public final T B() {
            return this.f35121s;
        }

        public final Image C() {
            return this.f35117o;
        }

        public final Color D() {
            return this.f35116n;
        }

        public final Image E() {
            return this.f35115m;
        }

        public final Color F() {
            return this.f35114l;
        }

        public final Text G() {
            return this.f35108f;
        }

        public final Integer H() {
            return this.f35109g;
        }

        public final Color I() {
            return this.f35110h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35126x;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35125w;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35104b, model.f35104b) && Intrinsics.a(this.f35105c, model.f35105c) && Intrinsics.a(this.f35106d, model.f35106d) && Intrinsics.a(this.f35107e, model.f35107e) && Intrinsics.a(this.f35108f, model.f35108f) && Intrinsics.a(this.f35109g, model.f35109g) && Intrinsics.a(this.f35110h, model.f35110h) && Intrinsics.a(this.f35111i, model.f35111i) && Intrinsics.a(this.f35112j, model.f35112j) && Intrinsics.a(this.f35113k, model.f35113k) && Intrinsics.a(this.f35114l, model.f35114l) && Intrinsics.a(this.f35115m, model.f35115m) && Intrinsics.a(this.f35116n, model.f35116n) && Intrinsics.a(this.f35117o, model.f35117o) && Intrinsics.a(this.f35118p, model.f35118p) && Intrinsics.a(this.f35119q, model.f35119q) && Intrinsics.a(this.f35120r, model.f35120r) && Intrinsics.a(this.f35121s, model.f35121s) && this.f35122t == model.f35122t && this.f35123u == model.f35123u && this.f35124v == model.f35124v && e() == model.e() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i()) && j() == model.j() && k() == model.k() && this.C == model.C;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35127y;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f35104b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Integer num = this.f35105c;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f35106d;
            int hashCode4 = (hashCode3 + (color == null ? 0 : color.hashCode())) * 31;
            Integer num2 = this.f35107e;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Text text2 = this.f35108f;
            int hashCode6 = (hashCode5 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Integer num3 = this.f35109g;
            int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Color color2 = this.f35110h;
            int hashCode8 = (hashCode7 + (color2 == null ? 0 : color2.hashCode())) * 31;
            Color color3 = this.f35111i;
            int hashCode9 = (hashCode8 + (color3 == null ? 0 : color3.hashCode())) * 31;
            Image image = this.f35112j;
            int hashCode10 = (hashCode9 + (image == null ? 0 : image.hashCode())) * 31;
            Lottie lottie = this.f35113k;
            int hashCode11 = (hashCode10 + (lottie == null ? 0 : lottie.hashCode())) * 31;
            Color color4 = this.f35114l;
            int hashCode12 = (hashCode11 + (color4 == null ? 0 : color4.hashCode())) * 31;
            Image image2 = this.f35115m;
            int hashCode13 = (hashCode12 + (image2 == null ? 0 : image2.hashCode())) * 31;
            Color color5 = this.f35116n;
            int hashCode14 = (hashCode13 + (color5 == null ? 0 : color5.hashCode())) * 31;
            Image image3 = this.f35117o;
            int hashCode15 = (hashCode14 + (image3 == null ? 0 : image3.hashCode())) * 31;
            Image image4 = this.f35118p;
            int hashCode16 = (((hashCode15 + (image4 == null ? 0 : image4.hashCode())) * 31) + this.f35119q.hashCode()) * 31;
            Indicator indicator = this.f35120r;
            int hashCode17 = (hashCode16 + (indicator == null ? 0 : indicator.hashCode())) * 31;
            T t7 = this.f35121s;
            int hashCode18 = (hashCode17 + (t7 == null ? 0 : t7.hashCode())) * 31;
            boolean z7 = this.f35122t;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (((((hashCode18 + i8) * 31) + this.f35123u) * 31) + this.f35124v) * 31;
            boolean e8 = e();
            int i10 = e8;
            if (e8 != 0) {
                i10 = 1;
            }
            int hashCode19 = (((((((i9 + i10) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + (i() != null ? i().hashCode() : 0)) * 31;
            boolean j8 = j();
            int i11 = j8;
            if (j8 != 0) {
                i11 = 1;
            }
            int i12 = (hashCode19 + i11) * 31;
            boolean k8 = k();
            int i13 = k8;
            if (k8 != 0) {
                i13 = 1;
            }
            int i14 = (i12 + i13) * 31;
            boolean z8 = this.C;
            return i14 + (z8 ? 1 : z8 ? 1 : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35128z;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.A;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.B;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35103a;
        }

        public final Color n() {
            return this.f35119q;
        }

        public final boolean o() {
            return this.f35122t;
        }

        public final Indicator p() {
            return this.f35120r;
        }

        public final Image q() {
            return this.f35118p;
        }

        public final int r() {
            return this.f35124v;
        }

        public final int s() {
            return this.f35123u;
        }

        public final Text t() {
            return this.f35104b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35104b;
            Integer num = this.f35105c;
            Color color = this.f35106d;
            Integer num2 = this.f35107e;
            Text text2 = this.f35108f;
            Integer num3 = this.f35109g;
            Color color2 = this.f35110h;
            Color color3 = this.f35111i;
            Image image = this.f35112j;
            Lottie lottie = this.f35113k;
            Color color4 = this.f35114l;
            Image image2 = this.f35115m;
            Color color5 = this.f35116n;
            Image image3 = this.f35117o;
            Image image4 = this.f35118p;
            Color color6 = this.f35119q;
            Indicator indicator = this.f35120r;
            T t7 = this.f35121s;
            boolean z7 = this.f35122t;
            int i8 = this.f35123u;
            int i9 = this.f35124v;
            boolean e8 = e();
            Color d8 = d();
            Color f8 = f();
            Float i10 = i();
            boolean j8 = j();
            boolean k8 = k();
            boolean z8 = this.C;
            return "Model(listId=" + m8 + ", keyText=" + text + ", keyTextAppearance=" + num + ", keyTextColor=" + color + ", keyTextMarginTop=" + num2 + ", valueText=" + text2 + ", valueTextAppearance=" + num3 + ", valueTextColor=" + color2 + ", leftIconTintColor=" + color3 + ", leftIcon=" + image + ", leftIconLottie=" + lottie + ", rightIconTintColor=" + color4 + ", rightIcon=" + image2 + ", rightActionIconTintColor=" + color5 + ", rightActionIcon=" + image3 + ", infoIcon=" + image4 + ", backgroundColor=" + color6 + ", indicator=" + indicator + ", payload=" + t7 + ", clickable=" + z7 + ", infoIconWidth=" + i8 + ", infoIconHeight=" + i9 + ", isDividerEnabled=" + e8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i10 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", loadingEnabled=" + z8 + ")";
        }

        public final Integer u() {
            return this.f35105c;
        }

        public final Color v() {
            return this.f35106d;
        }

        public final Integer w() {
            return this.f35107e;
        }

        public final Image x() {
            return this.f35112j;
        }

        public final Lottie y() {
            return this.f35113k;
        }

        public final Color z() {
            return this.f35111i;
        }

        public Model(String listId, Text text, Integer num, Color color, Integer num2, Text text2, Integer num3, Color color2, Color color3, Image image, Lottie lottie, Color color4, Image image2, Color color5, Image image3, Image image4, Color backgroundColor, Indicator indicator, T t7, boolean z7, int i8, int i9, boolean z8, Color color6, Color color7, Float f8, boolean z9, boolean z10, boolean z11) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(backgroundColor, "backgroundColor");
            this.f35103a = listId;
            this.f35104b = text;
            this.f35105c = num;
            this.f35106d = color;
            this.f35107e = num2;
            this.f35108f = text2;
            this.f35109g = num3;
            this.f35110h = color2;
            this.f35111i = color3;
            this.f35112j = image;
            this.f35113k = lottie;
            this.f35114l = color4;
            this.f35115m = image2;
            this.f35116n = color5;
            this.f35117o = image3;
            this.f35118p = image4;
            this.f35119q = backgroundColor;
            this.f35120r = indicator;
            this.f35121s = t7;
            this.f35122t = z7;
            this.f35123u = i8;
            this.f35124v = i9;
            this.f35125w = z8;
            this.f35126x = color6;
            this.f35127y = color7;
            this.f35128z = f8;
            this.A = z9;
            this.B = z10;
            this.C = z11;
        }
    }
}

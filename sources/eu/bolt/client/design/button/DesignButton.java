package eu.bolt.client.design.button;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import eu.bolt.verification.R$animator;
import eu.bolt.verification.R$attr;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.a6;
import eu.bolt.verification.sdk.internal.f1;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.g5;
import eu.bolt.verification.sdk.internal.ol;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public class DesignButton extends AppCompatButton {

    /* renamed from: j  reason: collision with root package name */
    public static final c f39960j = new c(null);

    /* renamed from: i  reason: collision with root package name */
    private b f39961i;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<String, Unit> {
        a() {
            super(1);
        }

        public final void b(String it) {
            Intrinsics.f(it, "it");
            DesignButton.this.setText(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            b(str);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        Primary,
        Secondary,
        Danger,
        Text,
        PrimaryInverted,
        SecondarySmall,
        Premium
    }

    /* loaded from: classes5.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39971a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.Primary.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.Secondary.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.Danger.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.Text.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.PrimaryInverted.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.SecondarySmall.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[b.Premium.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f39971a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<TypedArray, Unit> {
        e() {
            super(1);
        }

        public final void b(TypedArray it) {
            Drawable[] f8;
            Intrinsics.f(it, "it");
            ColorStateList colorStateList = it.getColorStateList(R$styleable.f41834o0);
            Drawable drawable = it.getDrawable(R$styleable.f41828n0);
            Drawable drawable2 = it.getDrawable(R$styleable.f41822m0);
            Drawable drawable3 = it.getDrawable(R$styleable.f41815l0);
            Drawable drawable4 = it.getDrawable(R$styleable.f41840p0);
            DesignButton.this.q().b(DesignButton.this);
            ol.c(DesignButton.this, drawable != null ? a6.b(drawable, colorStateList) : null, drawable2 != null ? a6.b(drawable2, colorStateList) : null, drawable4 != null ? a6.b(drawable4, colorStateList) : null, drawable3 != null ? a6.b(drawable3, colorStateList) : null, false, 16, null);
            boolean z7 = it.getBoolean(R$styleable.f41808k0, true);
            for (Drawable drawable5 : ol.f(DesignButton.this)) {
                if (drawable5 != null) {
                    drawable5.setAutoMirrored(z7);
                }
            }
            int i8 = R$styleable.f41801j0;
            b bVar = DesignButton.this.f39961i;
            DesignButton.this.setStyle(b.values()[it.getInteger(i8, bVar != null ? bVar.ordinal() : 0)]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        if (attributeSet != null) {
            uq.w(this, attributeSet, "text", new a());
        }
        e(attributeSet);
        if (isInEditMode()) {
            b();
        }
        f(this, 0.0f, 1, null);
        i();
    }

    public /* synthetic */ DesignButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f41689a : i8);
    }

    private final void b() {
        b bVar = this.f39961i;
        switch (bVar == null ? -1 : d.f39971a[bVar.ordinal()]) {
            case 1:
                l();
                return;
            case 2:
                n();
                return;
            case 3:
                j();
                return;
            case 4:
                p();
                return;
            case 5:
                m();
                return;
            case 6:
                o();
                return;
            case 7:
                k();
                return;
            default:
                return;
        }
    }

    private final void d(int i8, ColorStateList colorStateList, boolean z7, boolean z8, Integer num) {
        if (z7) {
            g5.a aVar = g5.f43099d;
            Context context = getContext();
            Intrinsics.e(context, "context");
            g5.a.c(aVar, context, 0, u4.f45317s.j(), 2, null).b(this);
            if (isInEditMode()) {
                setTypeface(null, 1);
            }
        }
        int i9 = 0;
        setAllCaps(false);
        if (!z8) {
            Context context2 = getContext();
            Intrinsics.e(context2, "context");
            Context context3 = getContext();
            Intrinsics.e(context3, "context");
            i9 = f2.a(context2, f2.l(context3, R$dimen.button_height));
        }
        setCompoundDrawablePadding(i9);
        setBackgroundResource(i8);
        setTextColor(colorStateList);
        if (Build.VERSION.SDK_INT >= 23) {
            setStateListAnimator(num != null ? AnimatorInflater.loadStateListAnimator(getContext(), num.intValue()) : null);
        }
        setGravity(17);
    }

    private final void e(AttributeSet attributeSet) {
        int[] DesignButton = R$styleable.f41794i0;
        Intrinsics.e(DesignButton, "DesignButton");
        uq.x(this, attributeSet, DesignButton, new e());
    }

    public static /* synthetic */ void f(DesignButton designButton, float f8, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMinHeight");
        }
        if ((i8 & 1) != 0) {
            f8 = 56.0f;
        }
        designButton.c(f8);
    }

    static /* synthetic */ void g(DesignButton designButton, int i8, ColorStateList colorStateList, boolean z7, boolean z8, Integer num, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyStyle");
        }
        boolean z9 = (i9 & 4) != 0 ? true : z7;
        boolean z10 = (i9 & 8) != 0 ? false : z8;
        if ((i9 & 16) != 0) {
            num = null;
        }
        designButton.d(i8, colorStateList, z9, z10, num);
    }

    private final void i() {
        setMaxLines(1);
    }

    private final void o() {
        int i8 = R$drawable.f41707h;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.f41696v), false, false, null, 24, null);
        g5.a aVar = g5.f43099d;
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        g5.a.c(aVar, context2, 0, u4.f45315q.j(), 2, null).b(this);
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a8 = f2.a(context3, 12.0f);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a9 = f2.a(context4, 6.0f);
        setPadding(a8, a9, a8, a9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g5 q() {
        g5.a aVar = g5.f43099d;
        Context context = getContext();
        int a8 = aVar.a();
        Intrinsics.e(context, "context");
        return aVar.b(context, a8, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(float f8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setMinHeight(f2.a(context, f8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        int i8 = R$drawable.f41705a;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.f41695q), false, false, Integer.valueOf(R$animator.button_base_state_list), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        int i8 = R$drawable.background_premium_button;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.f41695q), false, false, Integer.valueOf(R$animator.button_base_state_list), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        int i8 = R$drawable.f41706d;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.f41695q), false, false, Integer.valueOf(R$animator.button_base_state_list), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        int i8 = R$drawable.background_primary_inversed_button;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.primary_inversed_button_text_color), false, false, Integer.valueOf(R$animator.button_base_state_list), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        int i8 = R$drawable.f41707h;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.f41696v), false, false, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        int i8 = R$drawable.f41708j;
        Context context = getContext();
        Intrinsics.e(context, "context");
        g(this, i8, f2.j(context, R$color.f41698z), false, true, null, 20, null);
    }

    public final void setButtonUiModel(f1 model) {
        Intrinsics.f(model, "model");
        throw null;
    }

    public final void setStyle(b value) {
        Intrinsics.f(value, "value");
        if (this.f39961i != value) {
            this.f39961i = value;
            b();
        }
    }
}

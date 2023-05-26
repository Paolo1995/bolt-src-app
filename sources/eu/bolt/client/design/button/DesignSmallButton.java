package eu.bolt.client.design.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import com.google.android.material.textview.MaterialTextView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.e5;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.g5;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

/* loaded from: classes5.dex */
public final class DesignSmallButton extends MaterialTextView {

    /* renamed from: f  reason: collision with root package name */
    public static final b f39973f = new b(null);

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Ref$BooleanRef f39975g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref$BooleanRef ref$BooleanRef) {
            super(1);
            this.f39975g = ref$BooleanRef;
        }

        public final void b(TypedArray array) {
            Intrinsics.f(array, "array");
            Drawable drawable = array.getDrawable(R$styleable.P1);
            if (drawable != null) {
                DesignSmallButton.this.setIconInternal(drawable);
                this.f39975g.f51012f = true;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignSmallButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignSmallButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        int[] DesignSmallButton = R$styleable.O1;
        Intrinsics.e(DesignSmallButton, "DesignSmallButton");
        uq.x(this, attributeSet, DesignSmallButton, new a(ref$BooleanRef));
        setAllCaps(true);
        setClickable(true);
        setFocusable(true);
        setCompoundDrawablePadding(f2.a(context, 4.0f));
        m(ref$BooleanRef.f51012f);
        setTextColor(f2.b(context, R$color.F));
        setBackground(k());
        setLetterSpacing(0.08f);
        g5.a.c(g5.f43099d, context, 0, u4.f45315q.j(), 2, null).b(this);
    }

    public /* synthetic */ DesignSmallButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final Drawable k() {
        Context context = getContext();
        Intrinsics.e(context, "context");
        ColorStateList valueOf = ColorStateList.valueOf(f2.b(context, R$color.green_600));
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        return new RippleDrawable(valueOf, new e5(f2.b(context2, R$color.green_500)), new e5(-16777216));
    }

    private final void m(boolean z7) {
        if (!z7) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            int a8 = f2.a(context, 4.0f);
            Context context2 = getContext();
            Intrinsics.e(context2, "context");
            int a9 = f2.a(context2, 10.0f);
            setPadding(a9, a8, a9, a8);
            return;
        }
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = f2.a(context3, 8.0f);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a11 = f2.a(context4, 8.0f);
        Context context5 = getContext();
        Intrinsics.e(context5, "context");
        uq.u(this, a11, a10, f2.a(context5, 16.0f), a10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setIconInternal(android.graphics.drawable.Drawable r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L29
            android.content.Context r1 = r9.getContext()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            int r3 = eu.bolt.verification.R$color.F
            int r1 = eu.bolt.verification.sdk.internal.f2.b(r1, r3)
            android.graphics.drawable.Drawable r10 = eu.bolt.verification.sdk.internal.a6.a(r10, r1)
            if (r10 == 0) goto L29
            android.content.Context r1 = r9.getContext()
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            r2 = 1101004800(0x41a00000, float:20.0)
            int r1 = eu.bolt.verification.sdk.internal.f2.a(r1, r2)
            r10.setBounds(r0, r0, r1, r1)
            goto L2a
        L29:
            r10 = 0
        L2a:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r1 = r9
            r2 = r10
            eu.bolt.verification.sdk.internal.ol.c(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 == 0) goto L39
            r0 = 1
        L39:
            r9.m(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.button.DesignSmallButton.setIconInternal(android.graphics.drawable.Drawable):void");
    }

    public final void setIcon(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setIconInternal(f2.o(context, i8));
    }

    public final void setIcon(Drawable res) {
        Intrinsics.f(res, "res");
        setIconInternal(res);
    }
}

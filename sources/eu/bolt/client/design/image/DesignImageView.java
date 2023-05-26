package eu.bolt.client.design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.logger.Logger;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.mc;
import eu.bolt.verification.sdk.internal.u9;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.v9;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public class DesignImageView extends LottieAnimationView {
    private static final b C = new b(null);
    private final Logger A;
    private final Lazy B;

    /* renamed from: v  reason: collision with root package name */
    private boolean f40027v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f40028w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f40029x;

    /* renamed from: y  reason: collision with root package name */
    private String f40030y;

    /* renamed from: z  reason: collision with root package name */
    private v9 f40031z;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {
        a() {
            super(1);
        }

        public final void b(TypedArray ta) {
            Intrinsics.f(ta, "ta");
            DesignImageView designImageView = DesignImageView.this;
            designImageView.setIsRound(ta.getBoolean(R$styleable.X0, designImageView.f40027v));
            DesignImageView designImageView2 = DesignImageView.this;
            designImageView2.f40028w = ta.getBoolean(R$styleable.W0, designImageView2.f40028w);
            DesignImageView.this.F();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function0<a> {

        /* loaded from: classes5.dex */
        public static final class a extends ViewOutlineProvider {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DesignImageView f40034a;

            a(DesignImageView designImageView) {
                this.f40034a = designImageView;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.f(view, "view");
                Intrinsics.f(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f40034a.getRoundImageRadius());
            }
        }

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final a invoke() {
            return new a(DesignImageView.this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignImageView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.A = ac.a.f42020b.e();
        this.B = LazyKt.b(new c());
        int[] DesignImageView = R$styleable.V0;
        Intrinsics.e(DesignImageView, "DesignImageView");
        uq.x(this, attributeSet, DesignImageView, new a());
        j(new LottieOnCompositionLoadedListener() { // from class: r6.a
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void a(LottieComposition lottieComposition) {
                DesignImageView.J(DesignImageView.this, lottieComposition);
            }
        });
        setFailureListener(new LottieListener() { // from class: r6.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                DesignImageView.L(DesignImageView.this, (Throwable) obj);
            }
        });
    }

    public /* synthetic */ DesignImageView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        Drawable drawable;
        if (!this.f40028w || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setAutoMirrored(true);
    }

    public static /* synthetic */ void I(DesignImageView designImageView, Drawable drawable, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDrawable");
        }
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        designImageView.G(drawable, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DesignImageView this$0, LottieComposition lottieComposition) {
        Intrinsics.f(this$0, "this$0");
        v9 v9Var = this$0.f40031z;
        if (v9Var != null) {
            Drawable drawable = this$0.getDrawable();
            Intrinsics.e(drawable, "drawable");
            v9Var.b(drawable);
        }
    }

    public static /* synthetic */ void K(DesignImageView designImageView, aa aaVar, boolean z7, v9 v9Var, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setImage");
        }
        if ((i8 & 2) != 0) {
            z7 = true;
        }
        if ((i8 & 4) != 0) {
            v9Var = null;
        }
        designImageView.N(aaVar, z7, v9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(DesignImageView this$0, Throwable it) {
        Intrinsics.f(this$0, "this$0");
        if (!mc.f44173a.a(it)) {
            Logger logger = this$0.A;
            Intrinsics.e(it, "it");
            logger.f(it, "Lottie resource loading failure");
        }
        v9 v9Var = this$0.f40031z;
        if (v9Var != null) {
            Intrinsics.e(it, "it");
            v9Var.a(it);
        }
    }

    private final boolean O(aa aaVar) {
        Boolean a8;
        return (aaVar == null || (a8 = aaVar.a()) == null) ? this.f40027v : a8.booleanValue();
    }

    private final void Q() {
        c.a aVar;
        if (this.f40027v) {
            setClipToOutline(true);
            if (Intrinsics.a(getOutlineProvider(), getRoundOutlineProvider())) {
                invalidateOutline();
                return;
            }
            aVar = getRoundOutlineProvider();
        } else {
            setClipToOutline(false);
            aVar = null;
        }
        setOutlineProvider(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getRoundImageRadius() {
        return Math.min(getWidth(), getHeight()) / 2.0f;
    }

    private final c.a getRoundOutlineProvider() {
        return (c.a) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setIsRound(boolean z7) {
        if (z7 && !this.f40029x) {
            super.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.f40027v != z7) {
            this.f40027v = z7;
            Q();
        }
    }

    public final void G(Drawable drawable, boolean z7) {
        u9.c(this);
        setIsRound(z7);
        setImageDrawable(drawable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
        if (r0.b() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00db, code lost:
        if (r0.b() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dd, code lost:
        x();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
        l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N(eu.bolt.verification.sdk.internal.aa r17, boolean r18, eu.bolt.verification.sdk.internal.v9 r19) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.image.DesignImageView.N(eu.bolt.verification.sdk.internal.aa, boolean, eu.bolt.verification.sdk.internal.v9):void");
    }

    public final String getAnimationUrl() {
        return this.f40030y;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            Logger logger = this.A;
            String T = uq.T(this);
            String r7 = uq.r(getParent());
            logger.a(th, "DesignImageView onDraw() failure. View with id: " + T + " and parent id: " + r7);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        invalidateOutline();
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimationFromUrl(String str) {
        super.setAnimationFromUrl(str);
        this.f40030y = str;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        try {
            super.setImageBitmap(bitmap);
            F();
        } catch (Exception e8) {
            this.A.a(e8, "Cannot set image bitmap");
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        F();
    }

    @Override // com.airbnb.lottie.LottieAnimationView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i8) {
        try {
            super.setImageResource(i8);
            F();
        } catch (Exception e8) {
            this.A.a(e8, "Cannot set image resource");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        try {
            super.setImageURI(uri);
            F();
        } catch (Exception e8) {
            this.A.a(e8, "Cannot set image URI");
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.f(scaleType, "scaleType");
        super.setScaleType(scaleType);
        this.f40029x = true;
    }
}

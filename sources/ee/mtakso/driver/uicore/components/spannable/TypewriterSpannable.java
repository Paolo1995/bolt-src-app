package ee.mtakso.driver.uicore.components.spannable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.Property;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypewriterSpannable.kt */
/* loaded from: classes5.dex */
public final class TypewriterSpannable extends ReplacementSpan {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f35387g = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private static final Property<TypewriterSpannable, Float> f35388h;

    /* renamed from: f  reason: collision with root package name */
    private float f35389f;

    /* compiled from: TypewriterSpannable.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Property<TypewriterSpannable, Float> a() {
            return TypewriterSpannable.f35388h;
        }
    }

    static {
        final Class cls = Float.TYPE;
        f35388h = new Property<TypewriterSpannable, Float>(cls) { // from class: ee.mtakso.driver.uicore.components.spannable.TypewriterSpannable$Companion$TYPEWRITER_ANIMATION_PROPERTY$1
            @Override // android.util.Property
            /* renamed from: a */
            public Float get(TypewriterSpannable typewriterSpannable) {
                float f8;
                if (typewriterSpannable != null) {
                    f8 = typewriterSpannable.f35389f;
                } else {
                    f8 = 0.0f;
                }
                return Float.valueOf(f8);
            }

            @Override // android.util.Property
            /* renamed from: b */
            public void set(TypewriterSpannable typewriterSpannable, Float f8) {
                if (f8 != null && typewriterSpannable != null) {
                    typewriterSpannable.f35389f = f8.floatValue();
                }
            }
        };
    }

    public TypewriterSpannable() {
        this(0.0f, 1, null);
    }

    public /* synthetic */ TypewriterSpannable(float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 1.0f : f8);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i8, int i9, float f8, int i10, int i11, int i12, Paint paint) {
        float f9;
        int size;
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(paint, "paint");
        if (charSequence == null) {
            return;
        }
        int ceil = (int) Math.ceil(f9 / (i9 - i8));
        int size2 = i8 + (((int) (this.f35389f * getSize(paint, charSequence, i8, i9, paint.getFontMetricsInt()))) / ceil);
        float f10 = i11;
        canvas.drawText(charSequence, i8, size2, f8, f10, paint);
        int size3 = getSize(paint, charSequence, i8, size2, paint.getFontMetricsInt());
        float f11 = (size % ceil) / ceil;
        if (f11 > 0.0f) {
            int alpha = paint.getAlpha();
            paint.setAlpha((int) (255 * f11));
            canvas.drawText(charSequence, size2, size2 + 1, f8 + size3, f10, paint);
            paint.setAlpha(alpha);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i8, int i9, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.f(paint, "paint");
        return (int) paint.measureText(charSequence, i8, i9);
    }

    public TypewriterSpannable(float f8) {
        this.f35389f = f8;
    }
}

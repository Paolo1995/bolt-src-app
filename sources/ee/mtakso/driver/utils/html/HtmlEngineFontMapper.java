package ee.mtakso.driver.utils.html;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.R$style;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.font.HtmlFontStyle;
import eu.bolt.android.engine.html.font.NativeFontStyle;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlEngineFontMapper.kt */
/* loaded from: classes5.dex */
public final class HtmlEngineFontMapper implements HtmlFontMapper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36438a;

    /* compiled from: HtmlEngineFontMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36442a;

        static {
            int[] iArr = new int[HtmlFontStyle.values().length];
            try {
                iArr[HtmlFontStyle.BODY_XS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HtmlFontStyle.BODY_S.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HtmlFontStyle.BODY_M.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HtmlFontStyle.BODY_L.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HtmlFontStyle.BODY_SEMIBOLD_XS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HtmlFontStyle.BODY_SEMIBOLD_S.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HtmlFontStyle.BODY_SEMIBOLD_M.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HtmlFontStyle.BODY_SEMIBOLD_L.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_XS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_S.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_M.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_L.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[HtmlFontStyle.STORY_HEADLINE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_S_REGULAR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_XS_REGULAR.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[HtmlFontStyle.CAPS_S.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[HtmlFontStyle.CAPS_M.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[HtmlFontStyle.CAPS_L.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            f36442a = iArr;
        }
    }

    @Inject
    public HtmlEngineFontMapper(Context context) {
        Intrinsics.f(context, "context");
        this.f36438a = context;
    }

    private final NativeFontStyle b(int i8) {
        float f8;
        float f9;
        float f10;
        Float c8 = c(i8, 16842901);
        if (c8 != null) {
            f8 = c8.floatValue();
        } else {
            f8 = 14.0f;
        }
        Float c9 = c(i8, R.attr.lineHeight);
        if (c9 != null) {
            f9 = c9.floatValue();
        } else {
            f9 = 18.0f;
        }
        if (f9 > f8) {
            f10 = f9 - f8;
        } else {
            f10 = 4.0f;
        }
        return new Style(f8, f10, null, 4, null);
    }

    private final Float c(int i8, int i9) {
        TypedArray obtainStyledAttributes = this.f36438a.obtainStyledAttributes(i8, new int[]{i9});
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…arance, intArrayOf(attr))");
        TypedValue typedValue = new TypedValue();
        if (!obtainStyledAttributes.getValue(0, typedValue)) {
            return null;
        }
        int i10 = typedValue.type;
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5) {
            int i11 = typedValue.type;
            throw new IllegalArgumentException("Unsupported typed value type " + i11);
        }
        return Float.valueOf(TypedValue.complexToFloat(typedValue.data));
    }

    @Override // eu.bolt.android.engine.html.font.HtmlFontMapper
    public NativeFontStyle a(HtmlFontStyle from) {
        Intrinsics.f(from, "from");
        int i8 = WhenMappings.f36442a[from.ordinal()];
        Float valueOf = Float.valueOf(0.08f);
        switch (i8) {
            case 1:
                return b(2132017745);
            case 2:
                return b(2132017742);
            case 3:
                return b(2132017739);
            case 4:
                return b(2132017735);
            case 5:
                return b(R$style.TextAppearance_UIKit_BodyXS_Semibold);
            case 6:
                return b(2132017743);
            case 7:
                return b(ee.mtakso.driver.uicore.R$style.TextAppearance_UIKit_BodyM_Semibold);
            case 8:
                return b(2132017737);
            case 9:
                return b(2132017765);
            case 10:
                return b(2132017760);
            case 11:
                return b(2132017758);
            case 12:
                return b(2132017755);
            case 13:
                return new Style(32.0f, 8.0f, null, 4, null);
            case 14:
                return b(2132017759);
            case 15:
                return b(2132017764);
            case 16:
                return new Style(11.0f, 4.0f, valueOf);
            case 17:
                return new Style(14.0f, 4.0f, valueOf);
            case 18:
                return new Style(16.0f, 4.0f, valueOf);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HtmlEngineFontMapper.kt */
    /* loaded from: classes5.dex */
    public static final class Style implements NativeFontStyle {

        /* renamed from: a  reason: collision with root package name */
        private final float f36439a;

        /* renamed from: b  reason: collision with root package name */
        private final float f36440b;

        /* renamed from: c  reason: collision with root package name */
        private final Float f36441c;

        public Style(float f8, float f9, Float f10) {
            this.f36439a = f8;
            this.f36440b = f9;
            this.f36441c = f10;
        }

        @Override // eu.bolt.android.engine.html.font.NativeFontStyle
        public float a() {
            return this.f36439a;
        }

        @Override // eu.bolt.android.engine.html.font.NativeFontStyle
        public Float b() {
            return this.f36441c;
        }

        @Override // eu.bolt.android.engine.html.font.NativeFontStyle
        public float c() {
            return this.f36440b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Style) {
                Style style = (Style) obj;
                return Float.compare(a(), style.a()) == 0 && Float.compare(c(), style.c()) == 0 && Intrinsics.a(b(), style.b());
            }
            return false;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(a()) * 31) + Float.floatToIntBits(c())) * 31) + (b() == null ? 0 : b().hashCode());
        }

        public String toString() {
            float a8 = a();
            float c8 = c();
            Float b8 = b();
            return "Style(textSizeSp=" + a8 + ", lineSpacingExtraSp=" + c8 + ", letterSpacing=" + b8 + ")";
        }

        public /* synthetic */ Style(float f8, float f9, Float f10, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(f8, f9, (i8 & 4) != 0 ? null : f10);
        }
    }
}

package eu.bolt.verification.sdk.internal;

import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.font.HtmlFontStyle;
import eu.bolt.android.engine.html.font.NativeFontStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x4 implements HtmlFontMapper {

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45606a;

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
                iArr[HtmlFontStyle.HEADING_XS_REGULAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[HtmlFontStyle.STORY_HEADLINE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[HtmlFontStyle.CAPS_S.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[HtmlFontStyle.CAPS_M.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[HtmlFontStyle.CAPS_L.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[HtmlFontStyle.HEADING_S_REGULAR.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            f45606a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements NativeFontStyle {

        /* renamed from: a  reason: collision with root package name */
        private final float f45607a;

        /* renamed from: b  reason: collision with root package name */
        private final float f45608b;

        /* renamed from: c  reason: collision with root package name */
        private final Float f45609c;

        b(u4 u4Var) {
            this.f45607a = u4Var.h();
            this.f45608b = u4Var.f();
            this.f45609c = u4Var.e();
        }

        @Override // eu.bolt.android.engine.html.font.NativeFontStyle
        public float a() {
            return this.f45607a;
        }

        @Override // eu.bolt.android.engine.html.font.NativeFontStyle
        public Float b() {
            return this.f45609c;
        }

        @Override // eu.bolt.android.engine.html.font.NativeFontStyle
        public float c() {
            return this.f45608b;
        }
    }

    private final b b(u4 u4Var) {
        return new b(u4Var);
    }

    @Override // eu.bolt.android.engine.html.font.HtmlFontMapper
    public NativeFontStyle a(HtmlFontStyle from) {
        u4 u4Var;
        Intrinsics.f(from, "from");
        switch (a.f45606a[from.ordinal()]) {
            case 1:
                u4Var = u4.f45310l;
                break;
            case 2:
                u4Var = u4.f45311m;
                break;
            case 3:
                u4Var = u4.f45312n;
                break;
            case 4:
                u4Var = u4.f45313o;
                break;
            case 5:
                u4Var = u4.f45314p;
                break;
            case 6:
                u4Var = u4.f45315q;
                break;
            case 7:
                u4Var = u4.f45316r;
                break;
            case 8:
                u4Var = u4.f45317s;
                break;
            case 9:
                u4Var = u4.f45318t;
                break;
            case 10:
                u4Var = u4.f45319u;
                break;
            case 11:
                u4Var = u4.f45320v;
                break;
            case 12:
                u4Var = u4.f45321w;
                break;
            case 13:
                u4Var = u4.f45322x;
                break;
            case 14:
                u4Var = u4.B;
                break;
            case 15:
                u4Var = u4.f45323y;
                break;
            case 16:
                u4Var = u4.f45324z;
                break;
            case 17:
                u4Var = u4.A;
                break;
            case 18:
                u4Var = u4.C;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return b(u4Var);
    }
}

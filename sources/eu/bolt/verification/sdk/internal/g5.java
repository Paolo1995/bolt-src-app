package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import eu.bolt.verification.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g5 {

    /* renamed from: d */
    public static final a f43099d = new a(null);

    /* renamed from: e */
    private static final t4 f43100e;

    /* renamed from: f */
    private static final int f43101f;

    /* renamed from: a */
    private final Context f43102a;

    /* renamed from: b */
    private final t4 f43103b;

    /* renamed from: c */
    private final u4 f43104c;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ g5 c(a aVar, Context context, int i8, int i9, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i8 = aVar.a();
            }
            if ((i10 & 4) != 0) {
                i9 = -1;
            }
            return aVar.b(context, i8, i9);
        }

        public final int a() {
            return g5.f43101f;
        }

        public final g5 b(Context context, int i8, int i9) {
            u4 u4Var;
            t4 t4Var;
            u4 u4Var2;
            Intrinsics.f(context, "context");
            t4[] values = t4.values();
            int length = values.length;
            int i10 = 0;
            while (true) {
                u4Var = null;
                if (i10 >= length) {
                    t4Var = null;
                    break;
                }
                t4Var = values[i10];
                if (t4Var.e() == i8) {
                    break;
                }
                i10++;
            }
            if (t4Var == null) {
                t3.c("unknown value passed for font " + i8, null, 2, null);
                t4Var = g5.f43100e;
            }
            if (i9 != -1) {
                u4[] values2 = u4.values();
                int length2 = values2.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        u4Var2 = null;
                        break;
                    }
                    u4Var2 = values2[i11];
                    if (u4Var2.j() == i9) {
                        break;
                    }
                    i11++;
                }
                if (u4Var2 == null) {
                    t3.c("unknown value passed for font style " + i9, null, 2, null);
                }
                u4Var = u4Var2;
            }
            return new g5(context, t4Var, u4Var);
        }
    }

    static {
        t4 t4Var = t4.REGULAR;
        f43100e = t4Var;
        f43101f = t4Var.e();
    }

    public g5(Context context, t4 font, u4 u4Var) {
        Intrinsics.f(context, "context");
        Intrinsics.f(font, "font");
        this.f43102a = context;
        this.f43103b = font;
        this.f43104c = u4Var;
    }

    public /* synthetic */ g5(Context context, t4 t4Var, u4 u4Var, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, t4Var, (i8 & 4) != 0 ? null : u4Var);
    }

    public final void b(TextView widget) {
        t4 t4Var;
        Intrinsics.f(widget, "widget");
        u4 u4Var = this.f43104c;
        if (u4Var == null || (t4Var = u4Var.c()) == null) {
            t4Var = this.f43103b;
        }
        int c8 = t4Var.c();
        if (!widget.isInEditMode()) {
            widget.setTypeface(ResourcesCompat.h(this.f43102a, c8));
        }
        widget.setFontFeatureSettings("tnum");
        if (u4Var != null) {
            widget.setTextSize(u4Var.h());
            Float e8 = u4Var.e();
            if (e8 != null) {
                widget.setLetterSpacing(e8.floatValue());
            }
            Boolean k8 = u4Var.k();
            if (k8 != null) {
                widget.setAllCaps(k8.booleanValue());
            }
            widget.setLineSpacing(f2.m(this.f43102a, u4Var.f()), 1.0f);
        }
        widget.setTag(R$id.designFontStyle, u4Var);
    }
}

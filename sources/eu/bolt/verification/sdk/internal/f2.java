package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import eu.bolt.logger.StaticLogger;
import eu.bolt.verification.R$string;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f42887f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f42888g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, int i8) {
            super(0);
            this.f42887f = context;
            this.f42888g = i8;
        }

        public final void b() {
            f2.d(this.f42887f, this.f42888g, 0, 2, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    public static final int a(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return (int) TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static final int b(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        return ContextCompat.getColor(context, i8);
    }

    public static final Toast c(Context context, int i8, int i9) {
        Intrinsics.f(context, "<this>");
        Toast toast = Toast.makeText(context, i8, i9);
        toast.show();
        Intrinsics.e(toast, "toast");
        return toast;
    }

    public static /* synthetic */ Toast d(Context context, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        return c(context, i8, i9);
    }

    public static final void e(Context context, AttributeSet attributeSet, int[] styleable, Function1<? super TypedArray, Unit> action) {
        Intrinsics.f(context, "<this>");
        Intrinsics.f(styleable, "styleable");
        Intrinsics.f(action, "action");
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, styleable, 0, 0);
            try {
                Intrinsics.e(obtainStyledAttributes, "this");
                action.invoke(obtainStyledAttributes);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public static final void f(Context context, String url, int i8, int i9, Integer num) {
        Intrinsics.f(context, "<this>");
        Intrinsics.f(url, "url");
        CustomTabsIntent a8 = new CustomTabsIntent.Builder().e(i9).a();
        Intrinsics.e(a8, "Builder()\n        .setTo…arColor)\n        .build()");
        if (num != null) {
            a8.f2353a.addFlags(num.intValue());
        }
        try {
            StaticLogger staticLogger = StaticLogger.f41686a;
            staticLogger.b("Open Chrome Tab with url = " + url);
            Uri parse = Uri.parse(url);
            Intrinsics.e(parse, "parse(url)");
            oa.a(a8, context, parse, new a(context, i8));
        } catch (Exception e8) {
            t3.c("Failed to open chrome tab\n" + e8, null, 2, null);
        }
    }

    public static /* synthetic */ void g(Context context, String str, int i8, int i9, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = R$string.error_cant_open_link;
        }
        if ((i10 & 4) != 0) {
            i9 = -1;
        }
        if ((i10 & 8) != 0) {
            num = null;
        }
        f(context, str, i8, i9, num);
    }

    public static final boolean h(Context context) {
        Intrinsics.f(context, "<this>");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return false;
            }
        }
        return true;
    }

    public static final float i(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static final ColorStateList j(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        return ContextCompat.getColorStateList(context, i8);
    }

    public static final float k(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return f8 / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final float l(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        return context.getResources().getDimension(i8);
    }

    public static final float m(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return TypedValue.applyDimension(2, f8, context.getResources().getDisplayMetrics());
    }

    public static final int n(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        return context.getResources().getDimensionPixelSize(i8);
    }

    public static final Drawable o(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        Drawable b8 = AppCompatResources.b(context, i8);
        if (b8 != null) {
            return b8;
        }
        throw new IllegalArgumentException(("Resource " + i8 + " doesn't found").toString());
    }
}

package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class ActionBarPolicy {

    /* renamed from: a  reason: collision with root package name */
    private Context f1430a;

    private ActionBarPolicy(Context context) {
        this.f1430a = context;
    }

    public static ActionBarPolicy b(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean a() {
        if (this.f1430a.getApplicationInfo().targetSdkVersion < 14) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f1430a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f1430a.getResources().getConfiguration();
        int i8 = configuration.screenWidthDp;
        int i9 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i8 <= 600) {
            if (i8 <= 960 || i9 <= 720) {
                if (i8 <= 720 || i9 <= 960) {
                    if (i8 < 500) {
                        if (i8 <= 640 || i9 <= 480) {
                            if (i8 <= 480 || i9 <= 640) {
                                if (i8 >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return 5;
    }

    public int e() {
        return this.f1430a.getResources().getDimensionPixelSize(R$dimen.f851b);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f1430a.obtainStyledAttributes(null, R$styleable.f956a, R$attr.f817c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.f1001j, 0);
        Resources resources = this.f1430a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.f850a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f1430a.getResources().getBoolean(R$bool.f841a);
    }

    public boolean h() {
        return true;
    }
}

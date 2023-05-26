package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class KeyTrigger extends Key {
    HashMap<String, Method> A;

    /* renamed from: g  reason: collision with root package name */
    private int f4786g = -1;

    /* renamed from: h  reason: collision with root package name */
    private String f4787h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f4788i;

    /* renamed from: j  reason: collision with root package name */
    private String f4789j;

    /* renamed from: k  reason: collision with root package name */
    private String f4790k;

    /* renamed from: l  reason: collision with root package name */
    private int f4791l;

    /* renamed from: m  reason: collision with root package name */
    private int f4792m;

    /* renamed from: n  reason: collision with root package name */
    private View f4793n;

    /* renamed from: o  reason: collision with root package name */
    float f4794o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4795p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4796q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4797r;

    /* renamed from: s  reason: collision with root package name */
    private float f4798s;

    /* renamed from: t  reason: collision with root package name */
    private float f4799t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4800u;

    /* renamed from: v  reason: collision with root package name */
    int f4801v;

    /* renamed from: w  reason: collision with root package name */
    int f4802w;

    /* renamed from: x  reason: collision with root package name */
    int f4803x;

    /* renamed from: y  reason: collision with root package name */
    RectF f4804y;

    /* renamed from: z  reason: collision with root package name */
    RectF f4805z;

    public KeyTrigger() {
        int i8 = Key.f4780f;
        this.f4788i = i8;
        this.f4789j = null;
        this.f4790k = null;
        this.f4791l = i8;
        this.f4792m = i8;
        this.f4793n = null;
        this.f4794o = 0.1f;
        this.f4795p = true;
        this.f4796q = true;
        this.f4797r = true;
        this.f4798s = Float.NaN;
        this.f4800u = false;
        this.f4801v = i8;
        this.f4802w = i8;
        this.f4803x = i8;
        this.f4804y = new RectF();
        this.f4805z = new RectF();
        this.A = new HashMap<>();
        this.f4784d = 5;
        this.f4785e = new HashMap<>();
    }

    private void d(String str, View view) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            e(str, view);
            return;
        }
        if (this.A.containsKey(str)) {
            method = this.A.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, new Class[0]);
                this.A.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.A.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.b(view));
                return;
            }
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.f4787h + "\"on class " + view.getClass().getSimpleName() + " " + Debug.b(view));
        }
    }

    private void e(String str, View view) {
        boolean z7;
        if (str.length() == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f4785e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z7 || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = this.f4785e.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.a(view);
                }
            }
        }
    }

    private void f(RectF rectF, View view, boolean z7) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z7) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: a */
    public Key clone() {
        return new KeyTrigger().b(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key b(Key key) {
        super.b(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.f4786g = keyTrigger.f4786g;
        this.f4787h = keyTrigger.f4787h;
        this.f4788i = keyTrigger.f4788i;
        this.f4789j = keyTrigger.f4789j;
        this.f4790k = keyTrigger.f4790k;
        this.f4791l = keyTrigger.f4791l;
        this.f4792m = keyTrigger.f4792m;
        this.f4793n = keyTrigger.f4793n;
        this.f4794o = keyTrigger.f4794o;
        this.f4795p = keyTrigger.f4795p;
        this.f4796q = keyTrigger.f4796q;
        this.f4797r = keyTrigger.f4797r;
        this.f4798s = keyTrigger.f4798s;
        this.f4799t = keyTrigger.f4799t;
        this.f4800u = keyTrigger.f4800u;
        this.f4804y = keyTrigger.f4804y;
        this.f4805z = keyTrigger.f4805z;
        this.A = keyTrigger.A;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(float r10, android.view.View r11) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.c(float, android.view.View):void");
    }
}

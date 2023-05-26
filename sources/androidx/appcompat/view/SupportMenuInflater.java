package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f1452e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f1453f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f1454a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f1455b;

    /* renamed from: c  reason: collision with root package name */
    Context f1456c;

    /* renamed from: d  reason: collision with root package name */
    private Object f1457d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f1458c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f1459a;

        /* renamed from: b  reason: collision with root package name */
        private Method f1460b;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f1459a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1460b = cls.getMethod(str, f1458c);
            } catch (Exception e8) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e8);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1460b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1460b.invoke(this.f1459a, menuItem)).booleanValue();
                }
                this.f1460b.invoke(this.f1459a, menuItem);
                return true;
            } catch (Exception e8) {
                throw new RuntimeException(e8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuState {
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f1461a;

        /* renamed from: b  reason: collision with root package name */
        private int f1462b;

        /* renamed from: c  reason: collision with root package name */
        private int f1463c;

        /* renamed from: d  reason: collision with root package name */
        private int f1464d;

        /* renamed from: e  reason: collision with root package name */
        private int f1465e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1466f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1467g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1468h;

        /* renamed from: i  reason: collision with root package name */
        private int f1469i;

        /* renamed from: j  reason: collision with root package name */
        private int f1470j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f1471k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f1472l;

        /* renamed from: m  reason: collision with root package name */
        private int f1473m;

        /* renamed from: n  reason: collision with root package name */
        private char f1474n;

        /* renamed from: o  reason: collision with root package name */
        private int f1475o;

        /* renamed from: p  reason: collision with root package name */
        private char f1476p;

        /* renamed from: q  reason: collision with root package name */
        private int f1477q;

        /* renamed from: r  reason: collision with root package name */
        private int f1478r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f1479s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f1480t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f1481u;

        /* renamed from: v  reason: collision with root package name */
        private int f1482v;

        /* renamed from: w  reason: collision with root package name */
        private int f1483w;

        /* renamed from: x  reason: collision with root package name */
        private String f1484x;

        /* renamed from: y  reason: collision with root package name */
        private String f1485y;

        /* renamed from: z  reason: collision with root package name */
        private String f1486z;

        public MenuState(Menu menu) {
            this.f1461a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f1456c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e8) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e8);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z7;
            MenuItem enabled = menuItem.setChecked(this.f1479s).setVisible(this.f1480t).setEnabled(this.f1481u);
            boolean z8 = false;
            if (this.f1478r >= 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            enabled.setCheckable(z7).setTitleCondensed(this.f1472l).setIcon(this.f1473m);
            int i8 = this.f1482v;
            if (i8 >= 0) {
                menuItem.setShowAsAction(i8);
            }
            if (this.f1486z != null) {
                if (!SupportMenuInflater.this.f1456c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.b(), this.f1486z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f1478r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).t(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).h(true);
                }
            }
            String str = this.f1484x;
            if (str != null) {
                menuItem.setActionView((View) e(str, SupportMenuInflater.f1452e, SupportMenuInflater.this.f1454a));
                z8 = true;
            }
            int i9 = this.f1483w;
            if (i9 > 0) {
                if (!z8) {
                    menuItem.setActionView(i9);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.a(menuItem, actionProvider);
            }
            MenuItemCompat.c(menuItem, this.B);
            MenuItemCompat.g(menuItem, this.C);
            MenuItemCompat.b(menuItem, this.f1474n, this.f1475o);
            MenuItemCompat.f(menuItem, this.f1476p, this.f1477q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f1468h = true;
            i(this.f1461a.add(this.f1462b, this.f1469i, this.f1470j, this.f1471k));
        }

        public SubMenu b() {
            this.f1468h = true;
            SubMenu addSubMenu = this.f1461a.addSubMenu(this.f1462b, this.f1469i, this.f1470j, this.f1471k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f1468h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f1456c.obtainStyledAttributes(attributeSet, R$styleable.f1028o1);
            this.f1462b = obtainStyledAttributes.getResourceId(R$styleable.f1038q1, 0);
            this.f1463c = obtainStyledAttributes.getInt(R$styleable.f1048s1, 0);
            this.f1464d = obtainStyledAttributes.getInt(R$styleable.f1053t1, 0);
            this.f1465e = obtainStyledAttributes.getInt(R$styleable.f1058u1, 0);
            this.f1466f = obtainStyledAttributes.getBoolean(R$styleable.f1043r1, true);
            this.f1467g = obtainStyledAttributes.getBoolean(R$styleable.f1033p1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z7;
            TintTypedArray u7 = TintTypedArray.u(SupportMenuInflater.this.f1456c, attributeSet, R$styleable.f1063v1);
            this.f1469i = u7.n(R$styleable.f1078y1, 0);
            this.f1470j = (u7.k(R$styleable.B1, this.f1463c) & (-65536)) | (u7.k(R$styleable.C1, this.f1464d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f1471k = u7.p(R$styleable.D1);
            this.f1472l = u7.p(R$styleable.E1);
            this.f1473m = u7.n(R$styleable.f1068w1, 0);
            this.f1474n = c(u7.o(R$styleable.F1));
            this.f1475o = u7.k(R$styleable.M1, 4096);
            this.f1476p = c(u7.o(R$styleable.G1));
            this.f1477q = u7.k(R$styleable.Q1, 4096);
            int i8 = R$styleable.H1;
            if (u7.s(i8)) {
                this.f1478r = u7.a(i8, false) ? 1 : 0;
            } else {
                this.f1478r = this.f1465e;
            }
            this.f1479s = u7.a(R$styleable.f1083z1, false);
            this.f1480t = u7.a(R$styleable.A1, this.f1466f);
            this.f1481u = u7.a(R$styleable.f1073x1, this.f1467g);
            this.f1482v = u7.k(R$styleable.R1, -1);
            this.f1486z = u7.o(R$styleable.I1);
            this.f1483w = u7.n(R$styleable.J1, 0);
            this.f1484x = u7.o(R$styleable.L1);
            String o8 = u7.o(R$styleable.K1);
            this.f1485y = o8;
            if (o8 != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && this.f1483w == 0 && this.f1484x == null) {
                this.A = (ActionProvider) e(o8, SupportMenuInflater.f1453f, SupportMenuInflater.this.f1455b);
            } else {
                if (z7) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u7.p(R$styleable.N1);
            this.C = u7.p(R$styleable.S1);
            int i9 = R$styleable.P1;
            if (u7.s(i9)) {
                this.E = DrawableUtils.e(u7.k(i9, -1), this.E);
            } else {
                this.E = null;
            }
            int i10 = R$styleable.O1;
            if (u7.s(i10)) {
                this.D = u7.c(i10);
            } else {
                this.D = null;
            }
            u7.w();
            this.f1468h = false;
        }

        public void h() {
            this.f1462b = 0;
            this.f1463c = 0;
            this.f1464d = 0;
            this.f1465e = 0;
            this.f1466f = true;
            this.f1467g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f1452e = clsArr;
        f1453f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f1456c = context;
        Object[] objArr = {context};
        this.f1454a = objArr;
        this.f1455b = objArr;
    }

    private Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r6 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r15 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r15 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r15 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r15.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r15.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r0.d() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (r15.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (r15.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r15.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
        if (r15.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
        if (r15.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            androidx.appcompat.view.SupportMenuInflater$MenuState r0 = new androidx.appcompat.view.SupportMenuInflater$MenuState
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = 0
            r7 = 0
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r4
            r7 = 0
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            androidx.core.view.ActionProvider r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.a()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = 1
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = 1
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.f1457d == null) {
            this.f1457d = a(this.f1456c);
        }
        return this.f1457d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i8, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i8, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f1456c.getResources().getLayout(i8);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e8) {
                    throw new InflateException("Error inflating menu XML", e8);
                }
            } catch (XmlPullParserException e9) {
                throw new InflateException("Error inflating menu XML", e9);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}

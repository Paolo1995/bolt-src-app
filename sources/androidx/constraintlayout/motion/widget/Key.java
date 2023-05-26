package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class Key {

    /* renamed from: f  reason: collision with root package name */
    public static int f4780f = -1;

    /* renamed from: a  reason: collision with root package name */
    int f4781a;

    /* renamed from: b  reason: collision with root package name */
    int f4782b;

    /* renamed from: c  reason: collision with root package name */
    String f4783c;

    /* renamed from: d  reason: collision with root package name */
    protected int f4784d;

    /* renamed from: e  reason: collision with root package name */
    HashMap<String, ConstraintAttribute> f4785e;

    public Key() {
        int i8 = f4780f;
        this.f4781a = i8;
        this.f4782b = i8;
        this.f4783c = null;
    }

    @Override // 
    /* renamed from: a */
    public abstract Key clone();

    public Key b(Key key) {
        this.f4781a = key.f4781a;
        this.f4782b = key.f4782b;
        this.f4783c = key.f4783c;
        this.f4784d = key.f4784d;
        this.f4785e = key.f4785e;
        return this;
    }
}

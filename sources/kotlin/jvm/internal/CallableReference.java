package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes5.dex */
public abstract class CallableReference implements KCallable, Serializable {

    /* renamed from: l  reason: collision with root package name */
    public static final Object f50987l = NoReceiver.f50994f;

    /* renamed from: f  reason: collision with root package name */
    private transient KCallable f50988f;

    /* renamed from: g  reason: collision with root package name */
    protected final Object f50989g;

    /* renamed from: h  reason: collision with root package name */
    private final Class f50990h;

    /* renamed from: i  reason: collision with root package name */
    private final String f50991i;

    /* renamed from: j  reason: collision with root package name */
    private final String f50992j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f50993k;

    /* loaded from: classes5.dex */
    private static class NoReceiver implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private static final NoReceiver f50994f = new NoReceiver();

        private NoReceiver() {
        }
    }

    public CallableReference() {
        this(f50987l);
    }

    public KCallable c() {
        KCallable kCallable = this.f50988f;
        if (kCallable == null) {
            KCallable d8 = d();
            this.f50988f = d8;
            return d8;
        }
        return kCallable;
    }

    protected abstract KCallable d();

    public Object e() {
        return this.f50989g;
    }

    public KDeclarationContainer g() {
        Class cls = this.f50990h;
        if (cls == null) {
            return null;
        }
        if (this.f50993k) {
            return Reflection.c(cls);
        }
        return Reflection.b(cls);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.f50991i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KCallable h() {
        KCallable c8 = c();
        if (c8 != this) {
            return c8;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public String i() {
        return this.f50992j;
    }

    protected CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z7) {
        this.f50989g = obj;
        this.f50990h = cls;
        this.f50991i = str;
        this.f50992j = str2;
        this.f50993k = z7;
    }
}

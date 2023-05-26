package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    protected final ArrayMap<String, Method> f8016a;

    /* renamed from: b  reason: collision with root package name */
    protected final ArrayMap<String, Method> f8017b;

    /* renamed from: c  reason: collision with root package name */
    protected final ArrayMap<String, Class> f8018c;

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f8016a = arrayMap;
        this.f8017b = arrayMap2;
        this.f8018c = arrayMap3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(VersionedParcelable versionedParcelable) {
        try {
            I(c(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e8);
        }
    }

    private Class c(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.f8018c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f8018c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f8016a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
            this.f8016a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f8017b.get(cls.getName());
        if (method == null) {
            Class c8 = c(cls);
            System.currentTimeMillis();
            Method declaredMethod = c8.getDeclaredMethod("write", cls, VersionedParcel.class);
            this.f8017b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i8) {
        w(i8);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i8) {
        w(i8);
        C(charSequence);
    }

    protected abstract void E(int i8);

    public void F(int i8, int i9) {
        w(i9);
        E(i8);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i8) {
        w(i8);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i8) {
        w(i8);
        I(str);
    }

    protected <T extends VersionedParcelable> void K(T t7, VersionedParcel versionedParcel) {
        try {
            e(t7.getClass()).invoke(null, t7, versionedParcel);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e9);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            I(null);
            return;
        }
        N(versionedParcelable);
        VersionedParcel b8 = b();
        K(versionedParcelable, b8);
        b8.a();
    }

    public void M(VersionedParcelable versionedParcelable, int i8) {
        w(i8);
        L(versionedParcelable);
    }

    protected abstract void a();

    protected abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z7, int i8) {
        if (!m(i8)) {
            return z7;
        }
        return g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i8) {
        if (!m(i8)) {
            return bArr;
        }
        return i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i8) {
        if (!m(i8)) {
            return charSequence;
        }
        return k();
    }

    protected abstract boolean m(int i8);

    protected <T extends VersionedParcelable> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (T) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e9);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        }
    }

    protected abstract int o();

    public int p(int i8, int i9) {
        if (!m(i9)) {
            return i8;
        }
        return o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t7, int i8) {
        if (!m(i8)) {
            return t7;
        }
        return (T) q();
    }

    protected abstract String s();

    public String t(String str, int i8) {
        if (!m(i8)) {
            return str;
        }
        return s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends VersionedParcelable> T u() {
        String s7 = s();
        if (s7 == null) {
            return null;
        }
        return (T) n(s7, b());
    }

    public <T extends VersionedParcelable> T v(T t7, int i8) {
        if (!m(i8)) {
            return t7;
        }
        return (T) u();
    }

    protected abstract void w(int i8);

    public void x(boolean z7, boolean z8) {
    }

    protected abstract void y(boolean z7);

    public void z(boolean z7, int i8) {
        w(i8);
        y(z7);
    }
}

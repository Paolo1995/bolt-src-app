package com.mixpanel.android.viewcrawler;

import android.view.View;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class Caller {

    /* renamed from: a  reason: collision with root package name */
    private final String f19435a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f19436b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f19437c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f19438d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f19439e;

    public Caller(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        this.f19435a = str;
        this.f19436b = objArr;
        this.f19437c = cls2;
        Method f8 = f(cls);
        this.f19439e = f8;
        if (f8 != null) {
            this.f19438d = f8.getDeclaringClass();
            return;
        }
        throw new NoSuchMethodException("Method " + cls.getName() + "." + str + " doesn't exit");
    }

    private static Class<?> d(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return cls;
    }

    private Method f(Class<?> cls) {
        Method[] methods;
        Class[] clsArr = new Class[this.f19436b.length];
        int i8 = 0;
        while (true) {
            Object[] objArr = this.f19436b;
            if (i8 >= objArr.length) {
                break;
            }
            clsArr[i8] = objArr[i8].getClass();
            i8++;
        }
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.f19435a) && parameterTypes.length == this.f19436b.length && d(this.f19437c).isAssignableFrom(d(method.getReturnType()))) {
                boolean z7 = true;
                for (int i9 = 0; i9 < parameterTypes.length && z7; i9++) {
                    z7 = d(parameterTypes[i9]).isAssignableFrom(d(clsArr[i9]));
                }
                if (z7) {
                    return method;
                }
            }
        }
        return null;
    }

    public Object a(View view) {
        return b(view, this.f19436b);
    }

    public Object b(View view, Object[] objArr) {
        if (this.f19438d.isAssignableFrom(view.getClass())) {
            try {
                return this.f19439e.invoke(view, objArr);
            } catch (IllegalAccessException e8) {
                MPLog.d("MixpanelABTest.Caller", "Method " + this.f19439e.getName() + " appears not to be public", e8);
                return null;
            } catch (IllegalArgumentException e9) {
                MPLog.d("MixpanelABTest.Caller", "Method " + this.f19439e.getName() + " called with arguments of the wrong type", e9);
                return null;
            } catch (InvocationTargetException e10) {
                MPLog.d("MixpanelABTest.Caller", "Method " + this.f19439e.getName() + " threw an exception", e10);
                return null;
            }
        }
        return null;
    }

    public boolean c(Object[] objArr) {
        Class<?>[] parameterTypes = this.f19439e.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i8 = 0; i8 < objArr.length; i8++) {
            Class<?> d8 = d(parameterTypes[i8]);
            Object obj = objArr[i8];
            if (obj == null) {
                if (d8 == Byte.TYPE || d8 == Short.TYPE || d8 == Integer.TYPE || d8 == Long.TYPE || d8 == Float.TYPE || d8 == Double.TYPE || d8 == Boolean.TYPE || d8 == Character.TYPE) {
                    return false;
                }
            } else if (!d8.isAssignableFrom(d(obj.getClass()))) {
                return false;
            }
        }
        return true;
    }

    public Object[] e() {
        return this.f19436b;
    }

    public String toString() {
        return "[Caller " + this.f19435a + "(" + this.f19436b + ")]";
    }
}

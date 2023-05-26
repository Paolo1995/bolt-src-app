package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
final class ClassesInfoCache {

    /* renamed from: c  reason: collision with root package name */
    static ClassesInfoCache f6651c = new ClassesInfoCache();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, CallbackInfo> f6652a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f6653b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: classes.dex */
    public static class CallbackInfo {

        /* renamed from: a  reason: collision with root package name */
        final Map<Lifecycle.Event, List<MethodReference>> f6654a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<MethodReference, Lifecycle.Event> f6655b;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.f6655b = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> list = this.f6654a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f6654a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lifecycleOwner, event, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            b(this.f6654a.get(event), lifecycleOwner, event, obj);
            b(this.f6654a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: classes.dex */
    public static final class MethodReference {

        /* renamed from: a  reason: collision with root package name */
        final int f6656a;

        /* renamed from: b  reason: collision with root package name */
        final Method f6657b;

        MethodReference(int i8, Method method) {
            this.f6656a = i8;
            this.f6657b = method;
            method.setAccessible(true);
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i8 = this.f6656a;
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            this.f6657b.invoke(obj, lifecycleOwner, event);
                            return;
                        }
                        return;
                    }
                    this.f6657b.invoke(obj, lifecycleOwner);
                    return;
                }
                this.f6657b.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e8) {
                throw new RuntimeException(e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException("Failed to call observer method", e9.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (this.f6656a == methodReference.f6656a && this.f6657b.getName().equals(methodReference.f6657b.getName())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f6656a * 31) + this.f6657b.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    private CallbackInfo a(Class<?> cls, Method[] methodArr) {
        int i8;
        CallbackInfo c8;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c8 = c(superclass)) != null) {
            hashMap.putAll(c8.f6655b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : c(cls2).f6655b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z7 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                        i8 = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i8 = 0;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        if (value == Lifecycle.Event.ON_ANY) {
                            i8 = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new MethodReference(i8, method), value, cls);
                    z7 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.f6652a.put(cls, callbackInfo);
        this.f6653b.put(cls, Boolean.valueOf(z7));
        return callbackInfo;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e8) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e8);
        }
    }

    private void e(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 != null && event != event2) {
            Method method = methodReference.f6657b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackInfo c(Class<?> cls) {
        CallbackInfo callbackInfo = this.f6652a.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f6653b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b8 = b(cls);
        for (Method method : b8) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, b8);
                return true;
            }
        }
        this.f6653b.put(cls, Boolean.FALSE);
        return false;
    }
}

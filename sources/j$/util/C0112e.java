package j$.util;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0112e implements java.util.Map, Serializable, Map {

    /* renamed from: a  reason: collision with root package name */
    private final java.util.Map f50258a;

    /* renamed from: b  reason: collision with root package name */
    final Object f50259b;

    /* renamed from: c  reason: collision with root package name */
    private transient Set f50260c;

    /* renamed from: d  reason: collision with root package name */
    private transient Set f50261d;

    /* renamed from: e  reason: collision with root package name */
    private transient Collection f50262e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0112e(java.util.Map map) {
        map.getClass();
        this.f50258a = map;
        this.f50259b = this;
    }

    private static Set a(Set set, Object obj) {
        Constructor constructor;
        Constructor constructor2;
        constructor = DesugarCollections.f50142f;
        if (constructor == null) {
            return Collections.synchronizedSet(set);
        }
        try {
            constructor2 = DesugarCollections.f50142f;
            return (Set) constructor2.newInstance(set, obj);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e8) {
            throw new Error("Unable to instantiate a synchronized list.", e8);
        }
    }

    @Override // java.util.Map, j$.util.Map
    public final void clear() {
        synchronized (this.f50259b) {
            this.f50258a.clear();
        }
    }

    @Override // j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        Object $default$compute;
        Object apply;
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                $default$compute = ((Map) map).compute(obj, biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                biFunction.getClass();
                loop0: while (true) {
                    Object obj2 = concurrentMap.get(obj);
                    while (true) {
                        apply = biFunction.apply(obj, obj2);
                        if (apply != null) {
                            if (obj2 == null) {
                                obj2 = concurrentMap.putIfAbsent(obj, apply);
                                if (obj2 == null) {
                                    break loop0;
                                }
                            } else if (concurrentMap.replace(obj, obj2, apply)) {
                                break;
                            }
                        } else {
                            apply = null;
                            if ((obj2 == null && !concurrentMap.containsKey(obj)) || concurrentMap.remove(obj, obj2)) {
                                break;
                            }
                        }
                    }
                }
                $default$compute = apply;
            } else {
                $default$compute = Map.CC.$default$compute(map, obj, biFunction);
            }
        }
        return $default$compute;
    }

    @Override // java.util.Map
    public final /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        Object computeIfAbsent;
        synchronized (this.f50259b) {
            computeIfAbsent = Map.EL.computeIfAbsent(this.f50258a, obj, function);
        }
        return computeIfAbsent;
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // j$.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        Object $default$computeIfPresent;
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                $default$computeIfPresent = ((Map) map).computeIfPresent(obj, biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                biFunction.getClass();
                while (true) {
                    Object obj2 = concurrentMap.get(obj);
                    if (obj2 == null) {
                        $default$computeIfPresent = obj2;
                        break;
                    }
                    Object apply = biFunction.apply(obj, obj2);
                    if (apply != null) {
                        if (concurrentMap.replace(obj, obj2, apply)) {
                            $default$computeIfPresent = apply;
                            break;
                        }
                    } else if (concurrentMap.remove(obj, obj2)) {
                        $default$computeIfPresent = null;
                        break;
                    }
                }
            } else {
                $default$computeIfPresent = Map.CC.$default$computeIfPresent(map, obj, biFunction);
            }
        }
        return $default$computeIfPresent;
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f50259b) {
            containsKey = this.f50258a.containsKey(obj);
        }
        return containsKey;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f50259b) {
            containsValue = this.f50258a.containsValue(obj);
        }
        return containsValue;
    }

    @Override // java.util.Map, j$.util.Map
    public final Set entrySet() {
        Set set;
        synchronized (this.f50259b) {
            if (this.f50261d == null) {
                this.f50261d = a(this.f50258a.entrySet(), this.f50259b);
            }
            set = this.f50261d;
        }
        return set;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f50259b) {
            equals = this.f50258a.equals(obj);
        }
        return equals;
    }

    @Override // j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        synchronized (this.f50259b) {
            Map.EL.forEach(this.f50258a, biConsumer);
        }
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.Map, j$.util.Map
    public final Object get(Object obj) {
        Object obj2;
        synchronized (this.f50259b) {
            obj2 = this.f50258a.get(obj);
        }
        return obj2;
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        Object $default$getOrDefault;
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                $default$getOrDefault = ((Map) map).getOrDefault(obj, obj2);
            } else if (map instanceof ConcurrentMap) {
                Object obj3 = ((ConcurrentMap) map).get(obj);
                if (obj3 != null) {
                    obj2 = obj3;
                }
                $default$getOrDefault = obj2;
            } else {
                $default$getOrDefault = Map.CC.$default$getOrDefault(map, obj, obj2);
            }
        }
        return $default$getOrDefault;
    }

    @Override // java.util.Map, j$.util.Map
    public final int hashCode() {
        int hashCode;
        synchronized (this.f50259b) {
            hashCode = this.f50258a.hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f50259b) {
            isEmpty = this.f50258a.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Map, j$.util.Map
    public final Set keySet() {
        Set set;
        synchronized (this.f50259b) {
            if (this.f50260c == null) {
                this.f50260c = a(this.f50258a.keySet(), this.f50259b);
            }
            set = this.f50260c;
        }
        return set;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r3 = r7.apply(r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r3 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r1.replace(r5, r2, r3) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r1.remove(r5, r2) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        r6 = null;
     */
    @Override // j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object merge(java.lang.Object r5, java.lang.Object r6, j$.util.function.BiFunction r7) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f50259b
            monitor-enter(r0)
            java.util.Map r1 = r4.f50258a     // Catch: java.lang.Throwable -> L46
            boolean r2 = r1 instanceof j$.util.Map     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L10
            j$.util.Map r1 = (j$.util.Map) r1     // Catch: java.lang.Throwable -> L46
            java.lang.Object r5 = r1.merge(r5, r6, r7)     // Catch: java.lang.Throwable -> L46
            goto L44
        L10:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L40
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L46
            r7.getClass()     // Catch: java.lang.Throwable -> L46
            r6.getClass()     // Catch: java.lang.Throwable -> L46
        L1c:
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L46
        L20:
            if (r2 == 0) goto L38
            java.lang.Object r3 = r7.apply(r2, r6)     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L30
            boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L1c
            r6 = r3
            goto L3e
        L30:
            boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L1c
            r6 = 0
            goto L3e
        L38:
            java.lang.Object r2 = r1.putIfAbsent(r5, r6)     // Catch: java.lang.Throwable -> L46
            if (r2 != 0) goto L20
        L3e:
            r5 = r6
            goto L44
        L40:
            java.lang.Object r5 = j$.util.Map.CC.$default$merge(r1, r5, r6, r7)     // Catch: java.lang.Throwable -> L46
        L44:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            return r5
        L46:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.C0112e.merge(java.lang.Object, java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    @Override // java.util.Map
    public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public final Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this.f50259b) {
            put = this.f50258a.put(obj, obj2);
        }
        return put;
    }

    @Override // java.util.Map, j$.util.Map
    public final void putAll(java.util.Map map) {
        synchronized (this.f50259b) {
            this.f50258a.putAll(map);
        }
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        Object a8;
        synchronized (this.f50259b) {
            a8 = Map.EL.a(this.f50258a, obj, obj2);
        }
        return a8;
    }

    @Override // java.util.Map, j$.util.Map
    public final Object remove(Object obj) {
        Object remove;
        synchronized (this.f50259b) {
            remove = this.f50258a.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        boolean z7;
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                z7 = ((Map) map).remove(obj, obj2);
            } else {
                Object obj3 = map.get(obj);
                if (AbstractC0156n.l(obj3, obj2) && (obj3 != null || map.containsKey(obj))) {
                    map.remove(obj);
                    z7 = true;
                }
                z7 = false;
            }
        }
        return z7;
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        Object put;
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                put = ((Map) map).replace(obj, obj2);
            } else {
                Object obj3 = map.get(obj);
                if (obj3 == null && !map.containsKey(obj)) {
                    put = obj3;
                }
                put = map.put(obj, obj2);
            }
        }
        return put;
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        boolean z7;
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                z7 = ((Map) map).replace(obj, obj2, obj3);
            } else {
                Object obj4 = map.get(obj);
                if (AbstractC0156n.l(obj4, obj2) && (obj4 != null || map.containsKey(obj))) {
                    map.put(obj, obj3);
                    z7 = true;
                }
                z7 = false;
            }
        }
        return z7;
    }

    @Override // j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        synchronized (this.f50259b) {
            java.util.Map map = this.f50258a;
            if (map instanceof Map) {
                ((Map) map).replaceAll(biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                biFunction.getClass();
                j$.util.concurrent.u uVar = new j$.util.concurrent.u(0, concurrentMap, biFunction);
                if (concurrentMap instanceof j$.util.concurrent.v) {
                    ((j$.util.concurrent.v) concurrentMap).forEach(uVar);
                } else {
                    j$.time.a.a(concurrentMap, uVar);
                }
            } else {
                Map.CC.$default$replaceAll(map, biFunction);
            }
        }
    }

    @Override // java.util.Map
    public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public final int size() {
        int size;
        synchronized (this.f50259b) {
            size = this.f50258a.size();
        }
        return size;
    }

    public final String toString() {
        String obj;
        synchronized (this.f50259b) {
            obj = this.f50258a.toString();
        }
        return obj;
    }

    @Override // java.util.Map, j$.util.Map
    public final Collection values() {
        Collection collection;
        Constructor constructor;
        Constructor constructor2;
        Collection collection2;
        synchronized (this.f50259b) {
            if (this.f50262e == null) {
                Collection values = this.f50258a.values();
                Object obj = this.f50259b;
                constructor = DesugarCollections.f50141e;
                if (constructor == null) {
                    collection2 = Collections.synchronizedCollection(values);
                } else {
                    try {
                        constructor2 = DesugarCollections.f50141e;
                        collection2 = (Collection) constructor2.newInstance(values, obj);
                    } catch (IllegalAccessException e8) {
                        e = e8;
                        throw new Error("Unable to instantiate a synchronized list.", e);
                    } catch (InstantiationException e9) {
                        e = e9;
                        throw new Error("Unable to instantiate a synchronized list.", e);
                    } catch (InvocationTargetException e10) {
                        e = e10;
                        throw new Error("Unable to instantiate a synchronized list.", e);
                    }
                }
                this.f50262e = collection2;
            }
            collection = this.f50262e;
        }
        return collection;
    }
}

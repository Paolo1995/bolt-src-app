package j$.util.concurrent;

import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r extends m {

    /* renamed from: h  reason: collision with root package name */
    private static final Unsafe f50238h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f50239i;

    /* renamed from: e  reason: collision with root package name */
    s f50240e;

    /* renamed from: f  reason: collision with root package name */
    volatile s f50241f;

    /* renamed from: g  reason: collision with root package name */
    volatile Thread f50242g;
    volatile int lockState;

    static {
        try {
            Unsafe c8 = w.c();
            f50238h = c8;
            f50239i = c8.objectFieldOffset(r.class.getDeclaredField("lockState"));
        } catch (Exception e8) {
            throw new Error(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(s sVar) {
        super(-2, null, null, null);
        int compareComparables;
        int j8;
        this.f50241f = sVar;
        s sVar2 = null;
        while (sVar != null) {
            s sVar3 = (s) sVar.f50225d;
            sVar.f50245g = null;
            sVar.f50244f = null;
            if (sVar2 == null) {
                sVar.f50243e = null;
                sVar.f50247i = false;
            } else {
                Object obj = sVar.f50223b;
                int i8 = sVar.f50222a;
                s sVar4 = sVar2;
                Class<?> cls = null;
                while (true) {
                    Object obj2 = sVar4.f50223b;
                    int i9 = sVar4.f50222a;
                    j8 = i9 > i8 ? -1 : i9 < i8 ? 1 : ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) ? j(obj, obj2) : compareComparables;
                    s sVar5 = j8 <= 0 ? sVar4.f50244f : sVar4.f50245g;
                    if (sVar5 == null) {
                        break;
                    }
                    sVar4 = sVar5;
                }
                sVar.f50243e = sVar4;
                if (j8 <= 0) {
                    sVar4.f50244f = sVar;
                } else {
                    sVar4.f50245g = sVar;
                }
                sVar = c(sVar2, sVar);
            }
            sVar2 = sVar;
            sVar = sVar3;
        }
        this.f50240e = sVar2;
    }

    static s b(s sVar, s sVar2) {
        while (sVar2 != null && sVar2 != sVar) {
            s sVar3 = sVar2.f50243e;
            if (sVar3 == null) {
                sVar2.f50247i = false;
                return sVar2;
            } else if (sVar2.f50247i) {
                sVar2.f50247i = false;
                return sVar;
            } else {
                s sVar4 = sVar3.f50244f;
                if (sVar4 == sVar2) {
                    sVar4 = sVar3.f50245g;
                    if (sVar4 != null && sVar4.f50247i) {
                        sVar4.f50247i = false;
                        sVar3.f50247i = true;
                        sVar = h(sVar, sVar3);
                        sVar3 = sVar2.f50243e;
                        sVar4 = sVar3 == null ? null : sVar3.f50245g;
                    }
                    if (sVar4 == null) {
                        sVar2 = sVar3;
                    } else {
                        s sVar5 = sVar4.f50244f;
                        s sVar6 = sVar4.f50245g;
                        if ((sVar6 != null && sVar6.f50247i) || (sVar5 != null && sVar5.f50247i)) {
                            if (sVar6 == null || !sVar6.f50247i) {
                                if (sVar5 != null) {
                                    sVar5.f50247i = false;
                                }
                                sVar4.f50247i = true;
                                sVar = i(sVar, sVar4);
                                sVar3 = sVar2.f50243e;
                                sVar4 = sVar3 != null ? sVar3.f50245g : null;
                            }
                            if (sVar4 != null) {
                                sVar4.f50247i = sVar3 == null ? false : sVar3.f50247i;
                                s sVar7 = sVar4.f50245g;
                                if (sVar7 != null) {
                                    sVar7.f50247i = false;
                                }
                            }
                            if (sVar3 != null) {
                                sVar3.f50247i = false;
                                sVar = h(sVar, sVar3);
                            }
                            sVar2 = sVar;
                            sVar = sVar2;
                        }
                        sVar4.f50247i = true;
                        sVar2 = sVar3;
                    }
                } else {
                    if (sVar4 != null && sVar4.f50247i) {
                        sVar4.f50247i = false;
                        sVar3.f50247i = true;
                        sVar = i(sVar, sVar3);
                        sVar3 = sVar2.f50243e;
                        sVar4 = sVar3 == null ? null : sVar3.f50244f;
                    }
                    if (sVar4 == null) {
                        sVar2 = sVar3;
                    } else {
                        s sVar8 = sVar4.f50244f;
                        s sVar9 = sVar4.f50245g;
                        if ((sVar8 != null && sVar8.f50247i) || (sVar9 != null && sVar9.f50247i)) {
                            if (sVar8 == null || !sVar8.f50247i) {
                                if (sVar9 != null) {
                                    sVar9.f50247i = false;
                                }
                                sVar4.f50247i = true;
                                sVar = h(sVar, sVar4);
                                sVar3 = sVar2.f50243e;
                                sVar4 = sVar3 != null ? sVar3.f50244f : null;
                            }
                            if (sVar4 != null) {
                                sVar4.f50247i = sVar3 == null ? false : sVar3.f50247i;
                                s sVar10 = sVar4.f50244f;
                                if (sVar10 != null) {
                                    sVar10.f50247i = false;
                                }
                            }
                            if (sVar3 != null) {
                                sVar3.f50247i = false;
                                sVar = i(sVar, sVar3);
                            }
                            sVar2 = sVar;
                            sVar = sVar2;
                        }
                        sVar4.f50247i = true;
                        sVar2 = sVar3;
                    }
                }
            }
        }
        return sVar;
    }

    static s c(s sVar, s sVar2) {
        s sVar3;
        sVar2.f50247i = true;
        while (true) {
            s sVar4 = sVar2.f50243e;
            if (sVar4 == null) {
                sVar2.f50247i = false;
                return sVar2;
            } else if (!sVar4.f50247i || (sVar3 = sVar4.f50243e) == null) {
                break;
            } else {
                s sVar5 = sVar3.f50244f;
                if (sVar4 == sVar5) {
                    sVar5 = sVar3.f50245g;
                    if (sVar5 == null || !sVar5.f50247i) {
                        if (sVar2 == sVar4.f50245g) {
                            sVar = h(sVar, sVar4);
                            s sVar6 = sVar4.f50243e;
                            sVar3 = sVar6 == null ? null : sVar6.f50243e;
                            sVar4 = sVar6;
                            sVar2 = sVar4;
                        }
                        if (sVar4 != null) {
                            sVar4.f50247i = false;
                            if (sVar3 != null) {
                                sVar3.f50247i = true;
                                sVar = i(sVar, sVar3);
                            }
                        }
                    } else {
                        sVar5.f50247i = false;
                        sVar4.f50247i = false;
                        sVar3.f50247i = true;
                        sVar2 = sVar3;
                    }
                } else if (sVar5 == null || !sVar5.f50247i) {
                    if (sVar2 == sVar4.f50244f) {
                        sVar = i(sVar, sVar4);
                        s sVar7 = sVar4.f50243e;
                        sVar3 = sVar7 == null ? null : sVar7.f50243e;
                        sVar4 = sVar7;
                        sVar2 = sVar4;
                    }
                    if (sVar4 != null) {
                        sVar4.f50247i = false;
                        if (sVar3 != null) {
                            sVar3.f50247i = true;
                            sVar = h(sVar, sVar3);
                        }
                    }
                } else {
                    sVar5.f50247i = false;
                    sVar4.f50247i = false;
                    sVar3.f50247i = true;
                    sVar2 = sVar3;
                }
            }
        }
        return sVar;
    }

    private final void d() {
        boolean z7 = false;
        while (true) {
            int i8 = this.lockState;
            if ((i8 & (-3)) == 0) {
                if (f50238h.compareAndSwapInt(this, f50239i, i8, 1)) {
                    break;
                }
            } else if ((i8 & 2) == 0) {
                if (f50238h.compareAndSwapInt(this, f50239i, i8, i8 | 2)) {
                    z7 = true;
                    this.f50242g = Thread.currentThread();
                }
            } else if (z7) {
                LockSupport.park(this);
            }
        }
        if (z7) {
            this.f50242g = null;
        }
    }

    private final void e() {
        if (f50238h.compareAndSwapInt(this, f50239i, 0, 1)) {
            return;
        }
        d();
    }

    static s h(s sVar, s sVar2) {
        s sVar3 = sVar2.f50245g;
        if (sVar3 != null) {
            s sVar4 = sVar3.f50244f;
            sVar2.f50245g = sVar4;
            if (sVar4 != null) {
                sVar4.f50243e = sVar2;
            }
            s sVar5 = sVar2.f50243e;
            sVar3.f50243e = sVar5;
            if (sVar5 == null) {
                sVar3.f50247i = false;
                sVar = sVar3;
            } else if (sVar5.f50244f == sVar2) {
                sVar5.f50244f = sVar3;
            } else {
                sVar5.f50245g = sVar3;
            }
            sVar3.f50244f = sVar2;
            sVar2.f50243e = sVar3;
        }
        return sVar;
    }

    static s i(s sVar, s sVar2) {
        s sVar3 = sVar2.f50244f;
        if (sVar3 != null) {
            s sVar4 = sVar3.f50245g;
            sVar2.f50244f = sVar4;
            if (sVar4 != null) {
                sVar4.f50243e = sVar2;
            }
            s sVar5 = sVar2.f50243e;
            sVar3.f50243e = sVar5;
            if (sVar5 == null) {
                sVar3.f50247i = false;
                sVar = sVar3;
            } else if (sVar5.f50245g == sVar2) {
                sVar5.f50245g = sVar3;
            } else {
                sVar5.f50244f = sVar3;
            }
            sVar3.f50245g = sVar2;
            sVar2.f50243e = sVar3;
        }
        return sVar;
    }

    static int j(Object obj, Object obj2) {
        int compareTo;
        return (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : compareTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.concurrent.m
    public final m a(int i8, Object obj) {
        Object obj2;
        Thread thread;
        Thread thread2;
        s sVar = null;
        if (obj != null) {
            m mVar = this.f50241f;
            while (mVar != null) {
                int i9 = this.lockState;
                if ((i9 & 3) == 0) {
                    Unsafe unsafe = f50238h;
                    long j8 = f50239i;
                    if (unsafe.compareAndSwapInt(this, j8, i9, i9 + 4)) {
                        try {
                            s sVar2 = this.f50240e;
                            if (sVar2 != null) {
                                sVar = sVar2.b(i8, obj, null);
                            }
                            if (w.a(unsafe, this, j8) == 6 && (thread2 = this.f50242g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return sVar;
                        } catch (Throwable th) {
                            if (w.a(f50238h, this, f50239i) == 6 && (thread = this.f50242g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th;
                        }
                    }
                } else if (mVar.f50222a == i8 && ((obj2 = mVar.f50223b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return mVar;
                } else {
                    mVar = mVar.f50225d;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.util.concurrent.s f(int r16, java.lang.Object r17, java.lang.Object r18) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r4 = r17
            j$.util.concurrent.s r2 = r1.f50240e
            r8 = 0
            r9 = 0
            r10 = r2
            r2 = r9
            r3 = 0
        Lc:
            if (r10 != 0) goto L22
            j$.util.concurrent.s r8 = new j$.util.concurrent.s
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r16
            r4 = r17
            r5 = r18
            r2.<init>(r3, r4, r5, r6, r7)
            r1.f50240e = r8
            r1.f50241f = r8
            goto La3
        L22:
            int r5 = r10.f50222a
            r11 = 1
            if (r5 <= r0) goto L2a
            r5 = -1
            r12 = -1
            goto L69
        L2a:
            if (r5 >= r0) goto L2e
            r12 = 1
            goto L69
        L2e:
            java.lang.Object r5 = r10.f50223b
            if (r5 == r4) goto Lab
            if (r5 == 0) goto L3c
            boolean r6 = r4.equals(r5)
            if (r6 == 0) goto L3c
            goto Lab
        L3c:
            if (r2 != 0) goto L44
            java.lang.Class r2 = j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r17)
            if (r2 == 0) goto L4a
        L44:
            int r6 = j$.util.concurrent.ConcurrentHashMap.compareComparables(r2, r4, r5)
            if (r6 != 0) goto L68
        L4a:
            if (r3 != 0) goto L62
            j$.util.concurrent.s r3 = r10.f50244f
            if (r3 == 0) goto L56
            j$.util.concurrent.s r3 = r3.b(r0, r4, r2)
            if (r3 != 0) goto L60
        L56:
            j$.util.concurrent.s r3 = r10.f50245g
            if (r3 == 0) goto L61
            j$.util.concurrent.s r3 = r3.b(r0, r4, r2)
            if (r3 == 0) goto L61
        L60:
            return r3
        L61:
            r3 = 1
        L62:
            int r5 = j(r4, r5)
            r12 = r5
            goto L69
        L68:
            r12 = r6
        L69:
            if (r12 > 0) goto L6e
            j$.util.concurrent.s r5 = r10.f50244f
            goto L70
        L6e:
            j$.util.concurrent.s r5 = r10.f50245g
        L70:
            if (r5 != 0) goto La8
            j$.util.concurrent.s r13 = r1.f50241f
            j$.util.concurrent.s r14 = new j$.util.concurrent.s
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r13
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            r1.f50241f = r14
            if (r13 == 0) goto L88
            r13.f50246h = r14
        L88:
            if (r12 > 0) goto L8d
            r10.f50244f = r14
            goto L8f
        L8d:
            r10.f50245g = r14
        L8f:
            boolean r0 = r10.f50247i
            if (r0 != 0) goto L96
            r14.f50247i = r11
            goto La3
        L96:
            r15.e()
            j$.util.concurrent.s r0 = r1.f50240e     // Catch: java.lang.Throwable -> La4
            j$.util.concurrent.s r0 = c(r0, r14)     // Catch: java.lang.Throwable -> La4
            r1.f50240e = r0     // Catch: java.lang.Throwable -> La4
            r1.lockState = r8
        La3:
            return r9
        La4:
            r0 = move-exception
            r1.lockState = r8
            throw r0
        La8:
            r10 = r5
            goto Lc
        Lab:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.r.f(int, java.lang.Object, java.lang.Object):j$.util.concurrent.s");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008e A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00aa A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b2 A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ba A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bd A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(j$.util.concurrent.s r11) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.r.g(j$.util.concurrent.s):boolean");
    }
}

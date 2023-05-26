package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* loaded from: classes.dex */
class OpReorderer {

    /* renamed from: a  reason: collision with root package name */
    final Callback f7169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp a(int i8, int i9, int i10, Object obj);

        void b(AdapterHelper.UpdateOp updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpReorderer(Callback callback) {
        this.f7169a = callback;
    }

    private int a(List<AdapterHelper.UpdateOp> list) {
        boolean z7 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f6897a == 8) {
                if (z7) {
                    return size;
                }
            } else {
                z7 = true;
            }
        }
        return -1;
    }

    private void c(List<AdapterHelper.UpdateOp> list, int i8, AdapterHelper.UpdateOp updateOp, int i9, AdapterHelper.UpdateOp updateOp2) {
        int i10;
        int i11 = updateOp.f6900d;
        int i12 = updateOp2.f6898b;
        if (i11 < i12) {
            i10 = -1;
        } else {
            i10 = 0;
        }
        int i13 = updateOp.f6898b;
        if (i13 < i12) {
            i10++;
        }
        if (i12 <= i13) {
            updateOp.f6898b = i13 + updateOp2.f6900d;
        }
        int i14 = updateOp2.f6898b;
        if (i14 <= i11) {
            updateOp.f6900d = i11 + updateOp2.f6900d;
        }
        updateOp2.f6898b = i14 + i10;
        list.set(i8, updateOp2);
        list.set(i9, updateOp);
    }

    private void d(List<AdapterHelper.UpdateOp> list, int i8, int i9) {
        AdapterHelper.UpdateOp updateOp = list.get(i8);
        AdapterHelper.UpdateOp updateOp2 = list.get(i9);
        int i10 = updateOp2.f6897a;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 4) {
                    f(list, i8, updateOp, i9, updateOp2);
                    return;
                }
                return;
            }
            e(list, i8, updateOp, i9, updateOp2);
            return;
        }
        c(list, i8, updateOp, i9, updateOp2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int a8 = a(list);
            if (a8 != -1) {
                d(list, a8, a8 + 1);
            } else {
                return;
            }
        }
    }

    void e(List<AdapterHelper.UpdateOp> list, int i8, AdapterHelper.UpdateOp updateOp, int i9, AdapterHelper.UpdateOp updateOp2) {
        boolean z7;
        int i10 = updateOp.f6898b;
        int i11 = updateOp.f6900d;
        boolean z8 = false;
        if (i10 < i11) {
            if (updateOp2.f6898b == i10 && updateOp2.f6900d == i11 - i10) {
                z7 = false;
                z8 = true;
            } else {
                z7 = false;
            }
        } else if (updateOp2.f6898b == i11 + 1 && updateOp2.f6900d == i10 - i11) {
            z7 = true;
            z8 = true;
        } else {
            z7 = true;
        }
        int i12 = updateOp2.f6898b;
        if (i11 < i12) {
            updateOp2.f6898b = i12 - 1;
        } else {
            int i13 = updateOp2.f6900d;
            if (i11 < i12 + i13) {
                updateOp2.f6900d = i13 - 1;
                updateOp.f6897a = 2;
                updateOp.f6900d = 1;
                if (updateOp2.f6900d == 0) {
                    list.remove(i9);
                    this.f7169a.b(updateOp2);
                    return;
                }
                return;
            }
        }
        int i14 = updateOp.f6898b;
        int i15 = updateOp2.f6898b;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i14 <= i15) {
            updateOp2.f6898b = i15 + 1;
        } else {
            int i16 = updateOp2.f6900d;
            if (i14 < i15 + i16) {
                updateOp3 = this.f7169a.a(2, i14 + 1, (i15 + i16) - i14, null);
                updateOp2.f6900d = updateOp.f6898b - updateOp2.f6898b;
            }
        }
        if (z8) {
            list.set(i8, updateOp2);
            list.remove(i9);
            this.f7169a.b(updateOp);
            return;
        }
        if (z7) {
            if (updateOp3 != null) {
                int i17 = updateOp.f6898b;
                if (i17 > updateOp3.f6898b) {
                    updateOp.f6898b = i17 - updateOp3.f6900d;
                }
                int i18 = updateOp.f6900d;
                if (i18 > updateOp3.f6898b) {
                    updateOp.f6900d = i18 - updateOp3.f6900d;
                }
            }
            int i19 = updateOp.f6898b;
            if (i19 > updateOp2.f6898b) {
                updateOp.f6898b = i19 - updateOp2.f6900d;
            }
            int i20 = updateOp.f6900d;
            if (i20 > updateOp2.f6898b) {
                updateOp.f6900d = i20 - updateOp2.f6900d;
            }
        } else {
            if (updateOp3 != null) {
                int i21 = updateOp.f6898b;
                if (i21 >= updateOp3.f6898b) {
                    updateOp.f6898b = i21 - updateOp3.f6900d;
                }
                int i22 = updateOp.f6900d;
                if (i22 >= updateOp3.f6898b) {
                    updateOp.f6900d = i22 - updateOp3.f6900d;
                }
            }
            int i23 = updateOp.f6898b;
            if (i23 >= updateOp2.f6898b) {
                updateOp.f6898b = i23 - updateOp2.f6900d;
            }
            int i24 = updateOp.f6900d;
            if (i24 >= updateOp2.f6898b) {
                updateOp.f6900d = i24 - updateOp2.f6900d;
            }
        }
        list.set(i8, updateOp2);
        if (updateOp.f6898b != updateOp.f6900d) {
            list.set(i9, updateOp);
        } else {
            list.remove(i9);
        }
        if (updateOp3 != null) {
            list.add(i8, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.f6900d
            int r1 = r13.f6898b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f6898b = r1
            goto L20
        Ld:
            int r5 = r13.f6900d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f6900d = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.f7169a
            int r1 = r11.f6898b
            java.lang.Object r5 = r13.f6899c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.a(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f6898b
            int r5 = r13.f6898b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f6898b = r5
            goto L41
        L2b:
            int r6 = r13.f6900d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r3 = r8.f7169a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f6899c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r3 = r3.a(r2, r1, r5, r4)
            int r1 = r13.f6900d
            int r1 = r1 - r5
            r13.f6900d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f6900d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.f7169a
            r11.b(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.f(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}

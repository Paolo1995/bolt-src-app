package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Checks;
import java.util.Arrays;

/* loaded from: classes3.dex */
class ImmutableIntArray implements ImmutableIntList {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f18700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableIntArray(int... iArr) {
        this.f18700a = iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableIntList)) {
            return false;
        }
        if (obj instanceof ImmutableIntArray) {
            return Arrays.equals(this.f18700a, ((ImmutableIntArray) obj).f18700a);
        }
        ImmutableIntList immutableIntList = (ImmutableIntList) obj;
        if (this.f18700a.length != immutableIntList.size()) {
            return false;
        }
        int i8 = 0;
        while (true) {
            int[] iArr = this.f18700a;
            if (i8 >= iArr.length) {
                return true;
            }
            if (iArr[i8] != immutableIntList.get(i8)) {
                return false;
            }
            i8++;
        }
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableIntList
    public int get(int i8) {
        int[] iArr = this.f18700a;
        return iArr[Checks.d(i8, iArr.length)];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f18700a);
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableIntList
    public int size() {
        return this.f18700a.length;
    }

    public String toString() {
        return Arrays.toString(this.f18700a);
    }
}

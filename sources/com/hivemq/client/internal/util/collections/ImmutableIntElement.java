package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Checks;

/* loaded from: classes3.dex */
class ImmutableIntElement implements ImmutableIntList {

    /* renamed from: a  reason: collision with root package name */
    private final int f18701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableIntElement(int i8) {
        this.f18701a = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableIntList)) {
            return false;
        }
        ImmutableIntList immutableIntList = (ImmutableIntList) obj;
        if (immutableIntList.size() == 1 && this.f18701a == immutableIntList.get(0)) {
            return true;
        }
        return false;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableIntList
    public int get(int i8) {
        Checks.d(i8, 1);
        return this.f18701a;
    }

    public int hashCode() {
        return this.f18701a + 31;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableIntList
    public int size() {
        return 1;
    }

    public String toString() {
        return "[" + this.f18701a + "]";
    }
}

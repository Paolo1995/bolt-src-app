package com.hivemq.client.internal.util.collections;

import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
class ImmutableEmptyIntList implements ImmutableIntList {

    /* renamed from: a  reason: collision with root package name */
    static final ImmutableEmptyIntList f18695a = new ImmutableEmptyIntList();

    private ImmutableEmptyIntList() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ImmutableIntList) && ((ImmutableIntList) obj).size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableIntList
    public int get(int i8) {
        throw new IndexOutOfBoundsException("Empty int list");
    }

    public int hashCode() {
        return 1;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableIntList
    public int size() {
        return 0;
    }

    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}

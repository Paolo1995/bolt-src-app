package com.hivemq.client.internal.util.collections;

import java.util.Arrays;

/* loaded from: classes3.dex */
public interface ImmutableIntList {

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f18702a;

        /* renamed from: b  reason: collision with root package name */
        private int[] f18703b;

        /* renamed from: c  reason: collision with root package name */
        private int f18704c;

        private Builder() {
        }

        private int c(int i8) {
            return i8 + (i8 >> 1);
        }

        public Builder a(int i8) {
            int i9 = this.f18704c;
            if (i9 == 0) {
                this.f18702a = i8;
                this.f18704c = 1;
            } else {
                int[] iArr = this.f18703b;
                if (iArr == null) {
                    this.f18703b = new int[4];
                } else if (i9 == iArr.length) {
                    this.f18703b = Arrays.copyOf(iArr, c(iArr.length));
                }
                int i10 = this.f18704c;
                if (i10 == 1) {
                    this.f18703b[0] = this.f18702a;
                }
                int[] iArr2 = this.f18703b;
                this.f18704c = i10 + 1;
                iArr2[i10] = i8;
            }
            return this;
        }

        public ImmutableIntList b() {
            int i8 = this.f18704c;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (this.f18703b.length == i8) {
                        return new ImmutableIntArray(this.f18703b);
                    }
                    return new ImmutableIntArray(Arrays.copyOfRange(this.f18703b, 0, this.f18704c));
                }
                return new ImmutableIntElement(this.f18702a);
            }
            return ImmutableEmptyIntList.f18695a;
        }
    }

    int get(int i8);

    int size();
}

package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RawMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final MessageLite f15193a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15194b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f15195c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15196d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f15193a = messageLite;
        this.f15194b = str;
        this.f15195c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f15196d = charAt;
            return;
        }
        int i8 = charAt & 8191;
        int i9 = 13;
        int i10 = 1;
        while (true) {
            int i11 = i10 + 1;
            char charAt2 = str.charAt(i10);
            if (charAt2 >= 55296) {
                i8 |= (charAt2 & 8191) << i9;
                i9 += 13;
                i10 = i11;
            } else {
                this.f15196d = i8 | (charAt2 << i9);
                return;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean a() {
        if ((this.f15196d & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite b() {
        return this.f15193a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax c() {
        if ((this.f15196d & 1) == 1) {
            return ProtoSyntax.PROTO2;
        }
        return ProtoSyntax.PROTO3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] d() {
        return this.f15195c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f15194b;
    }
}

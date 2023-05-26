package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class StructuralMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ProtoSyntax f15222a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15223b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f15224c;

    /* renamed from: d  reason: collision with root package name */
    private final FieldInfo[] f15225d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f15226e;

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean a() {
        return this.f15223b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite b() {
        return this.f15226e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax c() {
        return this.f15222a;
    }

    public int[] d() {
        return this.f15224c;
    }

    public FieldInfo[] e() {
        return this.f15225d;
    }
}

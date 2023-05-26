package com.google.protobuf;

/* loaded from: classes3.dex */
final class StructuralMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ProtoSyntax f17603a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17604b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f17605c;

    /* renamed from: d  reason: collision with root package name */
    private final FieldInfo[] f17606d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f17607e;

    @Override // com.google.protobuf.MessageInfo
    public boolean a() {
        return this.f17604b;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite b() {
        return this.f17607e;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax c() {
        return this.f17603a;
    }

    public int[] d() {
        return this.f17605c;
    }

    public FieldInfo[] e() {
        return this.f17606d;
    }
}

package com.google.firebase.remoteconfig;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

/* loaded from: classes3.dex */
final /* synthetic */ class RemoteConfigComponent$$Lambda$4 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final Personalization f17050a;

    private RemoteConfigComponent$$Lambda$4(Personalization personalization) {
        this.f17050a = personalization;
    }

    public static BiConsumer a(Personalization personalization) {
        return new RemoteConfigComponent$$Lambda$4(personalization);
    }

    @Override // com.google.android.gms.common.util.BiConsumer
    public void accept(Object obj, Object obj2) {
        this.f17050a.a((String) obj, (ConfigContainer) obj2);
    }
}

package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$3 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final ConfigFetchHandler f17092a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f17093b;

    private ConfigFetchHandler$$Lambda$3(ConfigFetchHandler configFetchHandler, Date date) {
        this.f17092a = configFetchHandler;
        this.f17093b = date;
    }

    public static Continuation a(ConfigFetchHandler configFetchHandler, Date date) {
        return new ConfigFetchHandler$$Lambda$3(configFetchHandler, date);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.firebase.remoteconfig.internal.ConfigFetchHandler.p(com.google.firebase.remoteconfig.internal.ConfigFetchHandler, java.util.Date, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    @Override // com.google.android.gms.tasks.Continuation
    public java.lang.Object then(com.google.android.gms.tasks.Task r3) {
        /*
            r2 = this;
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r0 = r2.f17092a
            java.util.Date r1 = r2.f17093b
            com.google.android.gms.tasks.Task r3 = com.google.firebase.remoteconfig.internal.ConfigFetchHandler.p(r0, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$Lambda$3.then(com.google.android.gms.tasks.Task):java.lang.Object");
    }
}

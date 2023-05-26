package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class Registrar$FIIDInternalAdapter$$Lambda$0 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    static final Continuation f16323a = new Registrar$FIIDInternalAdapter$$Lambda$0();

    private Registrar$FIIDInternalAdapter$$Lambda$0() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        String a8;
        a8 = ((InstanceIdResult) task.getResult()).a();
        return a8;
    }
}

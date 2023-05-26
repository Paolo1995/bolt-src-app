package com.sinch.android.rtc.internal.service.dispatcher;

import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.natives.Dispatchable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultDispatcher implements Dispatcher {
    private final CallbackHandler callbackHandler;
    private final Set<Dispatchable> dispatchables = Collections.synchronizedSet(new HashSet());
    private boolean mStopped;

    /* loaded from: classes3.dex */
    public class Runner implements Runnable {
        private Dispatchable function;
        private final boolean mShouldRun;

        public Runner(Dispatchable dispatchable, boolean z7) {
            this.function = dispatchable;
            this.mShouldRun = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultDispatcher.this.dispatchables.remove(this.function);
            if (this.mShouldRun) {
                this.function.run();
            }
            DefaultDispatcher.this.disposeDispatchable(this.function);
        }
    }

    public DefaultDispatcher(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeDispatchable(Dispatchable dispatchable) {
        dispatchable.dispose();
        dispatchable.invalidate();
    }

    private void removeAllDispatchables() {
        this.callbackHandler.removeCallbacksAndMessages(null);
        Iterator<Dispatchable> it = this.dispatchables.iterator();
        while (it.hasNext()) {
            disposeDispatchable(it.next());
            it.remove();
        }
    }

    @Override // com.sinch.android.rtc.internal.service.dispatcher.Dispatcher
    public void dispatchOnThread(Dispatchable dispatchable) {
        CallbackHandler callbackHandler;
        Runner runner;
        this.dispatchables.add(dispatchable);
        if (this.mStopped) {
            callbackHandler = this.callbackHandler;
            runner = new Runner(dispatchable, false);
        } else {
            callbackHandler = this.callbackHandler;
            runner = new Runner(dispatchable, true);
        }
        callbackHandler.post(runner);
    }

    public void stop() {
        this.mStopped = true;
        removeAllDispatchables();
    }
}

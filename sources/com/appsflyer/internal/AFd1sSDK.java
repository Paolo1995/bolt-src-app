package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AFd1sSDK implements Runnable {
    final ExecutorService AFInAppEventParameterName;
    public Executor AFInAppEventType = Executors.newSingleThreadExecutor();
    private Timer afErrorLog = new Timer(true);
    public final List<AFd1uSDK> values = new CopyOnWriteArrayList();
    final Set<AFd1rSDK> AFKeystoreWrapper = new CopyOnWriteArraySet();
    final Set<AFd1rSDK> valueOf = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFd1pSDK<?>> afRDLog = new ConcurrentSkipListSet();
    final NavigableSet<AFd1pSDK<?>> afDebugLog = new ConcurrentSkipListSet();
    final List<AFd1pSDK<?>> AFLogger = new ArrayList();
    final Set<AFd1pSDK<?>> afInfoLog = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: com.appsflyer.internal.AFd1sSDK$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {
        private /* synthetic */ AFd1pSDK AFInAppEventType;

        public AnonymousClass3(AFd1pSDK aFd1pSDK) {
            this.AFInAppEventType = aFd1pSDK;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean add;
            boolean z7;
            synchronized (AFd1sSDK.this.afRDLog) {
                if (AFd1sSDK.this.afInfoLog.contains(this.AFInAppEventType)) {
                    StringBuilder sb = new StringBuilder("QUEUE: tried to add already running task: ");
                    sb.append(this.AFInAppEventType);
                    AFLogger.afDebugLog(sb.toString());
                    return;
                }
                if (!AFd1sSDK.this.afRDLog.contains(this.AFInAppEventType) && !AFd1sSDK.this.afDebugLog.contains(this.AFInAppEventType)) {
                    AFd1sSDK aFd1sSDK = AFd1sSDK.this;
                    AFd1pSDK aFd1pSDK = this.AFInAppEventType;
                    for (AFd1rSDK aFd1rSDK : aFd1pSDK.AFKeystoreWrapper) {
                        if (aFd1sSDK.valueOf.contains(aFd1rSDK)) {
                            aFd1pSDK.values.add(aFd1rSDK);
                        }
                    }
                    if (AFd1sSDK.this.AFKeystoreWrapper(this.AFInAppEventType)) {
                        add = AFd1sSDK.this.afRDLog.add(this.AFInAppEventType);
                    } else {
                        add = AFd1sSDK.this.afDebugLog.add(this.AFInAppEventType);
                        if (add) {
                            StringBuilder sb2 = new StringBuilder("QUEUE: new task was blocked: ");
                            sb2.append(this.AFInAppEventType);
                            AFLogger.afDebugLog(sb2.toString());
                            this.AFInAppEventType.AFInAppEventParameterName();
                        }
                    }
                    if (add) {
                        AFd1sSDK aFd1sSDK2 = AFd1sSDK.this;
                        aFd1sSDK2.afRDLog.addAll(aFd1sSDK2.AFLogger);
                        AFd1sSDK.this.AFLogger.clear();
                    } else {
                        StringBuilder sb3 = new StringBuilder("QUEUE: task not added, it's already in the queue: ");
                        sb3.append(this.AFInAppEventType);
                        AFLogger.afDebugLog(sb3.toString());
                    }
                    if (add) {
                        AFd1sSDK.this.valueOf.add(this.AFInAppEventType.AFInAppEventType);
                        StringBuilder sb4 = new StringBuilder("QUEUE: new task added: ");
                        sb4.append(this.AFInAppEventType);
                        AFLogger.afDebugLog(sb4.toString());
                        for (AFd1uSDK aFd1uSDK : AFd1sSDK.this.values) {
                        }
                        AFd1sSDK aFd1sSDK3 = AFd1sSDK.this;
                        aFd1sSDK3.AFInAppEventParameterName.submit(aFd1sSDK3);
                        AFd1sSDK aFd1sSDK4 = AFd1sSDK.this;
                        synchronized (aFd1sSDK4.afRDLog) {
                            for (int size = (aFd1sSDK4.afRDLog.size() + aFd1sSDK4.afDebugLog.size()) - 40; size > 0; size--) {
                                if (!aFd1sSDK4.afDebugLog.isEmpty()) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                boolean isEmpty = true ^ aFd1sSDK4.afRDLog.isEmpty();
                                if (isEmpty && z7) {
                                    if (aFd1sSDK4.afRDLog.first().compareTo(aFd1sSDK4.afDebugLog.first()) > 0) {
                                        aFd1sSDK4.AFKeystoreWrapper(aFd1sSDK4.afRDLog);
                                    } else {
                                        aFd1sSDK4.AFKeystoreWrapper(aFd1sSDK4.afDebugLog);
                                    }
                                } else if (isEmpty) {
                                    aFd1sSDK4.AFKeystoreWrapper(aFd1sSDK4.afRDLog);
                                } else if (z7) {
                                    aFd1sSDK4.AFKeystoreWrapper(aFd1sSDK4.afDebugLog);
                                }
                            }
                        }
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder("QUEUE: tried to add already pending task: ");
                    sb5.append(this.AFInAppEventType);
                    AFLogger.afWarnLog(sb5.toString());
                    return;
                }
                StringBuilder sb6 = new StringBuilder("QUEUE: tried to add already scheduled task: ");
                sb6.append(this.AFInAppEventType);
                AFLogger.afDebugLog(sb6.toString());
            }
        }
    }

    public AFd1sSDK(ExecutorService executorService) {
        this.AFInAppEventParameterName = executorService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.afRDLog) {
            final AFd1pSDK<?> pollFirst = this.afRDLog.pollFirst();
            if (pollFirst == null) {
                return;
            }
            this.afInfoLog.add(pollFirst);
            long valueOf = pollFirst.valueOf();
            AFd1oSDK aFd1oSDK = new AFd1oSDK(Thread.currentThread());
            if (valueOf > 0) {
                this.afErrorLog.schedule(aFd1oSDK, valueOf);
            }
            this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1sSDK.4
                @Override // java.lang.Runnable
                public final void run() {
                    for (AFd1uSDK aFd1uSDK : AFd1sSDK.this.values) {
                        aFd1uSDK.AFKeystoreWrapper(pollFirst);
                    }
                }
            });
            if (!this.afRDLog.isEmpty()) {
                this.AFInAppEventParameterName.submit(this);
            }
            try {
                AFLogger.afDebugLog("QUEUE: starting task execution: ".concat(String.valueOf(pollFirst)));
                final AFd1tSDK call = pollFirst.call();
                aFd1oSDK.cancel();
                this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1sSDK.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        StringBuilder sb = new StringBuilder("QUEUE: execution finished for ");
                        sb.append(pollFirst);
                        sb.append(", result: ");
                        sb.append(call);
                        AFLogger.afDebugLog(sb.toString());
                        AFd1sSDK.this.afInfoLog.remove(pollFirst);
                        for (AFd1uSDK aFd1uSDK : AFd1sSDK.this.values) {
                            aFd1uSDK.AFKeystoreWrapper(pollFirst, call);
                        }
                        if (call == AFd1tSDK.SUCCESS) {
                            AFd1sSDK.this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
                            AFd1sSDK.AFKeystoreWrapper(AFd1sSDK.this);
                        } else if (pollFirst.AFKeystoreWrapper()) {
                            synchronized (AFd1sSDK.this.afRDLog) {
                                AFd1sSDK.this.AFLogger.add(pollFirst);
                                for (AFd1uSDK aFd1uSDK2 : AFd1sSDK.this.values) {
                                }
                            }
                        } else {
                            AFd1sSDK.this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
                            AFd1sSDK.AFKeystoreWrapper(AFd1sSDK.this);
                        }
                    }
                });
            } catch (InterruptedIOException | InterruptedException unused) {
                AFLogger.afDebugLog("QUEUE: task was interrupted: ".concat(String.valueOf(pollFirst)));
                final AFd1tSDK aFd1tSDK = AFd1tSDK.TIMEOUT;
                pollFirst.valueOf = aFd1tSDK;
                this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1sSDK.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        StringBuilder sb = new StringBuilder("QUEUE: execution finished for ");
                        sb.append(pollFirst);
                        sb.append(", result: ");
                        sb.append(aFd1tSDK);
                        AFLogger.afDebugLog(sb.toString());
                        AFd1sSDK.this.afInfoLog.remove(pollFirst);
                        for (AFd1uSDK aFd1uSDK : AFd1sSDK.this.values) {
                            aFd1uSDK.AFKeystoreWrapper(pollFirst, aFd1tSDK);
                        }
                        if (aFd1tSDK == AFd1tSDK.SUCCESS) {
                            AFd1sSDK.this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
                            AFd1sSDK.AFKeystoreWrapper(AFd1sSDK.this);
                        } else if (pollFirst.AFKeystoreWrapper()) {
                            synchronized (AFd1sSDK.this.afRDLog) {
                                AFd1sSDK.this.AFLogger.add(pollFirst);
                                for (AFd1uSDK aFd1uSDK2 : AFd1sSDK.this.values) {
                                }
                            }
                        } else {
                            AFd1sSDK.this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
                            AFd1sSDK.AFKeystoreWrapper(AFd1sSDK.this);
                        }
                    }
                });
            } catch (Throwable unused2) {
                aFd1oSDK.cancel();
                final AFd1tSDK aFd1tSDK2 = AFd1tSDK.FAILURE;
                this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1sSDK.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        StringBuilder sb = new StringBuilder("QUEUE: execution finished for ");
                        sb.append(pollFirst);
                        sb.append(", result: ");
                        sb.append(aFd1tSDK2);
                        AFLogger.afDebugLog(sb.toString());
                        AFd1sSDK.this.afInfoLog.remove(pollFirst);
                        for (AFd1uSDK aFd1uSDK : AFd1sSDK.this.values) {
                            aFd1uSDK.AFKeystoreWrapper(pollFirst, aFd1tSDK2);
                        }
                        if (aFd1tSDK2 == AFd1tSDK.SUCCESS) {
                            AFd1sSDK.this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
                            AFd1sSDK.AFKeystoreWrapper(AFd1sSDK.this);
                        } else if (pollFirst.AFKeystoreWrapper()) {
                            synchronized (AFd1sSDK.this.afRDLog) {
                                AFd1sSDK.this.AFLogger.add(pollFirst);
                                for (AFd1uSDK aFd1uSDK2 : AFd1sSDK.this.values) {
                                }
                            }
                        } else {
                            AFd1sSDK.this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
                            AFd1sSDK.AFKeystoreWrapper(AFd1sSDK.this);
                        }
                    }
                });
            }
        }
    }

    final void AFKeystoreWrapper(NavigableSet<AFd1pSDK<?>> navigableSet) {
        AFd1pSDK<?> pollFirst = navigableSet.pollFirst();
        this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
        for (AFd1uSDK aFd1uSDK : this.values) {
            aFd1uSDK.AFInAppEventParameterName(pollFirst);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK) {
        return this.AFKeystoreWrapper.containsAll(aFd1pSDK.values);
    }

    static /* synthetic */ void AFKeystoreWrapper(AFd1sSDK aFd1sSDK) {
        synchronized (aFd1sSDK.afRDLog) {
            Iterator<AFd1pSDK<?>> it = aFd1sSDK.afDebugLog.iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                AFd1pSDK<?> next = it.next();
                if (aFd1sSDK.AFKeystoreWrapper(next)) {
                    it.remove();
                    aFd1sSDK.afRDLog.add(next);
                    z7 = true;
                }
            }
            if (z7) {
                aFd1sSDK.AFInAppEventParameterName.submit(aFd1sSDK);
            }
        }
    }
}

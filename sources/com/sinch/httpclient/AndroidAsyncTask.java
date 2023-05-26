package com.sinch.httpclient;

import android.os.AsyncTask;

/* loaded from: classes3.dex */
final class AndroidAsyncTask extends AsyncTask<Void, Void, Object> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private String mCancellationReason;
    private final AsyncTaskDelegate<Object> mDelegate;

    public AndroidAsyncTask(AsyncTaskDelegate<Object> asyncTaskDelegate) {
        this.mDelegate = asyncTaskDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean _isCancelled() {
        return super.isCancelled();
    }

    public final boolean cancel(boolean z7, String str) {
        synchronized (this) {
            this.mCancellationReason = str;
        }
        return super.cancel(z7);
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Void... voidArr) {
        return this.mDelegate.doInBackground(new AsyncTaskState() { // from class: com.sinch.httpclient.AndroidAsyncTask.1
            @Override // com.sinch.httpclient.AsyncTaskState
            public boolean isCancelled() {
                return AndroidAsyncTask.this._isCancelled();
            }
        });
    }

    @Override // android.os.AsyncTask
    public void onCancelled(Object obj) {
        String str;
        synchronized (this) {
            str = this.mCancellationReason;
        }
        this.mDelegate.onCancelled(obj, str);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        this.mDelegate.onPostExecute(obj);
    }
}

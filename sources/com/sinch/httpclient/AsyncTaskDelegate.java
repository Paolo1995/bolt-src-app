package com.sinch.httpclient;

/* loaded from: classes3.dex */
interface AsyncTaskDelegate<Result> {
    Result doInBackground(AsyncTaskState asyncTaskState);

    void onCancelled(Result result, String str);

    void onPostExecute(Result result);

    void onPreExecute();
}

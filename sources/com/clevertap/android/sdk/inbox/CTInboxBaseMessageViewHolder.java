package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.R$drawable;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class CTInboxBaseMessageViewHolder extends RecyclerView.ViewHolder {
    RelativeLayout A;
    FrameLayout B;
    RelativeLayout C;
    RelativeLayout D;
    private CTInboxMessageContent E;
    private CTInboxMessage F;
    private ImageView G;
    private WeakReference<CTInboxListViewFragment> H;
    private boolean I;

    /* renamed from: u  reason: collision with root package name */
    Context f11504u;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f11505v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f11506w;

    /* renamed from: x  reason: collision with root package name */
    FrameLayout f11507x;

    /* renamed from: y  reason: collision with root package name */
    ImageView f11508y;

    /* renamed from: z  reason: collision with root package name */
    ImageView f11509z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxBaseMessageViewHolder(@NonNull View view) {
        super(view);
    }

    private FrameLayout T() {
        return this.f11507x;
    }

    public boolean P(PlayerView playerView) {
        FrameLayout T;
        int i8;
        int round;
        float f8;
        if (!this.I || (T = T()) == null) {
            return false;
        }
        T.removeAllViews();
        T.setVisibility(8);
        Resources resources = this.f11504u.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (CTInboxActivity.f11495l == 2) {
            if (this.F.h().equalsIgnoreCase("l")) {
                i8 = Math.round(this.f11508y.getMeasuredHeight() * 1.76f);
                round = this.f11508y.getMeasuredHeight();
            } else {
                i8 = this.f11509z.getMeasuredHeight();
                round = i8;
            }
        } else {
            i8 = resources.getDisplayMetrics().widthPixels;
            if (this.F.h().equalsIgnoreCase("l")) {
                round = Math.round(i8 * 0.5625f);
            }
            round = i8;
        }
        playerView.setLayoutParams(new FrameLayout.LayoutParams(i8, round));
        T.addView(playerView);
        T.setBackgroundColor(Color.parseColor(this.F.a()));
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        final SimpleExoPlayer player = playerView.getPlayer();
        if (player != null) {
            f8 = player.getVolume();
        } else {
            f8 = 0.0f;
        }
        if (this.E.z()) {
            ImageView imageView = new ImageView(this.f11504u);
            this.G = imageView;
            imageView.setVisibility(8);
            if (f8 > 0.0f) {
                this.G.setImageDrawable(ResourcesCompat.f(this.f11504u.getResources(), R$drawable.ct_volume_on, null));
            } else {
                this.G.setImageDrawable(ResourcesCompat.f(this.f11504u.getResources(), R$drawable.ct_volume_off, null));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, displayMetrics), (int) TypedValue.applyDimension(1, 30.0f, displayMetrics));
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, displayMetrics), (int) TypedValue.applyDimension(1, 2.0f, displayMetrics), 0);
            layoutParams.gravity = 8388613;
            this.G.setLayoutParams(layoutParams);
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    float f9;
                    SimpleExoPlayer simpleExoPlayer = player;
                    if (simpleExoPlayer != null) {
                        f9 = simpleExoPlayer.getVolume();
                    } else {
                        f9 = 0.0f;
                    }
                    int i9 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
                    if (i9 > 0) {
                        player.setVolume(0.0f);
                        CTInboxBaseMessageViewHolder.this.G.setImageDrawable(ResourcesCompat.f(CTInboxBaseMessageViewHolder.this.f11504u.getResources(), R$drawable.ct_volume_off, null));
                    } else if (i9 == 0) {
                        SimpleExoPlayer simpleExoPlayer2 = player;
                        if (simpleExoPlayer2 != null) {
                            simpleExoPlayer2.setVolume(1.0f);
                        }
                        CTInboxBaseMessageViewHolder.this.G.setImageDrawable(ResourcesCompat.f(CTInboxBaseMessageViewHolder.this.f11504u.getResources(), R$drawable.ct_volume_on, null));
                    }
                }
            });
            T.addView(this.G);
        }
        playerView.requestFocus();
        playerView.setShowBuffering(0);
        DefaultBandwidthMeter build = new DefaultBandwidthMeter.Builder(this.f11504u).build();
        Context context = this.f11504u;
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getPackageName()), build);
        String n8 = this.E.n();
        if (n8 != null) {
            HlsMediaSource createMediaSource = new HlsMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(n8));
            if (player != null) {
                player.prepare(createMediaSource);
                if (this.E.u()) {
                    playerView.showController();
                    player.setPlayWhenReady(false);
                    player.setVolume(1.0f);
                } else if (this.E.z()) {
                    player.setPlayWhenReady(true);
                    player.setVolume(f8);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Q(long j8) {
        StringBuilder sb;
        String str;
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j8;
        int i8 = (currentTimeMillis > 60L ? 1 : (currentTimeMillis == 60L ? 0 : -1));
        if (i8 < 0) {
            return "Just Now";
        }
        if (i8 > 0 && currentTimeMillis < 3540) {
            return (currentTimeMillis / 60) + " mins ago";
        } else if (currentTimeMillis > 3540 && currentTimeMillis < 81420) {
            long j9 = currentTimeMillis / 3600;
            if (j9 > 1) {
                sb = new StringBuilder();
                sb.append(j9);
                str = " hours ago";
            } else {
                sb = new StringBuilder();
                sb.append(j9);
                str = " hour ago";
            }
            sb.append(str);
            return sb.toString();
        } else if (currentTimeMillis > 86400 && currentTimeMillis < 172800) {
            return "Yesterday";
        } else {
            return new SimpleDateFormat("dd MMM").format(new Date(j8 * 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(CTInboxMessage cTInboxMessage, CTInboxListViewFragment cTInboxListViewFragment, int i8) {
        this.f11504u = cTInboxListViewFragment.getContext();
        this.H = new WeakReference<>(cTInboxListViewFragment);
        this.F = cTInboxMessage;
        boolean z7 = false;
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.f().get(0);
        this.E = cTInboxMessageContent;
        this.I = (cTInboxMessageContent.u() || this.E.z()) ? true : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int S() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxListViewFragment U() {
        return this.H.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(Button button, Button button2, Button button3) {
        button3.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3.0f));
        button3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(Button button, Button button2, Button button3) {
        button2.setVisibility(8);
        button3.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 6.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
        button3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    public boolean X() {
        return this.I;
    }

    public void Y() {
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FrameLayout T = T();
        if (T != null) {
            T.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(ImageView[] imageViewArr, int i8, Context context, LinearLayout linearLayout) {
        for (int i9 = 0; i9 < i8; i9++) {
            ImageView imageView = new ImageView(context);
            imageViewArr[i9] = imageView;
            imageView.setVisibility(0);
            imageViewArr[i9].setImageDrawable(ResourcesCompat.f(context.getResources(), R$drawable.ct_unselected_dot, null));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(8, 6, 4, 6);
            layoutParams.gravity = 17;
            if (linearLayout.getChildCount() < i8) {
                linearLayout.addView(imageViewArr[i9], layoutParams);
            }
        }
    }

    public boolean a0() {
        return this.E.z();
    }
}

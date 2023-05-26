package ee.mtakso.voip_client;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.webrtc.MediaStreamTrack;

/* compiled from: VoipBluetoothManager.kt */
/* loaded from: classes5.dex */
public final class VoipBluetoothManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36498a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipLogger f36499b;

    /* renamed from: c  reason: collision with root package name */
    private final BluetoothAdapter f36500c;

    /* renamed from: d  reason: collision with root package name */
    private BluetoothHeadset f36501d;

    /* renamed from: e  reason: collision with root package name */
    private final VoipBluetoothManager$profileListener$1 f36502e;

    /* renamed from: f  reason: collision with root package name */
    private final VoipBluetoothManager$broadcastReceiver$1 f36503f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36504g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36505h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36506i;

    /* JADX WARN: Type inference failed for: r2v2, types: [ee.mtakso.voip_client.VoipBluetoothManager$profileListener$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [ee.mtakso.voip_client.VoipBluetoothManager$broadcastReceiver$1] */
    public VoipBluetoothManager(Context context, VoipLogger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(logger, "logger");
        this.f36498a = context;
        this.f36499b = logger;
        this.f36500c = BluetoothAdapter.getDefaultAdapter();
        this.f36502e = new BluetoothProfile.ServiceListener() { // from class: ee.mtakso.voip_client.VoipBluetoothManager$profileListener$1
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
                if (i8 == 1) {
                    VoipBluetoothManager.this.f(bluetoothProfile);
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i8) {
                if (i8 == 1) {
                    VoipBluetoothManager.this.g();
                }
            }
        };
        this.f36503f = new BroadcastReceiver() { // from class: ee.mtakso.voip_client.VoipBluetoothManager$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action;
                if (intent != null && (action = intent.getAction()) != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1692127708) {
                        if (hashCode == 545516589 && action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                            VoipBluetoothManager.this.h(intent);
                        }
                    } else if (action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                        VoipBluetoothManager.this.i(intent);
                    }
                }
            }
        };
        this.f36505h = true;
    }

    private final AudioManager e() {
        Object systemService = this.f36498a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(BluetoothProfile bluetoothProfile) {
        BluetoothHeadset bluetoothHeadset = null;
        if (this.f36504g) {
            if (bluetoothProfile instanceof BluetoothHeadset) {
                bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
            }
            this.f36501d = bluetoothHeadset;
            l();
            return;
        }
        BluetoothAdapter bluetoothAdapter = this.f36500c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.closeProfileProxy(1, bluetoothProfile);
        }
        this.f36501d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Intent intent) {
        if (intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1) == 2) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Intent intent) {
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        if (intExtra != -1) {
            if (intExtra != 0) {
                if (intExtra == 1) {
                    this.f36499b.c("Sco audio connected", new Object[0]);
                    return;
                }
                return;
            }
            this.f36499b.c("Sco audio disconnected", new Object[0]);
            this.f36506i = false;
            l();
            return;
        }
        this.f36499b.d("Sco audio state error", new Object[0]);
        this.f36506i = false;
        l();
    }

    private final void l() {
        boolean z7;
        BluetoothHeadset bluetoothHeadset;
        List<BluetoothDevice> connectedDevices;
        if (!this.f36504g) {
            return;
        }
        if (this.f36505h) {
            try {
                bluetoothHeadset = this.f36501d;
            } catch (SecurityException unused) {
            }
            if (bluetoothHeadset != null && (connectedDevices = bluetoothHeadset.getConnectedDevices()) != null) {
                z7 = connectedDevices.isEmpty();
                if (this.f36506i && !z7) {
                    this.f36506i = true;
                    this.f36499b.c("start bluetooth Sco", new Object[0]);
                    e().startBluetoothSco();
                    e().setBluetoothScoOn(true);
                    return;
                }
            }
            z7 = true;
            if (this.f36506i) {
            }
        } else if (this.f36506i) {
            e().stopBluetoothSco();
            e().setBluetoothScoOn(false);
        }
    }

    public final void j() {
        boolean z7;
        if (this.f36504g) {
            return;
        }
        if (!e().isBluetoothScoAvailableOffCall()) {
            this.f36499b.d("Bluetooth SCO unavailable off call", new Object[0]);
            return;
        }
        this.f36504g = true;
        BluetoothAdapter bluetoothAdapter = this.f36500c;
        if (bluetoothAdapter != null) {
            z7 = bluetoothAdapter.getProfileProxy(this.f36498a, this.f36502e, 1);
        } else {
            z7 = false;
        }
        if (!z7) {
            this.f36499b.d("Failed to get Bluetooth Headset profile", new Object[0]);
            this.f36504g = false;
            return;
        }
        Context context = this.f36498a;
        VoipBluetoothManager$broadcastReceiver$1 voipBluetoothManager$broadcastReceiver$1 = this.f36503f;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        Unit unit = Unit.f50853a;
        context.registerReceiver(voipBluetoothManager$broadcastReceiver$1, intentFilter);
        l();
    }

    public final void k() {
        BluetoothAdapter bluetoothAdapter;
        if (!this.f36504g) {
            return;
        }
        this.f36504g = false;
        BluetoothHeadset bluetoothHeadset = this.f36501d;
        if (bluetoothHeadset != null && (bluetoothAdapter = this.f36500c) != null) {
            bluetoothAdapter.closeProfileProxy(1, bluetoothHeadset);
        }
        this.f36501d = null;
        this.f36498a.unregisterReceiver(this.f36503f);
        this.f36506i = false;
        e().stopBluetoothSco();
        e().setBluetoothScoOn(false);
    }

    public final void m(boolean z7) {
        VoipLogger voipLogger = this.f36499b;
        voipLogger.c("updateEnabled: " + z7, new Object[0]);
        this.f36505h = z7;
        l();
    }
}

# AutoService<br>
#####采用广播机制来实现开机自启服务<br>
----
1.编写服务<br>
```java
public class ListenService extends Service {
    
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //在此添加服务中要执行的操作
        //showNotification();
    }
}
```
2.广播接收器，接收系统启动广播<br>
```java
public class AutoServiceBroadReceiver extends BroadcastReceiver {

	private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent) {

		if (ACTION_BOOT.equals(intent.getAction())) {

			Intent myIntent = new Intent(context, ListenService.class);
			context.startService(myIntent);

		}

	}
}
```
3.在AndroidManifest.xml文件中进行注册<br>
```xml
<service
    android:name=".ListenService"
    android:process=":remote" >
</service>

<receiver android:name="com.example.autoservice.AutoServiceBroadReceiver" >
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED" >
         </action>
    </intent-filter>
</receiver>
```
4.添加权限<br>
```xml
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
```

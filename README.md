## 百度语音识别/语音合成服务本地化部署

## 基于Android Studio开发集成

### step1: 项目根目录build.gradle文件allprojects节点添加配置

```bash
allprojects {
   repositories {
       ...yours...
       maven { url 'https://jitpack.io' } //使用GitHub仓库
   }
}
```


### step2： app根目录build.gradle添加依赖

```bash
dependencies {
   ...yours...
   implementation 'com.github.hezh-0617:MjxxSDK:native_1.0.10' //添加依赖
}
```


### step3：目标入口处添加代码
```bash
Config config = new Config();
config.setShowLog(true);  //是否打印日志
config.setWriteLog(true); //是否保存日志文件，true则输出日志到 手机储存/MjxxSdkLogs/

config.setAsrServerUrl(""); // 语音识别服务器地址
config.setAsrPid(Integer.parseInt("");  //选填，默认888
config.setAsrLongRecordEnable(true);  //asr收否支持长时间录音
config.setAsrSaveRecord(true);  //是否保存asr录音文件，true则保存到 手机储存/MUSIC/baidu_asr/

config.setTtsServerUrl("");  // 语音合成服务器地址
config.setWebServerUrl(""); //web host
config.setRemoteServerHost(""); //如需代理，请配置我方业务服务器Host
SpeechSDK.startSpeech(context,config);
```


### step3.1 fragment方式接入
```bash
SpeechFragment fragment = SpeechFragment.newInstance(config);
fragment.setOnCloseCallListener(new OnCloseCallListener() {
    public void onCloseCall() {
         SpeechActivity.this.finish();  //你期望的处理方式
    }
});
getSupportFragmentManager().beginTransaction().replace(id.frame, fragment).commitAllowingStateLoss(); //你期望的处理方式
```

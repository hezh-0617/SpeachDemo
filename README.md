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
   implementation 'com.github.hezh-0617:MjxxSDK:native_1.0.4' //添加依赖
}
```


### step3：目标入口处添加代码
```bash
Config config = new Config();
config.setShowLog(true);  //是否打印日志
//以下参数由服务方提供：
config.setAsrServerUrl(""); // 语音识别服务器地址
config.setTtsServerUrl("");  // 语音合成服务器地址
config.setWebServerUrl("");  // 网页链接
config.setAsrPid(888);  // asrPID，非必填
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

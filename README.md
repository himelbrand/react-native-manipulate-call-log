# React Native Forward Calls
Android's Native call logs manipulator in React Native

## Installation

```bash
npm install react-native-manipulate-call-log --save
```
## Add permissions
* In `AndroidManifest.xml` add:
```xml

<uses-permission android:name="android.permission.WRITE_CALL_LOG"/>
```
## Project setup and initialization auto
```bash
react-native link
```
## Project setup and initialization manually 

* In `android/settings.gradle`

```gradle
...
include ':react-native-manipulate-call-log', ':app'
project(':react-native-manipulate-call-log').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-forward-calls/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    /* YOUR DEPENDENCIES HERE */
    compile project(':react-native-manipulate-call-log') // <--- add this
}

```

* Register Module (in MainApplication.java)

```java
import com.himelbrand.calllogs.RNManipulateCallLogPackage;  // <--- import

public class MainActivity extends ReactActivity {
  ......

  @Override
  protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new RNManipulateCallLogPackage() // <--- Add this
      );
  }

  ......

}
```


## Usage

#### Import

```javascript
import CallLogs from 'react-native-manipulate-call-log'
```

#### Add call log at current time 

```javascript
CallLogs.addIncomingCallLog('123456789',30)//adds an incoming call log, at:now from:123456789 duration:30sec
CallLogs.addMissedCallLog('123456789')//adds an missed call log, at:now from:123456789
```

#### Add call log at specific time 

```javascript
CallLogs.addIncomingCallLogAt('123456789',30,1493752942000)//adds an incoming call log, at:05/02/2017-22:22:22 from:123456789 duration:30sec
CallLogs.addMissedCallLogAt('123456789',1493752942000)//adds an missed call log, at:05/02/2017-22:22:22 from:123456789
```


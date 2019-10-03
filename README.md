# react-native-open-settings

## Install

### YARN
```
yarn add https://github.com/OurCnC/react-native-open-settings
```

### NPM
```
npm i -S https://github.com/OurCnC/react-native-open-settings
```

## Linking (for React Native <= 0.59 only, React Native >= 0.60 skip this as auto-linking should work)

### iOS
Add `React Native Open Settings` to project libraries.

### Android

- Edit `build.gradle` to look like this:
```java
apply plugin: 'com.android.application'

android {
  ...
}

dependencies {
  ...
+ compile project(':react-native-open-settings')
}
```

- In `settings.gradle`, insert the following code:
```java
include ':react-native-open-settings'
project(':react-native-open-settings').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-open-settings/android')
```

- Edit your `MainActivity.java` to look like this:
```java
package com.myapp;

....
import com.opensettings.OpenSettingsPackage

public class MainActivity extends extends ReactActivity {

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new OpenSettingsPackage()
        );
    }
    ...
}
```

## Usage

Require the `react-native-open-settings` module.

```javascript
import OpenSettings from 'react-native-open-settings';
```

And then, where you want to open the settings, just do
```javascript
OpenSettings.openSettings()
```

Have fun!

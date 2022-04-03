
# Compose QRCode Scanner

This is a useful module to use CameraX and create a QRCode scanner for Compose applications.
Composable function uses AndroidView https://developer.android.com/jetpack/compose/interop/interop-apis to load CameraX feature.
When a Qrcode is framed an orverlay (a shape green) is created.
It is possibble use camera flash to help scanning



### Technology 🔮
- Kotlin DSL
- Android Jetpack Compose
- Compose app permissions
- CameraX and Camera2

* Add scanner is very simple, add composable function and set a closeScanListener to close scanner and get your cod

    ```kotlin

        BuildCameraUI (closeScanListener = {
           // to close scanner hide composable function
        }){ qrcode ->

            // check code
        }

    ```

### Contributions ♥️

Every contributors are welcome. We are using [this convention](https://www.conventionalcommits.org/en/v1.0.0/).


| Open Scan | Permissions  | Scanner |
| ------------------ | --------------------------- | ------------------ |
|<img src="https://github.com/giuseppesorce/composescanner/blob/master/screen1.png" height="400" alt="Screenshot"/> | <img src="https://github.com/giuseppesorce/composescanner/blob/master/screen3.png" height="400" alt="Screenshot"/>  | <img src="https://github.com/giuseppesorce/composescanner/blob/master/screen4.png" height="400" alt="Screenshot"/> |




### License
```
Copyright 2022 Giuseppe Sorce
 
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
 
     http://www.apache.org/licenses/LICENSE-2.0  
 
Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.
```
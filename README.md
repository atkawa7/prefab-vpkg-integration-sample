## Prefab Vpkg Integration Sample

## Checkout getting started on vcpkg https://github.com/microsoft/vcpkg

*** This requires android studio version 4.0 and above***

### install all support android triplets for a package.

```
vcpkg install jsoncpp --triplet arm64-android
vcpkg install jsoncpp --triplet arm-android
vcpkg install jsoncpp --triplet x64-android
vcpkg install jsoncpp --triplet x86-android
```

### Then export using the following.

```
vcpkg export jsoncpp --triplet x86-android  --prefab


```

In app/build.gradle

Add files

```
   implementation 'com.vcpkg.ndk.support:jsoncpp:1.9.2'
```

And cmake flags 

```
externalNativeBuild {
            cmake {
                arguments '-DANDROID_STL=c++_shared'
                cppFlags "-std=c++17"
            }
        }
```

In  gradle.properties
```
# Enables Prefab
android.enablePrefab=true
# Work around https://issuetracker.google.com/149575364
android.enableParallelJsonGen=false
# 4.0.0 canary 9 defaults to Prefab 1.0.0-alpha3, which is not the latest.
android.prefabVersion=1.0.0-alpha5
```

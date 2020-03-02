#include <jni.h>
#include <string>
#include "json/json.h"



extern "C"
JNIEXPORT jstring JNICALL
Java_io_atkawa7_prefab_sample_User_convertToJson(JNIEnv *env, jobject thiz, jstring first_name,
                                                 jstring last_name) {
    const char * _first_name = env->GetStringUTFChars(first_name, nullptr) ;
    const char * _last_name  = env->GetStringUTFChars(last_name, nullptr);
    // TODO: implement convertToJson()
    Json::Value root;

    root["first_name"] =  _first_name;
    root["last_name"] = _last_name;

    Json::FastWriter writer;
    std::string json_file = writer.write(root);


    return env->NewStringUTF(json_file.c_str());
}
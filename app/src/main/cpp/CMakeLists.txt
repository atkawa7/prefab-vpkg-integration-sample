cmake_minimum_required(VERSION 3.6)
project(native-lib VERSION 1.0.0 LANGUAGES CXX)

if(NOT CMAKE_BUILD_TYPE)
    set(CMAKE_BUILD_TYPE "Release")
endif()

find_package(jsoncpp REQUIRED CONFIG)
find_library(ANDROID_LOG_LIBRARY log )

get_target_property(JSONCPP_INCLUDES jsoncpp::jsoncpp INTERFACE_INCLUDE_DIRECTORIES)

include_directories(${JSONCPP_INCLUDES})

add_library(native-lib SHARED native-lib.cpp)
target_link_libraries(native-lib jsoncpp::jsoncpp ${ANDROID_LOG_LIBRARY})
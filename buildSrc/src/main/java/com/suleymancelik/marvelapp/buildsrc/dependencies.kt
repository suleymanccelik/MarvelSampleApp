package com.suleymancelik.marvelapp.buildsrc

object Versions {
    const val ktlint = "0.33.0"
    const val realm = "10.5.0"
}

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.2"
    const val realmGradlePlugin = "io.realm:realm-gradle-plugin:${Versions.realm}"

    const val mvRx = "com.airbnb.android:mavericks:2.3.0"

    const val junit = "junit:junit:4.12"
    const val robolectric = "org.robolectric:robolectric:4.3.1"
    const val mockK = "io.mockk:mockk:1.9.3"

    const val timber = "com.jakewharton.timber:timber:5.0.1"

    object Google {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object Kotlin {
        private const val version = "1.5.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
        const val browser = "androidx.browser:browser:1.3.0"
        const val collection = "androidx.collection:collection-ktx:1.1.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0"

        object Navigation {
            private const val version = "2.3.5"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Fragment {
            private const val version = "1.3.6"
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Activity {
            private const val version = "1.2.4"
            const val activityKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            const val junitX = "androidx.test.ext:junit:1.1.1"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }

        const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"

        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"

        const val coreKtx = "androidx.core:core-ktx:1.6.0"

        object Lifecycle {
            private const val version = "2.3.1"
            const val runtime = "androidx.lifecycle:lifecycle-runtime:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val common = "androidx.lifecycle:lifecycle-common-java8:$version"
        }
    }

    object Dagger {
        private const val version = "2.34"
        const val dagger = "com.google.dagger:dagger:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object OkHttp {
        private const val version = "4.9.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object ePoxy {
        private const val version = "4.6.1"
        const val epoxy = "com.airbnb.android:epoxy:$version"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:$version"
        const val epoxyPaging = "com.airbnb.android:epoxy-paging:$version"
    }

    object Coil {
        private const val version = "1.0.0"
        const val coil = "io.coil-kt:coil:$version"
    }
}
package app.nexustracker.android.feature_trips.data.remote.util

import java.io.InputStreamReader

class MockResponseFileReader(path: String) {
    val content: String
    init {
        val reader = InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}
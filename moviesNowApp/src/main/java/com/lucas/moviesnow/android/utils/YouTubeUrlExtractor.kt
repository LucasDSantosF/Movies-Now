package com.lucas.moviesnow.android.utils

import kotlin.text.Regex

object YouTubeUrlExtractor {
    private val youTubeUrlRegex = Regex(
        "^https?://.*(?:youtu.be/|v/|e/|embed/|watch\\?v=|watch\\?.+&v=)([^&\\n?#]+)",
        RegexOption.IGNORE_CASE
    )

    fun extractVideoId(youtubeUrl: String?): String? {
        if (youtubeUrl.isNullOrBlank()) {
            return null
        }

        val matchResult = youTubeUrlRegex.find(youtubeUrl)
        return matchResult?.groupValues?.getOrNull(1)
    }
}
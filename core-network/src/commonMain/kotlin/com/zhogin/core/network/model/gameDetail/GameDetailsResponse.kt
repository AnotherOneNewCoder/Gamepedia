package com.zhogin.core.network.model.gameDetail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDetailsResponse(
//    @SerialName("achievements_count")
//    val achievementsCount: Int,
//    @SerialName("added")
//    val added: Int,
//    @SerialName("added_by_status")
//    val addedByStatus: AddedByStatusDTO,
//    @SerialName("additions_count")
//    val additionsCount: Int,
//    @SerialName("alternative_names")
//    val alternativeNames: List<String>,
//    @SerialName("background_image")
//    val backgroundImage: String,
//    @SerialName("background_image_additional")
//    val backgroundImageAdditional: String?,
//    @SerialName("creators_count")
//    val creatorsCount: Int,
//    @SerialName("description")
//    val description: String,
//    @SerialName("description_raw")
//    val descriptionRaw: String,
//    @SerialName("developers")
//    val developers: List<DeveloperDTO>,
//    @SerialName("dominant_color")
//    val dominantColor: String,
//    @SerialName("esrb_rating")
//    val esrbRating: EsrbRatingDTO,
//    @SerialName("game_series_count")
//    val gameSeriesCount: Int,
//    @SerialName("genres")
//    val genres: List<GenreDTO>,
//    @SerialName("id")
//    val id: Int,
//    @SerialName("movies_count")
//    val moviesCount: Int,
//    @SerialName("name")
//    val name: String,
//    @SerialName("name_original")
//    val nameOriginal: String,
//    @SerialName("parent_achievements_count")
//    val parentAchievementsCount: Int,
//    @SerialName("parent_platforms")
//    val parentPlatforms: List<ParentPlatformDTO>,
//    @SerialName("parents_count")
//    val parentsCount: Int,
//    @SerialName("platforms")
//    val platforms: List<PlatformXDTO>,
//    @SerialName("playtime")
//    val playtime: Int,
//    @SerialName("publishers")
//    val publishers: List<PublisherDTO>,
//    @SerialName("rating")
//    val rating: Double,
//    @SerialName("rating_top")
//    val ratingTop: Int,
//    @SerialName("ratings")
//    val ratings: List<RatingDTO>,
//    @SerialName("ratings_count")
//    val ratingsCount: Int,
//    @SerialName("reddit_count")
//    val redditCount: Int,
//    @SerialName("reddit_description")
//    val redditDescription: String,
//    @SerialName("reddit_logo")
//    val redditLogo: String,
//    @SerialName("reddit_name")
//    val redditName: String,
//    @SerialName("reddit_url")
//    val redditUrl: String,
//    @SerialName("released")
//    val released: String,
//    @SerialName("reviews_count")
//    val reviewsCount: Int,
//    @SerialName("reviews_text_count")
//    val reviewsTextCount: Int,
//    @SerialName("saturated_color")
//    val saturatedColor: String,
//    @SerialName("screenshots_count")
//    val screenshotsCount: Int,
//    @SerialName("slug")
//    val slug: String,
//    @SerialName("stores")
//    val stores: List<StoreDTO>,
//    @SerialName("suggestions_count")
//    val suggestionsCount: Int,
//    @SerialName("tags")
//    val tags: List<TagDTO>,
//    @SerialName("tba")
//    val tba: Boolean,
//    @SerialName("twitch_count")
//    val twitchCount: Int,
//    @SerialName("updated")
//    val updated: String,
//    @SerialName("user_game")
//    val userGame: String?,
//    @SerialName("website")
//    val website: String,
//    @SerialName("youtube_count")
//    val youtubeCount: Int
    val achievements_count: Int,
    val added: Int,
    //val added_by_status: AddedByStatusDTO?,
    val additions_count: Int,
    val alternative_names: List<String>,
    val background_image: String,
    val background_image_additional: String?,
    val creators_count: Int,
    val description: String,
    val description_raw: String,
    val developers: List<DeveloperDTO>,
    val dominant_color: String,
    //val esrb_rating: EsrbRatingDTO,
    val game_series_count: Int,
    val genres: List<GenreDTO>,
    val id: Int,
    val movies_count: Int,
    val name: String,
    val name_original: String,
    val parent_achievements_count: Int,
    val parent_platforms: List<ParentPlatformDTO>,
    val parents_count: Int,
    val platforms: List<PlatformXDTO>,
    val playtime: Int,
    val publishers: List<PublisherDTO>,
    val rating: Double,
    val rating_top: Int,
    val ratings: List<RatingDTO>,
    val ratings_count: Int,
    val reddit_count: Int,
    val reddit_description: String,
    val reddit_logo: String,
    val reddit_name: String,
    val reddit_url: String,
    val released: String?,
    val reviews_count: Int,
    val reviews_text_count: Int,
    val saturated_color: String,
    val screenshots_count: Int,
    val slug: String,
    val stores: List<StoreDTO>,
    val suggestions_count: Int,
    val tags: List<TagDTO>,
    val tba: Boolean,
    val twitch_count: Int,
    val updated: String,
    val user_game: String?,
    val website: String,
    val youtube_count: Int
)